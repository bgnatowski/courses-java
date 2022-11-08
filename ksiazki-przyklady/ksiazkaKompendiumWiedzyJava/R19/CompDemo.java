// Użycie własnego komparatora
import java.util.*;

// Odwrotne porównywanie łańcuchów
class MyComp implements Comparator<String> {
  public int compare(String aStr, String bStr) {
    
    // Odwrócenie porównania
    return bStr.compareTo(aStr);
  }

  // Nie ma potrzeby przeciążania metody equals()
}

class CompDemo {
  public static void main(String args[]) {
    // Utworzenie zbioru drzewiastego
    TreeSet<String> ts = new TreeSet<String>(new MyComp());

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
