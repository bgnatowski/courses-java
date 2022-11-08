import java.lang.annotation.*;
import java.lang.reflect.*;

// Adnotacja jednoelementowa
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
  int value(); // Składowa musi mieć nazwę value
}

class Single {

  // Oznaczenie metody adnotacją jednoelementową
  @MySingle(100)
  public static void myMeth() {
    Single ob = new Single();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      MySingle anno = m.getAnnotation(MySingle.class);

      System.out.println(anno.value()); // Wyświetla 100

    } catch (NoSuchMethodException exc) {
       System.out.println("Nie znaleziono metody.");
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}
