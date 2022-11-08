// Sytuacja, w której powstaje metoda mostu
class Gen<T> {
  T ob; // Deklaracja obiektu typu T

  // Przekazanie do konstruktora referencji do
  // obiektu typu T
  Gen(T o) {
    ob = o;
  }

  // Zwróć ob
  T getob() {
    return ob;
  }
}

// Podklasa klasy Gen
class Gen2 extends Gen<String> {

  Gen2(String o) {
    super(o);
  }

  // Przesłonięcie metody getob() przez konkretną wersję używającą String
  String getob() {
    System.out.print("Wywołanie String getob(): ");
    return ob;
  }
}

// Przykład sytuacji wymagającej użycia metody mostu
class BridgeDemo {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen2 dla String
    Gen2 strOb2 = new Gen2("Test parametryzacji");

    System.out.println(strOb2.getob());
  }
}
