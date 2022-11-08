/* Instrukcje try mogą być zagnieżdżone niejawnie dzięki 
   wywołaniom metod */
class MethNestTry {
  static void nesttry(int a) {
    try { // Zagnieżdżony blok try
      /* Jeśli istnieje jeden argument wiersza poleceń,
         poniższy kod spowoduje zgłoszenie 
         błędu dzielenia przez zero */
      if(a==1) a = a/(a-a); // Dzielenie przez zero

      /* Dla dwóch argumentów zostanie zgłoszony błąd
         przekroczenia granic tablicy */
      if(a==2) {
        int c[] = { 1 };
        c[42] = 99; // Wyjątek przekroczenia granic tablicy
      }
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Indeks poza dopuszczalnymi granicami: " + e);
    }
  }

  public static void main(String args[]) {
    try {
      int a = args.length;

      /* Jeśli nie ma argumentów wiersza poleceń,
         poniższa instrukcja powoduje zgłoszenie błędu
         dzielenia przez zero */
      int b = 42 / a;

      System.out.println("a = " + a);

      nesttry(a);
    } catch(ArithmeticException e) {
      System.out.println("Dzielenie przez 0: " + e);
    }
  }
}
