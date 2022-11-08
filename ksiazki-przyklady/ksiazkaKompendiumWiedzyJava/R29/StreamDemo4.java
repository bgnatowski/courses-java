// Odwzorowuje jeden strumień na drugi 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo4 { 
 
  public static void main(String[] args) { 
 
    // Lista wartości typu double 
    ArrayList<Double> myList = new ArrayList<>( ); 
 
    myList.add(7.0); 
    myList.add(18.0); 
    myList.add(10.0); 
    myList.add(24.0); 
    myList.add(17.0); 
    myList.add(5.0); 
 
    // Odwzorowuje pierwiastki kwadratowe elementów myList do 
    // nowego strumienia
    Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a)); 
 
    // Oblicza iloczyn pierwiastków kwadratowych 
    double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a,b) -> a*b); 
 
    System.out.println("Iloczyn pierwiastków kwadratowych: " + productOfSqrRoots); 
  } 
}
