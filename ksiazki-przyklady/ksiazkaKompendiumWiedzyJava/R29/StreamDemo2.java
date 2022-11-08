// Prezentacja metody reduce() 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo2 { 
 
  public static void main(String[] args) { 
 
    // Tworzy listę wartości Integer
    ArrayList<Integer> myList = new ArrayList<>( ); 
 
    myList.add(7); 
    myList.add(18); 
    myList.add(10); 
    myList.add(24); 
    myList.add(17); 
    myList.add(5); 
 
    // Dwa sposoby określenia iloczynu wszystkich elementów 
    // strumienia przy użyciu dwóch wersji metody reduce()
    Optional<Integer> productObj = myList.stream().reduce((a,b) -> a*b); 
    if(productObj.isPresent()) 
      System.out.println("Iloczyn jako wartość typu Optional: " + productObj.get()); 
 
    int product = myList.stream().reduce(1, (a,b) -> a*b); 
    System.out.println("Iloczyn jako wartość typu int: " + product); 
  } 
}
