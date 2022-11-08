// Przykład wykorzystania metody find() do znalezienia fragmentu sekwencji
import java.util.regex.*;

class RegExpr2 {
  public static void main(String args[]) {
    Pattern pat = Pattern.compile("Java");
    Matcher mat = pat.matcher("Java 9");

    System.out.println("Szukam słowa Java w sekwencji Java 8");

    if(mat.find()) System.out.println("Słowo znalezione");
    else System.out.println("Słowo nie zostało znalezione");
  }
}
