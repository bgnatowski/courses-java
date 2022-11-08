// Demonstruje użycie klasy BitSet
import java.util.BitSet;

class BitSetDemo {
  public static void main(String args[]) {
    BitSet bits1 = new BitSet(16);
    BitSet bits2 = new BitSet(16);

    // Ustawia kilka bitów
    for(int i=0; i<16; i++) {
      if((i%2) == 0) bits1.set(i);
      if((i%5) != 0) bits2.set(i);
    }

    System.out.println("Początkowy wzorzec w obiekcie bits1: ");
    System.out.println(bits1);
    System.out.println("\nPoczątkowy wzorzec w obiekcie bits2: ");
    System.out.println(bits2);

    // KONIUNKCJA bitów
    bits2.and(bits1);
    System.out.println("\nbits2 I bits1: ");
    System.out.println(bits2);

    // ALTERNATYWA bitów
    bits2.or(bits1);
    System.out.println("\nbits2 LUB bits1: ");
    System.out.println(bits2);

    // RÓŻNICA SYMETRYCZNA bitów
    bits2.xor(bits1);
    System.out.println("\nbits2 LUB WYKLUCZAJĄCE bits1: ");
    System.out.println(bits2);
  }
}
