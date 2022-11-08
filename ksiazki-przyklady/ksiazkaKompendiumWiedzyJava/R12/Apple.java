// Użycie domyślnego konstruktora wyliczenia
enum Apple {
  Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);
  private int price; // Ceny poszczególnych odmian jabłek

  // Konstruktor
  Apple(int p) { price = p; }

  // Przeciążony konstruktor
  Apple() { price = -1; }

  int getPrice() { return price; }
}
