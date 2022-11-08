import java.lang.annotation.*;
import java.lang.reflect.*;

// Deklaracja typu adnotacji
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String str();
  int val();
}

class Meta {

  // Adnotacja metody
  @MyAnno(str = "Przykładowa adnotacja", val = 100)
  public static void myMeth() {
    Meta ob = new Meta();

    // Pobranie adnotacji dla tej metody i
    // wyświetlenie wartości jej składowych
    try {
      // Najpierw pobierz obiekt Class reprezentujący
      // aktualną klasę
      Class c = ob.getClass();

      // Pobierz obiekt Method reprezentujący
      // aktualną metodę
      Method m = c.getMethod("myMeth");

      // Następnie pobierz adnotację dla tej metody
      MyAnno anno = m.getAnnotation(MyAnno.class);

      // Wyświetl wartości adnotacji
      System.out.println(anno.str() + " " + anno.val());
    } catch (NoSuchMethodException exc) {
       System.out.println("Nie znaleziono metody.");
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}
