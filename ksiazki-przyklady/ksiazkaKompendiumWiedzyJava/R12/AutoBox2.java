// Automatyczne opakowanie i rozpakowanie dotyczy
// także argumentów metod i zwracanych wartości

class AutoBox2 {
  // Pobierz parametr Integer
  // i zwróć wartość typu int
  static int m(Integer v) {
    return v ; // Automatyczne rozpakowanie do int
  }

  public static void main(String args[]) {
    // Przekazanie wartości typu int do m() i przypisanie zwróconej wartości
    // obiektowi typu Integer. Argument 100 jest automatycznie opakowany typem
    // Integer. Zwracana wartość jest ponownie automatycznie opakowywana
    // typem Integer
    Integer iOb = m(100);

    System.out.println(iOb);
  }
}
