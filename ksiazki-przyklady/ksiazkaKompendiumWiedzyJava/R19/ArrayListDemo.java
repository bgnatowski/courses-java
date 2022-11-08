// Przykład użycia klasy ArrayList
import java.util.*; 
 
class ArrayListDemo { 
  public static void main(String args[]) { 
    // Utworzenie tablicy dynamicznej
    ArrayList<String> al = new ArrayList<String>(); 
     
    System.out.println("Rozmiar początkowy al: " + 
                       al.size()); 
 
    // Dodanie elementów do obiektu ArrayList
    al.add("C"); 
    al.add("A"); 
    al.add("E"); 
    al.add("B"); 
    al.add("D"); 
    al.add("F"); 
    al.add(1, "A2"); 
 
    System.out.println("Rozmiar al po dodaniu elementów: " + 
                       al.size()); 
 
    // Wyświetlenie zawartości obiektu
    System.out.println("Zawartość al: " + al); 
 
    // Usunięcie elementów z tablicy dynamicznej
    al.remove("F"); 
    al.remove(2); 
 
    System.out.println("Rozmiar al po usunięciach: " + 
                       al.size()); 
    System.out.println("Zawartość al: " + al); 
  } 
}
