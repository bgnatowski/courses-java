// Tego programu nie uda się skompilować
class Outer {
  int outer_x = 100;

  void test() {
    Inner inner = new Inner();
    inner.display();
  }

  // Klasa wewnętrzna
  class Inner {
    int y = 10; // y jest lokalne dla Inner

    void display() {
      System.out.println("display: outer_x = " + outer_x);
    }
  }

  void showy() {
    System.out.println(y); // Błąd, y nie jest znane!
  }
}

class InnerClassDemo2 {
  public static void main(String args[]) {
    Outer outer = new Outer();
    outer.test();
  }
}
