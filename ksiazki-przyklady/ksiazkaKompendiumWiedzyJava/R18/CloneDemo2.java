// Przesłonięcie metody clone()

class TestClone implements Cloneable {
  int a;
  double b;

  // Metoda clone() została przesłonięta i jest teraz metodą publiczną
  public Object clone() {
    try {
      // Wywołanie clone() z Object
      return super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("Klonowanie niedozwolone");
      return this;
    }
  }
}

class CloneDemo2 {
  public static void main(String args[]) {
    TestClone x1 = new TestClone();
    TestClone x2;
    
    x1.a = 10;
    x1.b = 20.98;

    // Tutaj clone() jest wywoływana bezpośrednio
    x2 = (TestClone) x1.clone();

    System.out.println("x1: " + x1.a + " " + x1.b);
    System.out.println("x2: " + x2.a + " " + x2.b);
  }
}
