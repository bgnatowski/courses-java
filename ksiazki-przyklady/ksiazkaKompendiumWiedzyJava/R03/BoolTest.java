// Przykład użycia typu boolean.
class BoolTest {
  public static void main(String args[]) {
    boolean b;

    b = false;
    System.out.println("b wynosi " + b);
    b = true;
    System.out.println("b wynosi " + b);

    // Wartość logiczna może sterować instrukcją if
    if(b) System.out.println("To zostało wykonane.");

    b = false;
    if(b) System.out.println("To nie zostało wykonane.");

    // Wynik operatora relacji jest wartością logiczną
    System.out.println("10 > 9 to wartość " + (10 > 9));
  }
}
