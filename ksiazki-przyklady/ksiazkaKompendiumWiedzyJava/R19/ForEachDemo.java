// Użycie pętli for typu for-each w celu przejścia przez kolekcję
import java.util.*;

class ForEachDemo {
  public static void main(String args[]) {
    // Utworzenie tablicy dynamicznej liczb całkowitych
    ArrayList<Integer> vals = new ArrayList<Integer>();

    // Dodanie wartości do tablicy
    vals.add(1);
    vals.add(2);
    vals.add(3);
    vals.add(4);
    vals.add(5);

    // Wykorzystanie pętli for do wyświetlenia wartości
    System.out.print("Zawartość vals: ");
    for(int v : vals)
      System.out.print(v + " ");

    System.out.println();

    // Zsumowanie wartości przy użyciu pętli for
    int sum = 0;
    for(int v : vals)
      sum += v;

    System.out.println("Suma wartości: " + sum);
  }
}
