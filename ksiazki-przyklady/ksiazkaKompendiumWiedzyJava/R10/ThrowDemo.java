// Przykład użycia instrukcji throw
class ThrowDemo {
  static void demoproc() {
    try {
      throw new NullPointerException("demo");
    } catch(NullPointerException e) {
      System.out.println("Przechwycone wewnątrz metody demoproc()");
      throw e; // Ponowne zgłoszenie wyjątku
    }
  }

  public static void main(String args[]) {
    try {
      demoproc();
    } catch(NullPointerException e) {
      System.out.println("Ponowne przechwycenie: " + e);
    }
  }
}
