// Przykład użycia iteratorów
import java.util.*;

class IteratorDemo {
  public static void main(String args[]) {
    // Utworzenie tablicy dynamicznej
    ArrayList<String> al = new ArrayList<String>();

    // Dodanie elementów do tablicy
    al.add("C");
    al.add("A");
    al.add("E");
    al.add("B");
    al.add("D");
    al.add("F");

    // Użycie iteratora do wyświetlenia zawartości al
    System.out.print("Pierwotna zawartość al: ");
    Iterator<String> itr = al.iterator();
    while(itr.hasNext()) {
      String element = itr.next();
      System.out.print(element + " ");
    }
    System.out.println();

    // Modyfikacja iterowanych elementów
    ListIterator<String> litr = al.listIterator();
    while(litr.hasNext()) {
      String element = litr.next();
      litr.set(element + "+");
    }

    System.out.print("Zmodyfikowana zawartość al: ");
    itr = al.iterator();
    while(itr.hasNext()) {
      String element = itr.next();
      System.out.print(element + " ");
    }
    System.out.println();

    // Wyświetlenie tablicy od końca
    System.out.print("Zawartość al od końca: ");
    while(litr.hasPrevious()) {
      String element = litr.previous();
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
