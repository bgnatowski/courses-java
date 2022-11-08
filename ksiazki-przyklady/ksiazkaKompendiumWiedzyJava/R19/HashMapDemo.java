import java.util.*;

class HashMapDemo {
  public static void main(String args[]) {

    // Tworzy mapę jako tablicę mieszającą
    HashMap<String, Double> hm = new HashMap<String, Double>();

    // Umieszcza elementy w mapie
    hm.put("Jan Kowalski", 3434.34);
    hm.put("Piotr Nowak", 123.22);
    hm.put("Joanna Bąk", 1378.00);
    hm.put("Rafał Brzęczyszczykiewicz", 99.22);
    hm.put("Tomek Nosek", -19.08);

    // Pobiera wpisy jako zbiór
    Set<Map.Entry<String, Double>> set = hm.entrySet();

    // Wyświetla zbiór
    for(Map.Entry<String, Double> me : set) {
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }

    System.out.println();

    // Zwiększa stan konta Jana Kowalskiego o 1000 zł
    double balance = hm.get("Jan Kowalski");
    hm.put("Jan Kowalski", balance + 1000);

    System.out.println("Nowy stan konta Jana Kowalskiego: " +
      hm.get("Jan Kowalski"));
  }
}
