// Przykład metody abstrakcyjnej
abstract class A {
  abstract void callme();

  // Klasy abstrakcyjne mogą mieć konkretne metody
  void callmetoo() {
    System.out.println("To jest konkretna metoda.");
  }
}

class B extends A {
  void callme() {
    System.out.println("Implementacja callme() z klasy B");
  }
}

class AbstractDemo {
  public static void main(String args[]) {
    B b = new B();

    b.callme();
    b.callmetoo();
  }
}
