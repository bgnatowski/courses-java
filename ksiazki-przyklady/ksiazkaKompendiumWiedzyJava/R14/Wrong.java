class Wrong<T> {
  // Błąd, zmienna statyczna nie może być typu T
  static T ob;

  // Błąd, metoda statyczna nie może używać typu T
  static T getob() {
    return ob;
  }
}
