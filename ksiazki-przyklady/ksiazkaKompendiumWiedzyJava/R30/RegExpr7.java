// Korzystanie z klas znaków
import java.util.regex.*;

class RegExpr7 {
  public static void main(String args[]) {
    // Dopasowywanie słów pisanych małymi literami
    Pattern pat = Pattern.compile("[a-z]+");
    Matcher mat = pat.matcher("to jest test.");

    while(mat.find())
      System.out.println("Dopasowana sekwencja: " + mat.group());
  }
}
