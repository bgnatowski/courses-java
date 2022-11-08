// Przykład zasięgu bloku
class Scope {
  public static void main(String args[]) {
    int x; // Widziany przez cały kod metody

    x = 10;
    if(x == 10) { // Początek nowego zasięgu
      int y = 20; // O tej zmiennej wie tylko ten blok

      // Tutaj znana jest zarówno zmienna x, jak i y
      System.out.println("x i y: " + x + " " + y);
      x = y * 2;
    }
    // y = 100; // Błąd! Zmienna y nie jest znana

    // Nadal znamy wartość zmiennej x
    System.out.println("x wynosi " + x);
  }
}
