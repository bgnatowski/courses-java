// Przy wyborze przeciążanej metody Java stosuje również automatyczną konwersję typów
class OverloadDemo {
  void test() {
    System.out.println("Brak parametrów");
  }
  // Przeciążona wersja dla dwóch parametrów
  void test(int a, int b) {
    System.out.println("a i b: " + a + " " + b);
  }

  // Przeciążona wersja dla jednego parametru typu double
  void test(double a) {
    System.out.println("Wewnątrz test(double) a: " + a);
  }
}
  
class Overload {
  public static void main(String args[]) {
    OverloadDemo ob = new OverloadDemo();
    int i = 88;

    ob.test(); 
    ob.test(10, 20);

    ob.test(i); // Spowoduje wywołanie test(double)
    ob.test(123.2); // Spowoduje wywołanie test(double)
  }
}
