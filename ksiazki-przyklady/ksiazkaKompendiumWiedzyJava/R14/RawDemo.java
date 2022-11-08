// Przykład typu surowego
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

// Klasa korzystająca z typu surowego
class RawDemo {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen dla typu Integer
    Gen<Integer> iOb = new Gen<Integer>(88);

    // Utworzenie obiektu Gen dla typu String
    Gen<String> strOb = new Gen<String>("Test parametryzacji");

    // Utworzenie obiektu Gen typu surowego i przekazanie mu
    // wartości Double
    Gen raw = new Gen(Double.valueOf(98.6));

    // Konieczne jest rzutowanie, ponieważ typ nie jest znany
    double d = (Double) raw.getob();
    System.out.println("wartość: " + d);

    // Użycie typu surowego może doprowadzić do zgłoszenia
    // wyjątku wykonania; oto kilka przykładów

    // Powoduje zgłoszenie błędu wykonania!
//    int i = (Integer) raw.getob(); // Błąd wykonania

    // To przypisanie omija bezpieczeństwo typów
    strOb = raw; // Poprawne, ale może doprowadzić do błędu
//    String str = strOb.getob(); // Błąd wykonania

    // To przypisanie również omija bezpieczeństwo typów
    raw = iOb; // Poprawne, ale może doprowadzić do błędu
//    d = (Double) raw.getob(); // Błąd wykonania
  }
}
