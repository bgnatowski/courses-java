// Przykład użycia klasy LinkedList 
import java.util.*; 
 
class LinkedListDemo { 
  public static void main(String args[]) { 
    // Utworzenie listy 
    LinkedList<String> ll = new LinkedList<String>(); 
     
    // Dodanie elementów do listy 
    ll.add("F"); 
    ll.add("B"); 
    ll.add("D"); 
    ll.add("E"); 
    ll.add("C"); 
    ll.addLast("Z"); 
    ll.addFirst("A"); 
 
    ll.add(1, "A2"); 
 
    System.out.println("Pierwotna zawartość ll: " + ll); 
 
    // Usunięcie elementów z listy 
    ll.remove("F"); 
    ll.remove(2); 
 
    System.out.println("Zawartość ll po usunięciu: " 
                       + ll); 
 
    // Usunięcie pierwszego i ostatniego elementu 
    ll.removeFirst(); 
    ll.removeLast(); 
 
    System.out.println("Zawartość ll po usunięciu pierwszego i ostatniego elementu:  " 
                       + ll); 
 
    // Pobranie i ustawienie wartości 
    String val = ll.get(2); 
    ll.set(2, val + " zmienione"); 
 
    System.out.println("Zawartość ll po zmianie: " + ll); 
  } 
}
