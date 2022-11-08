// Prosty przykład stosowania obiektów Spliterator
import java.util.*; 
 
class SpliteratorDemo { 

  public static void main(String args[]) { 
    // Tworzy listę wartości typu Double
    ArrayList<Double> vals = new ArrayList<>(); 
     
    // Dodaje wartości do listy
    vals.add(1.0); 
    vals.add(2.0); 
    vals.add(3.0); 
    vals.add(4.0); 
    vals.add(5.0); 
 
    // Wyświetla zawartość listy vals, używając metody tryAdvance()
    System.out.print("Zawartość vals:\n"); 
    Spliterator<Double> spltitr = vals.spliterator(); 
    while(spltitr.tryAdvance((n) -> System.out.println(n)));
    System.out.println();  

    // Tworzy nową listę zawierającą pierwiastki kwadratowe
    spltitr = vals.spliterator(); 
    ArrayList<Double> sqrs = new ArrayList<>();
    while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));

    // Wyświetla zawartość sqrs, używając metody forEachRemaining
    System.out.print("Zawartość sqrs:\n"); 
    spltitr = sqrs.spliterator(); 
    spltitr.forEachRemaining((n) -> System.out.println(n));
    System.out.println();  
  }
}
