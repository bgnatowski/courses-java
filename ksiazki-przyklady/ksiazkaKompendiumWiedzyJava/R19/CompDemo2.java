// Zastosowanie wyrażeń lambda do utworzenia komparatora przeciwnego
import java.util.*;

class CompDemo2 {
  public static void main(String args[]) {
    
    // Używa wyrażenia lambda, by przekazać do konstruktora TreeSet()
    // komparator przeciwny do naturalnego
    TreeSet<String> ts = new TreeSet<String>(
                           (aStr, bStr) -> bStr.compareTo(aStr));

    // Dodanie elementów do zbioru
    ts.add("C");
    ts.add("A");
    ts.add("B");
    ts.add("E");
    ts.add("F");
    ts.add("D");

    // Wyświetlenie elementów
    for(String element : ts)
      System.out.print(element + " ");

    System.out.println();
  }
}
