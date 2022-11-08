// Zastosowanie słowa kluczowego super do obejścia przesłaniania nazw
class A {
  int i;
}

// Klasa pochodna rozszerzająca klasę A
class B extends A {
  int i; // To i przesłania i z A

  B(int a, int b) {
    super.i = a; // i z A
    i = b; // i z B
  }

  void show() {
    System.out.println("i z klasy bazowej: " + super.i);
    System.out.println("i z klasy pochodnej: " + i);
  }
}

class UseSuper {
  public static void main(String args[]) {
    B subOb = new B(1, 2);

    subOb.show();
  }
}
