import java.util.*;

class TreeMapDemo {
  public static void main(String args[]) {

    // Tworzy mapę jako drzewo
    TreeMap<String, Double> tm = new TreeMap<String, Double>();

    // Umieszcza elementy w mapie
    tm.put("Jan Kowalski", 3434.34);
    tm.put("Piotr Nowak", 123.22);
    tm.put("Joanna Bąk", 1378.00);
    tm.put("Rafał Brzęczyszczykiewicz", 99.22);
    tm.put("Tomek Nosek", -19.08);

    // Pobiera wpisy jako zbiór
    Set<Map.Entry<String, Double>> set = tm.entrySet();

    // Wyświetla zbiór
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
