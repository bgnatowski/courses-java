// Wykorzystanie informacji o typie w trakcie działania programu

class X {
  int a;
  float b;
}

class Y extends X {
  double c;
}

class RTTI {
  public static void main(String args[]) {
    X x = new X();
    Y y = new Y();
    Class<?> clObj;

    clObj = x.getClass(); // Pobranie referencji do Class
    System.out.println("x jest obiektem typu: " +
                       clObj.getName());

    clObj = y.getClass(); // Pobranie referencji do Class
    System.out.println("y jest obiektem typu: " +
                       clObj.getName());
    clObj = clObj.getSuperclass();
    System.out.println("klasa bazowa y to " +
                       clObj.getName());
  }
}
