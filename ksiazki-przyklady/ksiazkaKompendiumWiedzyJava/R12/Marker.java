import java.lang.annotation.*;
import java.lang.reflect.*;

// Adnotacja znacznikowa
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker { }
class Marker {

  // Użycie znacznika dla metody
  // Zauważ, iż nie są wymagane nawiasy
  @MyMarker
  public static void myMeth() {
    Marker ob = new Marker();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      // Sprawdzenie istnienia adnotacji znacznikowej
      if(m.isAnnotationPresent(MyMarker.class))
        System.out.println("Adnotacja MyMarker istnieje.");

    } catch (NoSuchMethodException exc) {
       System.out.println("Nie znaleziono metody.");
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}
