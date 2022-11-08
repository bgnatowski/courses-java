// Podklasa może zastosować własny parametr typu 
class Gen<T> {
  T ob; // Deklaracja obiektu typu T

  // Przekazanie do konstruktora referencji do
  // obiektu typu T 
  Gen(T o) {
    ob = o;
  }

  // Zwrócenie ob 
  T getob() {
    return ob;
  }
}

// Podklasa klasy Gen, która definiuje drugi 
// parametr typu o nazwie V 
class Gen2<T, V> extends Gen<T> {
  V ob2;

  Gen2(T o, V o2) {
    super(o);
    ob2 = o2;
  }

  V getob2() {
    return ob2;
  }
}

// Utworzenie obiektu typu Gen2 
class HierDemo {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen2 dla typów String i Integer 
    Gen2<String, Integer> x =
      new Gen2<String, Integer>("Wartość: ", 99);

    System.out.print(x.getob());
    System.out.println(x.getob2());
  }
}
