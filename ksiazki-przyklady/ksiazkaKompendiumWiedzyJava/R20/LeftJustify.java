// Demonstruje justowanie do lewej krawędzi
import java.util.*; 
 
class LeftJustify { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
 
    // Domyślne justowanie do prawej
    fmt.format("|%10.2f|", 123.123); 
    System.out.println(fmt);
    fmt.close();
 
    // A teraz justowanie do lewej
    fmt = new Formatter(); 
    fmt.format("|%-10.2f|", 123.123); 
    System.out.println(fmt); 
    fmt.close();
  } 
}
