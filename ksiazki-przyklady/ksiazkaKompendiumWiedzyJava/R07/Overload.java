// Przykład przeciążania metod
class OverloadDemo {
  void test() {
    System.out.println("Brak parametrów");
  }

  // Przeciążona metoda test z jednym parametrem typu int
  void test(int a) {
    System.out.println("a: " + a);
  }

  // Przeciążona metoda test z dwoma parametrami
  void test(int a, int b) {
    System.out.println("a i b: " + a + " " + b);
  }

  // Przeciążona metoda test z jednym parametrem typu double
  double test(double a) {
    System.out.println("double a: " + a);
    return a*a;
  }
}
  
class Overload {
  public static void main(String args[]) {
    OverloadDemo ob = new OverloadDemo();
    double result;

    // Wywołanie wszystkich wersji metody test()
    ob.test(); 
    ob.test(10);
    ob.test(10, 20);
    result = ob.test(123.25);
    System.out.println("Wynik wykonania ob.test(123.25): " + result);
  }
}
