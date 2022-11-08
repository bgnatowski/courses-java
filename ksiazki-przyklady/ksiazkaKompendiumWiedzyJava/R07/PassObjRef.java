// Obiekty są przekazywane przez referencję

class Test {
  int a, b;

  Test(int i, int j) {
    a = i;
    b = j;
  }

  // Przekazanie obiektu
  void meth(Test o) {
    o.a *=  2;
    o.b /= 2;
  }
}

class PassObjRef {
  public static void main(String args[]) {
    Test ob = new Test(15, 20);
    
    System.out.println("ob.a i ob.b przed wywołaniem: " +
                       ob.a + " " + ob.b);
    
    ob.meth(ob); 

    System.out.println("ob.a i ob.b po wywołaniu: " +
                       ob.a + " " + ob.b);
  }
}
