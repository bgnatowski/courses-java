// Korzystanie z kwantyfikatora ?
import java.util.regex.*;

class RegExpr6 {
  public static void main(String args[]) {
    // Zachowanie oszczędne
    Pattern pat = Pattern.compile("e.+?d");
    Matcher mat = pat.matcher("extend cup end table");

    while(mat.find())
      System.out.println("Dopasowana sekwencja: " + mat.group());
  }
}
