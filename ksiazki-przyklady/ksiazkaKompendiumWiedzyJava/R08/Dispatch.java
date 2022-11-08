// Dynamiczne przydzielanie metod
class A {
   void callme() {
     System.out.println("Metoda callme() klasy A");
  }
}

class B extends A {
  // Przesłania callme()
  void callme() {
    System.out.println("Metoda callme() klasy B");
  }
}

class C extends A {
  // Przesłania callme()
  void callme() {
    System.out.println("Metoda callme() klasy C");
  }
}

class Dispatch {
  public static void main(String args[]) {
    A a = new A(); // Obiekt klasy A
    B b = new B(); // Obiekt klasy B
    C c = new C(); // Obiekt klasy C
    A r; // Może przechowywać referencję do typu A

    r = a; // r odnosi się do obiektu A
    r.callme(); // Wywołanie wersji callme() z klasy A

    r = b; // r odnosi się do obiektu B
    r.callme(); // Wywołanie wersji callme() z klasy B

    r = c; // r odnosi się do obiektu C
    r.callme(); // Wywołanie wersji callme() z klasy C
  }
}
