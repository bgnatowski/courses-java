// Przykłady rzutowania
class Conversion {
  public static void main(String args[]) {
    byte b;
    int i = 257;
    double d = 323.142;

    System.out.println("\nKonwersja z int na byte");
    b = (byte) i;
    System.out.println("i oraz b " + i + " " + b);

    System.out.println("\nKonwersja z double na int");
    i = (int) d;
    System.out.println("d oraz i " + d + " " + i);

    System.out.println("\nKonwersja z double na byte");
    b = (byte) d;
    System.out.println("d oraz b " + d + " " + b);
  }
}
