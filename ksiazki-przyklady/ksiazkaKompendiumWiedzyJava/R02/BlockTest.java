/*
  Przykład wykorzystania bloku kodu
  Nadaj plikowi nazwę "BlockTest.java"
*/
class BlockTest {
  public static void main(String args[]) {
    int x, y;

    y = 20;

    // Instrukcją wykonywaną przez pętlę jest blok kodu
    for(x = 0; x<10; x++) {
      System.out.println("Wartość x wynosi " + x);
      System.out.println("Wartość y wynosi " + y);
      y = y - 2;
    }
  }
}
