// Przykład użycia indeksów względnych do uproszczenia
// tworzenia niestandardowego formatu daty i czasu 
import java.util.*; 
 
class FormatDemo6 { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
    Calendar cal = Calendar.getInstance(); 
 
    fmt.format("Jest %te. dzień miesiąca %<tB roku %<tY.", cal); 
    System.out.println(fmt);
    fmt.close();
  } 
}
