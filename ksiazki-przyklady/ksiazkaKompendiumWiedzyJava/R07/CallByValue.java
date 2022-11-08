// Typy proste są przekazywane przez wartość
class Test {
  void meth(int i, int j) {
    i *= 2;
    j /= 2;
  }
}

class CallByValue {
  public static void main(String args[]) {
    Test ob = new Test();
    int a = 15, b = 20;
    
    System.out.println("a i b przed wywołaniem: " +
                       a + " " + b);

    ob.meth(a, b); 

    System.out.println("a i b po wywołaniu: " +
                       a + " " + b);
  }
}
