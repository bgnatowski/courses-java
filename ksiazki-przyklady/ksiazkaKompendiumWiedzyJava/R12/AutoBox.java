// Przykład automatycznego opakowywania
class AutoBox {
  public static void main(String args[]) {

    Integer iOb = 100; // Automatyczne opakowanie typu int

    int i = iOb; // Automatyczne rozpakowanie

    System.out.println(i + " " + iOb);  // Wyświetla 100 100
  }
}
