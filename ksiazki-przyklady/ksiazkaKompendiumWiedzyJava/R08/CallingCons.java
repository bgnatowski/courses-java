// Przykład kolejności wykonywania konstruktorów

// Utworzenie klasy bazowej
class A {
  A() {
    System.out.println("Konstruktor klasy A");
  }
}

// Utworzenie klasy pochodnej rozszerzającej klasę A
class B extends A {
  B() {
    System.out.println("Konstruktor klasy B");
  }
}

// Utworzenie klasy pochodnej rozszerzającej klasę B
class C extends B {
  C() {
    System.out.println("Konstruktor klasy C");
  }
}

class CallingCons {
  public static void main(String args[]) {
    C c = new C();
  }
}
