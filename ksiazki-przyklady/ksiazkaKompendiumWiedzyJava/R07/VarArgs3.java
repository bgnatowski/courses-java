// Metody typu vararg i przeciążanie
class VarArgs3 {

  static void vaTest(int ... v) {
    System.out.print("vaTest(int ...): " +
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

  static void vaTest(String msg, int ... v) {
    System.out.print("vaTest(String, int ...): " +
                     msg + v.length +
                     " Zawartość: ");

    for(int x : v)
      System.out.print(x + " ");

    System.out.println();
  }

  public static void main(String args[])
  {
    vaTest(1, 2, 3);
    vaTest("Testowanie: ", 10, 20);
    vaTest(true, false, false);
  }
}
