// Przykład wykorzystania metody clone()

class TestClone implements Cloneable {
  int a;
  double b;
  
  // Ta metoda wywołuje metodę clone() klasy Object
  TestClone cloneTest() {
    try {
      // Wywołanie clone() z Object
      return (TestClone) super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("Klonowanie niedozwolone");
      return this;
    }
  }
}

class CloneDemo {
  public static void main(String args[]) {
    TestClone x1 = new TestClone();
    TestClone x2;

    x1.a = 10;
    x1.b = 20.98;

    x2 = x1.cloneTest(); // Klonowanie x1

    System.out.println("x1: " + x1.a + " " + x1.b);
    System.out.println("x2: " + x2.a + " " + x2.b);
  }
}
