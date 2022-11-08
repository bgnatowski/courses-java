// Zastosowanie iteratorów i strumieni
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo8 { 
 
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
 
    // Pobiera iterator dla strumienia 
    Iterator<String> itr = myStream.iterator(); 
 
    // Wyświetla poszczególne elementy strumienia, używając 
    // iteratora 
    while(itr.hasNext())  
      System.out.println(itr.next()); 
  } 
}
