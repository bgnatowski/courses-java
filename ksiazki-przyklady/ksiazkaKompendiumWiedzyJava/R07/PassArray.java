// Użycie tablicy do przekazywania zmiennej liczby argumentów
// do metody. Jest to rozwiązanie stosowane przed wprowadzeniem
// metod o zmiennej liczbie argumentów
class PassArray {
  static void vaTest(int v[]) {
    System.out.print("Liczba argumentów: " + v.length +
                       " Zawartość: ");

    for(int x : v)
      System.out.print(x + " ");

    System.out.println();
  }

  public static void main(String args[])
  {
    // Zauważ sposób tworzenia tablicy wymagany do
    // przechowywania argumentów
    int n1[] = { 10 };
    int n2[] = { 1, 2, 3 };
    int n3[] = { };

    vaTest(n1); // 1 argument
    vaTest(n2); // 3 argumenty
    vaTest(n3); // Brak argumentów
  }
}
