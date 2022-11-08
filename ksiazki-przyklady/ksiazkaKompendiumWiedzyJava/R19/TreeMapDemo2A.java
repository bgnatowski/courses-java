// Zastosowanie metody thenComparing() do sortowania na podstawie
// nazwiska, a następnie na podstawie imienia
import java.util.*;  
  
// Komparator porównujący nazwiska
class CompLastNames implements Comparator<String> {  
  public int compare(String aStr, String bStr) {  
    int i, j;  
  
    // Znalezienie indeksu początku nazwiska
    i = aStr.lastIndexOf(' ');  
    j = bStr.lastIndexOf(' ');  
  
    return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));  
  }  
}  

// Sortuje na podstawie całego imienia i nazwiska, jeśli
// nazwiska są takie same
class CompThenByFirstName implements Comparator<String> {
  public int compare(String aStr, String bStr) {
    int i, j;  

    return aStr.compareToIgnoreCase(bStr);  
  }  
}
  
class TreeMapDemo2A {  
  public static void main(String args[]) {  
    // Używa metody thenComparing() do utworzenia komparatora
    // porównującego całe imię i nazwisko, jeśli nazwiska są takie same
    CompLastNames compLN = new CompLastNames();
    Comparator<String> compLastThenFirst =
                         compLN.thenComparing(new CompThenByFirstName());

    // Utworzenie mapy
    TreeMap<String, Double> tm =
                         new TreeMap<String, Double>(compLastThenFirst);  

    // Umieszczenie elementów w mapie
    tm.put("Jan Kowalski", 3434.34);
    tm.put("Piotr Nowak", 123.22);
    tm.put("Joanna Bocian", 1378.00);
    tm.put("Rafał Brzęczyszczykiewicz", 99.22);
    tm.put("Tomek Nowak", -19.08);

    // Pobranie zbioru wpisów
    Set<Map.Entry<String, Double>> set = tm.entrySet();  
  
    // Wyświetlenie elementów
    for(Map.Entry<String, Double> me : set) { 
      System.out.print(me.getKey() + ": ");  
      System.out.println(me.getValue());  
    }  
    System.out.println();  
  
    // Zwiększa stan konta Jana Kowalskiego o 1000 zł
    double balance = tm.get("Jan Kowalski");
    tm.put("Jan Kowalski", balance + 1000);

    System.out.println("Nowy stan konta Jana Kowalskiego: " +
      tm.get("Jan Kowalski"));
  }  
}
