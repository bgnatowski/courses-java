// Przykład wykorzystania metody find() do odnajdywania wielokrotnych wystąpień sekwencji
import java.util.regex.*;

class RegExpr3 {
  public static void main(String args[]) {
    Pattern pat = Pattern.compile("test");
    Matcher mat = pat.matcher("test 1 2 3 test");

    while(mat.find()) {
      System.out.println("Słowo test znalezione pod indeksem " + mat.start());
    }
  }
}
