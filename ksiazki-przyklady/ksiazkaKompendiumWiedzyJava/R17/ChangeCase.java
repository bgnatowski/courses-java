// Przykład użycia toUpperCase() i toLowerCase()

class ChangeCase {
  public static void main(String args[])
  {
    String s = "To jest test.";

    System.out.println("Oryginał: " + s);

    String upper = s.toUpperCase();
    String lower = s.toLowerCase();

    System.out.println("Wielkie litery: " + upper);
    System.out.println("Małe litery: " + lower);
  }
}
