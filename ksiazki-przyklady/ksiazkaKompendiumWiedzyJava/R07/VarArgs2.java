// Metoda typu varargs z tradycyjnymi parametrami
class VarArgs2 {

  // Tutaj msg to tradycyjny parametr, a v to 
  // parametr typu varargs
  static void vaTest(String msg, int ... v) {
    System.out.print(msg + v.length +
                       " Zawartość: ");

    for(int x : v)
      System.out.print(x + " ");

    System.out.println();
  }

  public static void main(String args[])
  {
    vaTest("Jeden parametr typu vararg: ", 10);
    vaTest("Trzy parametry typu vararg: ", 1, 2, 3);
    vaTest("Brak parametrów typu vararg: ");
  }
}
