// Przykład użycia metod totalMemory(), freeMemory() i gc()

class MemoryDemo {
  public static void main(String args[]) {
    Runtime r = Runtime.getRuntime();
    long mem1, mem2;
    Integer someints[] = new Integer[1000];

    System.out.println("Łączna liczba bajtów pamięci: " +
                       r.totalMemory());

    mem1 = r.freeMemory();
    System.out.println("Początkowa ilość wolnej pamięci: " + mem1);
    r.gc();
    mem1 = r.freeMemory();
    System.out.println("Wolna pamięć po oczyszczeniu z nieużywanych obiektów: "
                       + mem1);

    for(int i=0; i<1000; i++)
      someints[i] = Integer.valueOf(i); // Alokacja obiektów Integer

    mem2 = r.freeMemory();
    System.out.println("Wolna pamięć po alokacji: "
                       + mem2);
    System.out.println("Pamięć zużyta przez alokację: "
                       + (mem1-mem2));
    // Spowodowanie nieużywania obiektów Integers
    for(int i=0; i<1000; i++) someints[i] = null;

    r.gc(); // Wymuszenie usunięcia obiektów

    mem2 = r.freeMemory();
    System.out.println("Wolna pamięć po usunięciu" +
                       " porzuconych obiektów Integers: " + mem2);

  }
}
