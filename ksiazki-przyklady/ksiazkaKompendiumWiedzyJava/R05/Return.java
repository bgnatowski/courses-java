// Przykład użycia instrukcji return.
class Return {
  public static void main(String args[]) {
    boolean t = true;

    System.out.println("Przed return.");

    if(t) return; // powrót do kodu wywołującego metodę

    System.out.println("To się nie wykona.");
  }
}
