// Użycie wnioskowania typów zmiennych lokalnych z klasą zdefiniowaną przez programistę
class MyClass {
  private int i;

  MyClass(int k) { i = k;}

  int geti() { return i; }
  void seti(int k) { if(k >= 0) i = k; }
}

class RefVarDemo {
  public static void main(String args[]) {
    var mc = new MyClass(10); // Zwróć tu uwagę na użycie var
    System.out.println("Wartość i w mc wynosi " + mc.geti());
    mc.seti(19);
    System.out.println("A teraz wartość i w mc wynosi " + mc.geti());
  }
}
