// Bardzo prosty przykład użycia klasy Formatter
import java.util.*; 
 
class FormatDemo { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
 
    fmt.format("Formatowanie %s jest bardzo proste: %d %f", "w Javie", 10, 98.6); 
 
    System.out.println(fmt);
    
    fmt.close();
  } 
}
