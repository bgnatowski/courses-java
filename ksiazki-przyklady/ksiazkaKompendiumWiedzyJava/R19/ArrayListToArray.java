// Konwertuje kolekcję ArrayList na tablicę
import java.util.*;  
  
class ArrayListToArray {  
  public static void main(String args[]) {  
    // Utworzenie obiektu ArrayList
    ArrayList<Integer> al = new ArrayList<Integer>();  
      
    // Dodanie elementów do tablicy dynamicznej
    al.add(1);  
    al.add(2);  
    al.add(3);  
    al.add(4);  
  
    System.out.println("Zawartość al: " + al);  
  
    // Pobranie tablicy
    Integer ia[] = new Integer[al.size()];  
    ia = al.toArray(ia);  
  
    int sum = 0;  
  
    // Suma tablicy. 
    for(int i : ia) sum += i;  
  
    System.out.println("Suma: " + sum);  
  }  
}
