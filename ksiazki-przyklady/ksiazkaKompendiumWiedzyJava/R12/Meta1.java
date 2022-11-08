import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String str();
  int val();
}

class Meta1 {

  // Metoda myMeth ma teraz dwa parametry
  @MyAnno(str = "Dwa parametry", val = 19)
  public static void myMeth(String str, int i)
  {
    Meta1 ob = new Meta1();

    try {
      Class<?> c = ob.getClass();

      // Tutaj pojawia się określenie typów parametrów
      Method m = c.getMethod("myMeth", String.class, int.class);

      MyAnno anno = m.getAnnotation(MyAnno.class);

      System.out.println(anno.str() + " " + anno.val());
    } catch (NoSuchMethodException exc) {
       System.out.println("Nie znaleziono metody.");
    }
  }

  public static void main(String args[]) {
    myMeth("test", 10);
  }
}
