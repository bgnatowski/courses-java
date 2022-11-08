// Użycie instrukcji break w pętli zagnieżdżonej
class BreakLoop4 {
  public static void main(String args[]) {
    outer: for(int i=0; i<3; i++) {
      System.out.print("Przebieg " + i + ": ");
      for(int j=0; j<100; j++) {
        if(j == 10) break outer; // Wyjście z obu pętli
        System.out.print(j + " ");
      }
      System.out.println("To się nie wyświetli");
    }
    System.out.println("Koniec obu pętli");
  }
}
