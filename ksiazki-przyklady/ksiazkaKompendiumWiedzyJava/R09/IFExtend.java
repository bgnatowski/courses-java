// Jeden interfejs rozszerza inny
interface A {
  void meth1();
  void meth2();
}

// Teraz B zawiera meth1() i meth2() oraz dodaje własne meth3()
interface B extends A {
  void meth3();
}

// Klasa musi zaimplementować wszystkie metody zdefiniowane w interfejsach A i B
class MyClass implements B {
  public void meth1() {
    System.out.println("Implementacja meth1()");
  }

  public void meth2() {
    System.out.println("Implementacja meth2()");
  }

  public void meth3() {
    System.out.println("Implementacja meth3()");
  }
}

class IFExtend {
  public static void main(String arg[]) {
    MyClass ob = new MyClass();

    ob.meth1();
    ob.meth2();
    ob.meth3();
  }
}
