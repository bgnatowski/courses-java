// Błąd przy ręcznym rozpakowywaniu
class UnboxingError {
  public static void main(String args[]) {

    Integer iOb = 1000; // Automatyczne opakowanie wartości 1000

    int i = iOb.byteValue(); // Ręczne wydobycie wartości!!!

    System.out.println(i);  // Nie spowoduje wyświetlenia wartości 1000!
  }
}
