// Wykorzystanie komparatora do porównywania nazwisk
import java.util.*;

// Porównywanie całych słów w dwóch łańcuchach
class TComp implements Comparator<String> {
  public int compare(String aStr, String bStr) {
    int i, j, k;

    // Znalezienie indeksu początku nazwiska
    i = aStr.lastIndexOf(' ');
    j = bStr.lastIndexOf(' ');

    k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));  
    if(k==0) // Nazwiska są takie same, sprawdź imiona
      return aStr.compareToIgnoreCase(bStr);  
    else
      return k;
  }

  // Nie ma potrzeby przesłaniania metody equals()
}

class TreeMapDemo2 {
  public static void main(String args[]) {
    // Utworzenie mapy
    TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());

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
