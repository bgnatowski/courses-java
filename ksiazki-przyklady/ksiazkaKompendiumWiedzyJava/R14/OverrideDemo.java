// Przesłonięcie metody sparametryzowanej z klasy sparametryzowanej
class Gen<T> {
  T ob; // Deklaracja obiektu typu T

  // Przekazanie do konstruktora referencji do
  // obiektu typu T
  Gen(T o) {
    ob = o;
  }

  // Zwrócenie ob
  T getob() {
    System.out.print("Metoda getob() z Gen: " );
    return ob;
  }
}

// Podklasa klasy Gen przesłaniająca metodę getob()
class Gen2<T> extends Gen<T> {

  Gen2(T o) {
    super(o);
  }

  // Przesłonięcie metody getob()
  T getob() {
    System.out.print("Metoda getob() z Gen2: ");
    return ob;
  }
}
// Przykład przesłonięcia metody sparametryzowanej
class OverrideDemo {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen dla Integer
    Gen<Integer> iOb = new Gen<Integer>(88);

    // Utworzenie obiektu Gen2 dla Integer
    Gen2<Integer> iOb2 = new Gen2<Integer>(99);

    // Utworzenie obiektu Gen2 dla String
    Gen2<String> strOb2 = new Gen2<String>("Test parametryzacji");

    System.out.println(iOb.getob());
    System.out.println(iOb2.getob());
    System.out.println(strOb2.getob());
  }
}
