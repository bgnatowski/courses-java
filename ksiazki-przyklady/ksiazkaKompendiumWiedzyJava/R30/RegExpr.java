// Demonstracja prostego dopasowywania do wzorca
import java.util.regex.*;

class RegExpr {
  public static void main(String args[]) {
    Pattern pat;
    Matcher mat;
    boolean found;

    pat = Pattern.compile("Java");
    mat = pat.matcher("Java");
    found = mat.matches(); // Sprawdzenie, czy sekwencja pasuje do wzorca

    System.out.println("Dopasowywanie słowa Java do słowa Java");
    if(found) System.out.println("Pasuje");
    else System.out.println("Nie pasuje");

    System.out.println();

    System.out.println("Dopasowywanie słowa Java do słowa Java SE");
    mat = pat.matcher("Java SE"); // Tworzenie nowego obiektu typu Matcher

    found = mat.matches(); // Sprawdzenie, czy sekwencja pasuje do wzorca

    if(found) System.out.println("Pasuje");
    else System.out.println("Nie pasuje");
  }
}
