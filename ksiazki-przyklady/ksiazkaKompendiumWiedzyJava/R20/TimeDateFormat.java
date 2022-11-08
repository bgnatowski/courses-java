// Formatowanie daty i czasu 
import java.util.*; 
 
class TimeDateFormat { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
    Calendar cal = Calendar.getInstance(); 
 
    // Wyświetla czas w domyślnym formacie 12-godzinnym
    fmt.format("%tr", cal); 
    System.out.println(fmt);
    fmt.close();
 
    // Wyświetla kompletne informacje o dacie i godzinie
    fmt = new Formatter(); 
    fmt.format("%tc", cal); 
    System.out.println(fmt); 
    fmt.close();
 
    // Wyświetla samą godzinę i minuty
    fmt = new Formatter(); 
    fmt.format("%tl:%tM", cal, cal); 
    System.out.println(fmt); 
    fmt.close();
 
    // Wyświetla nazwę i numer miesiąca
    fmt = new Formatter(); 
    fmt.format("%tB %tb %tm", cal, cal, cal); 
    System.out.println(fmt); 
    fmt.close();
  } 
}
