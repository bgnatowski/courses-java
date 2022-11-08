// Przykład użycia klasy Hashtable
import java.util.*;

class HTDemo {
  public static void main(String args[]) {
    Hashtable<String, Double> balance =
      new Hashtable<String, Double>();

    Enumeration<String> names;
    String str;
    double bal;

    balance.put("Jan Kowalski", 3434.34);
    balance.put("Piotr Nowak", 123.22);
    balance.put("Joanna Bąk", 1378.00);
    balance.put("Rafał Brzęczyszczykiewicz", 99.22);
    balance.put("Tomek Nosek", -19.08);

    // Wyświetla wszystkie konta z tablicy mieszającej
    names = balance.keys();
    while(names.hasMoreElements()) {
      str = names.nextElement();
      System.out.println(str + ": " +
                         balance.get(str));
    }

    System.out.println();

    // Zwiększa stan konta Jana Kowalskiego o 1000 zł
    bal = balance.get("Jan Kowalski");
    balance.put("Jan Kowalski", bal+1000);
    System.out.println("Nowy stan konta Jana Kowalskiego: " +
                       balance.get("Jan Kowalski"));
  }
}
