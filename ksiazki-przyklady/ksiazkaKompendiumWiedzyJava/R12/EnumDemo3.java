// Użycie konstruktora, zmiennej składowej i metody dla wyliczenia
enum Apple {
  Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

  private int price; // Ceny poszczególnych odmian jabłek

  // Konstruktor
  Apple(int p) { price = p; }

  int getPrice() { return price; }
}

class EnumDemo3 {
  public static void main(String args[])
  {
    Apple ap;

    // Wyświetl cenę odmiany Winesap
    System.out.println("Winesap kosztuje " +
                       Apple.Winesap.getPrice() +
                       " złotych.\n");

    // Wyświetl wszystkie jabłka i ich ceny
    System.out.println("Ceny wszystkich jabłek:");
    for(Apple a : Apple.values())
      System.out.println(a + " kosztuje " + a.getPrice() +
                         " złotych.");
  }
}
