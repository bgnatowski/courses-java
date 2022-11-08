// Wykorzystanie instrukcji break do opuszczenia pętli while
class BreakLoop2 {
  public static void main(String args[]) {
    int i = 0;

    while(i < 100) {
      if(i == 10) break; // Opuszczenie pętli, jeśli i równe 10
      System.out.println("i: " + i);
      i++;
    }
    System.out.println("Koniec pętli");
  }
}
