class A {
  final void meth() {
    System.out.println("To jest metoda finalna.");
  }
}

class B extends A {
  void meth() { // BŁĄD! Nie można przesłonić
    System.out.println("Niepoprawne!");
  }
}
