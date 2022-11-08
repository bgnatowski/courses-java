// Użycie pętli break w pętlach zagnieżdżonych.
class BreakLoop3 {
  public static void main(String args[]) {
    for(int i=0; i<3; i++) {
      System.out.print("Przebieg " + i + ": ");
      for(int j=0; j<100; j++) {
        if(j == 10) break; // opuszczenie pętli, jeśli j równe 10
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("Koniec pętli.");
  }
}
