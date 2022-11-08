// Zmienna liczba argumentów, przeciążanie i niejednoznaczność
//
// Program zawiera błąd, więc nie zostanie skompilowany!
class VarArgs4 {

  static void vaTest(int ... v) {
    System.out.print("vaTest(Integer ...): " +
                     "Liczba argumentów: " + v.length +
                     " Zawartość: ");

    for(int x : v)
      System.out.print(x + " ");

    System.out.println();
  }

  static void vaTest(boolean ... v) {
    System.out.print("vaTest(boolean ...) " +
                     "Liczba argumentów: " + v.length +
                     " Zawartość: ");

    for(boolean x : v)
      System.out.print(x + " ");

    System.out.println();
  }

  public static void main(String args[])
  {
    vaTest(1, 2, 3);  // OK
    vaTest(true, false, false); // OK

    vaTest(); // Błąd: niejednoznaczność!
  }
}
