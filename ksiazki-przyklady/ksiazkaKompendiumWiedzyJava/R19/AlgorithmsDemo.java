// Przykład użycia kilku algorytmów
import java.util.*;

class AlgorithmsDemo {
  public static void main(String args[]) {

    // Utworzenie i inicjalizacja listy
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.add(-8);
    ll.add(20);
    ll.add(-20);
    ll.add(8);

    // Utworzenie komparatora odwrotnego
    Comparator<Integer> r = Collections.reverseOrder();

    // Posortowanie listy za pomocą komparatora
    Collections.sort(ll, r);

    System.out.print("Lista posortowana od wartości największej: ");
    for(int i : ll)
      System.out.print(i+ " ");

    System.out.println();

    // Przemieszanie listy
    Collections.shuffle(ll);

    // Wyświetlenie listy w nowej postaci
    System.out.print("Przemieszana lista: ");
    for(int i : ll)
      System.out.print(i + " ");

    System.out.println();

    System.out.println("Minimum: " + Collections.min(ll));
    System.out.println("Maksimum: " + Collections.max(ll));
  }
}
