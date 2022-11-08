class Exc2 {
  public static void main(String args[]) {
    int d, a;

    try { // Monitorowanie bloku kodu
      d = 0;
      a = 42 / d;
      System.out.println("To nie zostanie wyświetlone.");
    } catch (ArithmeticException e) { // Przechwycenie błędu dzielenia przez zero
      System.out.println("Dzielenie przez zero");
    }
    System.out.println("Po instrukcji catch");
  }
}
