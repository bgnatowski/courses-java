// Przykład łańcucha wyjątków
class ChainExcDemo {
  static void demoproc() {
    // Utworzenie wyjątku
    NullPointerException e =
      new NullPointerException("najwyższy poziom");

    // Dodanie powodu
    e.initCause(new ArithmeticException("powód"));

    throw e;
  }

  public static void main(String args[]) {
    try {
      demoproc();
    } catch(NullPointerException e) {
      // Wyświetlenie wyjątku najwyższego poziomu
      System.out.println("Przechwycono: " + e);

      // Wyświetlenie wyjątku powodu
      System.out.println("Oryginalny powód: " +
                          e.getCause());
    }
  }
}
