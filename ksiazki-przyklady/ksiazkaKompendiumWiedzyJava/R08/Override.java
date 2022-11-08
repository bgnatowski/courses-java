// Przesłanianie metod
class A {
  int i, j;

  A(int a, int b) {
    i = a;
    j = b;
  }

  // Wyświetla i oraz j
  void show() {
    System.out.println("i oraz j: " + i + " " + j);
  }
}

class B extends A {
  int k;

  B(int a, int b, int c) {
    super(a, b);
    k = c;
  }

  // Wyświetla k -- przesłonięcie metody show() z klasy A
  void show() {
    System.out.println("k: " + k);
  }
}

class Override {
  public static void main(String args[]) {
    B subOb = new B(1, 2, 3);

    subOb.show(); // Wywołuje metodę show() z klasy B
  }
}
