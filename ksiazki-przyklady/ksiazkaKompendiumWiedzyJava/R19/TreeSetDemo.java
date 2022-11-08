// Przykład użycia klasy TreeSet 
import java.util.*; 
 
class TreeSetDemo { 
  public static void main(String args[]) { 
    // Utworzenie drzewa 
    TreeSet<String> ts = new TreeSet<String>(); 
     
    // Dodanie elementów do drzewa 
    ts.add("C"); 
    ts.add("A"); 
    ts.add("B"); 
    ts.add("E"); 
    ts.add("F"); 
    ts.add("D"); 
 
    System.out.println(ts); 
  } 
}
