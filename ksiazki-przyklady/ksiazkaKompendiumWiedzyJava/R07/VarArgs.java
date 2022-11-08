// Metoda o zmiennej liczbie argumentów
class VarArgs {

  // Metoda vaTest() jest typu varargs
  static void vaTest(int ... v) {
    System.out.print("Liczba argumentów: " + v.length +
                       " Zawartość: ");

    for(int x : v)
      System.out.print(x + " ");

    System.out.println();
  }
  
  public static void main(String args[])
  {

    // Zauważ, że teraz metoda vaTest() jest
    // po prostu wywoływana ze zmienną liczbą argumentów
    vaTest(10);      // 1 argument
    vaTest(1, 2, 3); // 3 argumenty
    vaTest();        // Brak argumentów
  }
}
