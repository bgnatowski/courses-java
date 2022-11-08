/*
  Przykład użycia instrukcji if
  Nadaj plikowi nazwę "IfSample.java"
*/
class IfSample {
  public static void main(String args[]) {
    int x, y;

    x = 10;
    y = 20;

    if(x < y) System.out.println("x jest mniejsze od y");

    x = x * 2;
    if(x == y) System.out.println("teraz x jest równe y");

    x = x * 2;
    if(x > y) System.out.println("teraz x jest większe od y");

    // Poniższe wywołanie metody println() nie zostanie wykonane
    if(x == y) System.out.println("tego nie zobaczysz");
  }
}
