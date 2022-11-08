// Automatyczne opakowywanie i rozpakowywanie obiektów klas Boolean i Character

class AutoBox5 {
  public static void main(String args[]) {

    // Automatyczne opakowanie/rozpakowanie wartości typu boolean
    Boolean b = true;

    // Zastosowanie b w wyrażeniu warunkowym powoduje
    // jego automatyczne rozpakowanie
    if(b) System.out.println("b wynosi true");

    // Automatyczne opakowanie/rozpakowanie wartości typu char
    Character ch = 'x'; // Opakowanie typu char
    char ch2 = ch; // Rozpakowanie char
    System.out.println("ch2 wynosi " + ch2);
  }
}
