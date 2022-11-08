// Program wykorzystujący znak zastępczy i kwantyfikator
import java.util.regex.*;

class RegExpr5 {
  public static void main(String args[]) {
    Pattern pat = Pattern.compile("e.+d");
    Matcher mat = pat.matcher("extend cup end table");

    while(mat.find())
      System.out.println("Dopasowana sekwencja: " + mat.group());
  }
}
