// Przekształca Stream do intStream 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo6 { 
 
  public static void main(String[] args) { 
 
    // Lista wartości typu double
    ArrayList<Double> myList = new ArrayList<>( ); 
 
    myList.add(1.1); 
    myList.add(3.6); 
    myList.add(9.2); 
    myList.add(4.7); 
    myList.add(12.1); 
    myList.add(5.0); 
 
    System.out.print("Początkowa zawartość myList: "); 
    myList.stream().forEach( (a) -> { 
      System.out.print(a + " "); 
    }); 
    System.out.println(); 
 
    // Dla każdego elementu strumienia wyznacza najmniejszą liczbę 
    // całkowitą, większą od danego elementu; wyniki są zwracane 
    // w formie strumienia IntStream
    IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a)); 
 
    System.out.print("Lista myList po przekształceniu: "); 
    cStrm.forEach( (a) -> { 
      System.out.print(a + " "); 
    }); 
 
  } 
}
