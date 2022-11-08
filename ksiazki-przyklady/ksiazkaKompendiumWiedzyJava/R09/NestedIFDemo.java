// Przykład interfejsu zagnieżdżonego

// Klasa A zawiera interfejs składowy
class A {
  // To jest interfejs zagnieżdżony
  public interface NestedIF {
    boolean isNotNegative(int x);
  }
}

// Klasa B implementuje interfejs zagnieżdżony
class B implements A.NestedIF {
  public boolean isNotNegative(int x) {
    return x < 0 ? false: true;
  }
}

class NestedIFDemo {
  public static void main(String args[]) {

    // Użycie referencji typu interfejsu zagnieżdżonego
    A.NestedIF nif = new B();

    if(nif.isNotNegative(10))
      System.out.println("liczba 10 nie jest ujemna ");
    if(nif.isNotNegative(-12))
      System.out.println("to nie zostanie wyświetlone ");
  }
}
