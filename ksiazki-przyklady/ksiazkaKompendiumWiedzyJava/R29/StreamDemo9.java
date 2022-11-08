// Zastosowanie interfejsu Spliterator 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo9 { 
 
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
 
    // Tworzy obiekt Spliterator dla strumienia
    Spliterator<String> splitItr = myStream.spliterator(); 
 
    // Przetwarza kolejne elementy strumienia
    while(splitItr.tryAdvance((n) -> System.out.println(n))); 
  } 
}
