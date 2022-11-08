// Przykład użycia bloku finally
class FinallyDemo {
  // Zgłoszenie wyjątku poza metodę
  static void procA() {
    try {
      System.out.println("Wewnątrz procA");
      throw new RuntimeException("demo");
    } finally {
      System.out.println("finally z procA");
    }
  }

  // Powrót z wnętrza bloku try
  static void procB() {
    try {
      System.out.println("Wewnątrz procB");
      return;
    } finally {
      System.out.println("finally z procB");
    }
  }

  // Wykonanie bloku finally w normalnie wykonywanym programie
  static void procC() {
    try {
      System.out.println("Wewnątrz procC");
    } finally {
      System.out.println("finally z procC");
    }
  }

  public static void main(String args[]) {
    try {
      procA();
    } catch (Exception e) {
      System.out.println("Przechwycenie wyjątku");
    }
    procB();
    procC();
  }
}
