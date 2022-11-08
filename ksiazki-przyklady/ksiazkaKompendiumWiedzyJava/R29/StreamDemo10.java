// Prezentacja użycia metody trySplit() 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo10 { 
 
  public static void main(String[] args) { 
 
    // Tworzy listę łańcuchów znaków
    ArrayList<String> myList = new ArrayList<>( ); 
    myList.add("alfa"); 
    myList.add("beta"); 
    myList.add("gamma"); 
    myList.add("delta"); 
    myList.add("phi"); 
    myList.add("omega"); 
 
    // Tworzy strumień na podstawie tej listy
    Stream<String> myStream = myList.stream(); 
 
    // Tworzy obiekt Spliterator
    Spliterator<String> splitItr = myStream.spliterator(); 
 
    // Dzieli początkowy iterator na dwie części
    Spliterator<String> splitItr2 = splitItr.trySplit(); 
 
     // Jeśli podział był możliwy, to w pierwszej kolejności 
     // są wyświetlane elementy dostępne za pośrednictwem 
     // obiektu splitItr2
    if(splitItr2 != null) { 
      System.out.println("Zawartość splitItr2: "); 
      splitItr2.forEachRemaining((n) -> System.out.println(n)); 
    } 
     
    // Teraz są wyświetlane pozostałe elementy, dostępne za 
    // pośrednictwem obiektu splitItr
    System.out.println("\nZawartość splitItr: "); 
    splitItr.forEachRemaining((n) -> System.out.println(n)); 
  } 
}
