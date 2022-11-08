// Badanie czasu wykonywania programu

class Elapsed {
  public static void main(String args[]) {
    long start, end;

    System.out.println("Sprawdzanie czasu wykonywania pętli od 0 do 100 000 000");

    // Sprawdzanie czasu wykonywania pętli od 0 do 100 000 000
    start = System.currentTimeMillis(); // Pobranie czasu początkowego
    for(long i=0; i < 100000000L; i++) ;
    end = System.currentTimeMillis(); // Pobranie czasu końcowego

    System.out.println("Czas wykonywania: " + (end-start));
  }
}
