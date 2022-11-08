// Metody o innych sygnaturach typów są przeciążane, a nie przesłaniane
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

// Utworzenie klasy pochodnej rozszerzającej klasę A
class B extends A {
  int k;

  B(int a, int b, int c) {
    super(a, b);
    k = c;
  }

  // Przeciążona wersja show()
  void show(String msg) {
    System.out.println(msg + k);
  }
}

class Override2 {
  public static void main(String args[]) {
    B subOb = new B(1, 2, 3);

    subOb.show("To jest k: "); // Wywołuje metodę show() z klasy B
    subOb.show(); // Wywołuje metodę show() z klasy A
  }
}
