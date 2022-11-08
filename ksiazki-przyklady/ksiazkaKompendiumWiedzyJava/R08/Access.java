/* W hierarchii klas składowe prywatne pozostają
   ukryte nawet przed klasami pochodnymi

   Program zawiera błąd, więc nie zostanie poprawnie skompilowany
*/

// Definicja klasy bazowej
class A {
  int i; // Dostęp domyślny
  private int j; // Prywatna - dostępna tylko w A

  void setij(int x, int y) {
    i = x;
    j = y;
  }
}

// Tutaj składowa j z klasy A nie jest dostępna
class B extends A {
  int total;

  void sum() {
    total = i + j; // BŁĄD, j nie jest dostępna
  }
}
  
class Access {
  public static void main(String args[]) {
    B subOb = new B();

    subOb.setij(10, 12);

    subOb.sum();
    System.out.println("Suma: " + subOb.total);
  }
}
