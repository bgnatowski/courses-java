// Demonstruje różne operacje na strumieniach 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo { 
 
  public static void main(String[] args) { 
 
    // Tworzy listę wartości Integer 
    ArrayList<Integer> myList = new ArrayList<>( ); 
    myList.add(7); 
    myList.add(18); 
    myList.add(10); 
    myList.add(24); 
    myList.add(17); 
    myList.add(5); 
 
    System.out.println("Początkowa lista: " + myList); 
 
    // Pobiera strumień, którego źródłem danych jest lista 
    Stream<Integer> myStream = myList.stream(); 
 
    // Wyznacza wartość minimalną i maksymalną strumienia, używając
    // do tego metod min(), max(), isPresent() oraz get()
    Optional<Integer> minVal = myStream.min(Integer::compare); 
    if(minVal.isPresent()) System.out.println("Wartość minimalna: " + 
                                               minVal.get()); 
 
    // Ze względu na wcześniejsze użycie metody min(), która jest 
    // operacją końcową i powoduje zużycie strumienia,
    // konieczne jest uzyskanie nowego strumienia
    myStream = myList.stream(); 
    Optional<Integer> maxVal = myStream.max(Integer::compare); 
    if(maxVal.isPresent()) System.out.println("Wartość maksymalna: " + 
                                               maxVal.get()); 
 
    // Sortuje strumień za pomocą metody sorted()
    Stream<Integer> sortedStream = myList.stream().sorted(); 
 
    // Wyświetla posortowany strumień, używając metody forEach()
    System.out.print("Posortowany strumień: "); 
    sortedStream.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Wyświetla jedynie wartości nieparzyste, używając do tego 
    // metody filter()
    Stream<Integer> oddVals =  
           myList.stream().sorted().filter((n) -> (n % 2) == 1); 
    System.out.print("Wartości nieparzyste: "); 
    oddVals.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Wyświetla tylko wartości nieparzyste większe od 5; trzeba 
    // zwrócić uwagę, że w tym przypadku zastosowano dwie 
    // operacje filtrowania połączone w potok
    oddVals = myList.stream().filter((n) -> (n % 2) == 1) 
                             .filter((n) -> n > 5); 
    System.out.print("Wyświetla wartości większe od 5: "); 
    oddVals.forEach((n) -> System.out.print(n + " ") ); 
    System.out.println(); 
  } 
}
