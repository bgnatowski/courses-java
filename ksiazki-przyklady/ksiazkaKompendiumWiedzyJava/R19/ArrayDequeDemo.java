// Przykład użycia klasy ArrayDeque 
import java.util.*;

class ArrayDequeDemo {
  public static void main(String args[]) {
    // Tworzy tablicę typu ArrayDeque 
    ArrayDeque<String> adq = new ArrayDeque<String>();

    // Przykład wykorzystania kolekcji typu ArrayDeque w roli stosu 
    adq.push("A");
    adq.push("B");
    adq.push("D");
    adq.push("E");
    adq.push("F");

    System.out.print("Kolejne elementy zdejmowane ze stosu: "); 

    while(adq.peek() != null)
      System.out.print(adq.pop() + " ");
    
    System.out.println();
  }
}
