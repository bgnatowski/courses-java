// Demonstruje użycie specyfikatora precyzji
import java.util.*; 
 
class PrecisionDemo { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
 
    // Formatuje cztery miejsca po przecinku
    fmt.format("%.4f", 123.1234567); 
    System.out.println(fmt); 
    fmt.close();
 
    // Formatuje dwa miejsca po przecinku w 16-znakowym polu
    fmt = new Formatter(); 
    fmt.format("%16.2e", 123.1234567); 
    System.out.println(fmt); 
    fmt.close();
 
    // Wyświetla najwyżej 15 znaków łańcucha
    fmt = new Formatter(); 
    fmt.format("%.15s", "Formatowanie w Javie jest teraz bardzo proste."); 
    System.out.println(fmt); 
    fmt.close();
  } 
}
