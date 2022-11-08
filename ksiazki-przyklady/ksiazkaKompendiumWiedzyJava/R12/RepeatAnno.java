// Prezentacja adnotacji powtarzalnych

import java.lang.annotation.*; 
import java.lang.reflect.*; 

// Zapewnia możliwość powtarzania adnotacji MyAnno
@Retention(RetentionPolicy.RUNTIME)  
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno { 
  String str() default "Testujemy"; 
  int val() default 9000; 
} 

// To jest adnotacja kontenera
@Retention(RetentionPolicy.RUNTIME)  
@interface MyRepeatedAnnos { 
  MyAnno[] value(); 
} 
 
class RepeatAnno { 
 
  // Do myMeth() dodawane są dwie adnotacje MyAnno
  @MyAnno(str = "Pierwsza adnotacja", val = -1) 
  @MyAnno(str = "Druga adnotacja", val = 100) 
  public static void myMeth(String str, int i)  
  { 
    RepeatAnno ob = new RepeatAnno(); 
 
    try { 
      Class<?> c = ob.getClass(); 
 
      // Pobiera adnotacje dotyczące metody myMeth()
      Method m = c.getMethod("myMeth", String.class, int.class); 
 
      // Wyświetla powtórzone adnotacje MyAnno
      Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);  
      System.out.println(anno); 

    } catch (NoSuchMethodException exc) { 
       System.out.println("Nie znaleziono metody."); 
    } 
  } 
 
  public static void main(String args[]) { 
    myMeth("test", 10); 
  } 
}
