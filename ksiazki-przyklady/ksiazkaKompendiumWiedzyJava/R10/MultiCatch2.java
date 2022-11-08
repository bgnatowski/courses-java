// Demonstruje mechanizm wielokrotnego przechwytywania, wprowadzony w JDK 7
class MultiCatch2 {
  public static void main(String args[]) {
    int a=10, b=0;
    int vals[] = { 1, 2, 3 };

    try {
      int result = a / b; // Generuje wyjątek ArithmeticException

      // vals[10] = 19; // Generuje wyjątek ArrayIndexOutOfBoundsException

      // Ta klauzula catch przechwytuje oba wyjątki
    } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Przechwycono wyjątek: " + e);
    }
    
    System.out.println("Po wielokrotnym przechwytywaniu");
  }
}
