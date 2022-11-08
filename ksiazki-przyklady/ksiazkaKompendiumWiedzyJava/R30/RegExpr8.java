// Korzystanie z metody replaceAll()
import java.util.regex.*;

class RegExpr8 {
  public static void main(String args[]) {
    String str = "Jon Jonathan Frank Ken Todd";

    Pattern pat = Pattern.compile("Jon.*? ");
    Matcher mat = pat.matcher(str);

    System.out.println("Pierwotna sekwencja: " + str);

    str = mat.replaceAll("Eric ");
    
    System.out.println("Zmodyfikowana sekwencja: " + str);
  }
}
