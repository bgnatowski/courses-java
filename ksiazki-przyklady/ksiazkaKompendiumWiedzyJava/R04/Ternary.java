// Przykład użycia operatora trójargumentowego
class Ternary {
  public static void main(String args[]) {
    int i, k;

    i = 10;
    k = i < 0 ? -i : i; // Pobierz wartość bezwzględną z i
    System.out.print("Wartość bezwzględna z ");
    System.out.println(i+" wynosi "+k);

    i = -10;
    k = i < 0 ? -i : i; // Pobierz wartość bezwzględną z i
    System.out.print("Wartość bezwzględna z ");
    System.out.println(i+" wynosi "+k);
  }
}
