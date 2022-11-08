/* Program ilustruje różnicę między dostępem
   prywatnym i publicznym
*/
class Test {
  int a; // Dostęp domyślny
  public int b; // Dostęp publiczny
  private int c; // Dostęp prywatny

  // Metoda korzystająca ze zmiennej c
  void setc(int i) { // Ustawienie wartości zmiennej c
    c = i;
  }
  int getc() { // Pobranie wartości zmiennej c
    return c;
  }
}
  
class AccessTest {
  public static void main(String args[]) {
    Test ob = new Test();

    // Poniższe instrukcje są poprawne, zmienne a i b są dostępne publicznie
    ob.a = 10;
    ob.b = 20;

    // Wykonanie poniższej instrukcji spowodowałoby zgłoszenie błędu
    // ob.c = 100; // Błąd!

    // Dostęp do zmiennej c tylko przez metodę
    ob.setc(100); // OK
   
    System.out.println("a, b i c: " + ob.a + " " +
                       ob.b + " " + ob.getc());
  }
}
