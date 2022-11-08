// Rozszerzenie klasy BoxWeight o koszt wysyłki

// Zaczynamy od klasy Box
class Box {
  private double width;
  private double height;
  private double depth;

  // Tworzenie klonu obiektu
  Box(Box ob) { // Konstruktor otrzymuje obiekt
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }

  // Konstruktor używany, gdy podano wszystkie wymiary
  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  // Konstruktor używany przy braku wymiarów
  Box() {
    width = -1;  // Wartość -1
    height = -1; // wskazuje
    depth = -1;  // niezainicjalizowane pudełko
  }

  // Konstruktor używany do tworzenia sześcianów
  Box(double len) {
    width = height = depth = len;
  }

  // Oblicz i zwróć objętość
  double volume() {
    return width * height * depth;
  }
}

// Dodanie ciężaru
class BoxWeight extends Box {
  double weight; // Ciężar pudełka

  // Tworzenie klonu obiektu
  BoxWeight(BoxWeight ob) { // Konstruktor otrzymuje obiekt
    super(ob);
    weight = ob.weight;
  }

  // Konstruktor używany, gdy podano wszystkie wymiary
  BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // Wywołanie konstruktora klasy bazowej
    weight = m;
  }

  // Konstruktor domyślny
  BoxWeight() {
    super();
    weight = -1;
  }
  // Konstruktor używany do tworzenia sześcianów
  BoxWeight(double len, double m) {
    super(len);
    weight = m;
  }
}

// Dodanie kosztów przesyłki
class Shipment extends BoxWeight {
  double cost;

  // Tworzenie klonu obiektu
  Shipment(Shipment ob) { // Konstruktor otrzymuje obiekt
    super(ob);
    cost = ob.cost;
  }

  // Konstruktor używany, gdy podano wszystkie wymiary
  Shipment(double w, double h, double d,
            double m, double c) {
    super(w, h, d, m); // Wywołanie konstruktora klasy bazowej
    cost = c;
  }

  // Konstruktor domyślny
  Shipment() {
    super();
    cost = -1;
  }

  // Konstruktor używany do tworzenia sześcianów
  Shipment(double len, double m, double c) {
    super(len, m);
    cost = c;
  }
}

class DemoShipment {
  public static void main(String args[]) {
    Shipment shipment1 =
               new Shipment(10, 20, 15, 10, 3.41);
    Shipment shipment2 =
               new Shipment(2, 3, 4, 0.76, 1.28);

    double vol;

    vol = shipment1.volume();
    System.out.println("Objętość shipment1: " + vol);
    System.out.println("Ciężar shipment1: "
                        + shipment1.weight);
    System.out.println("Koszt przesyłki w złotówkach: " + shipment1.cost);
    System.out.println();

    vol = shipment2.volume();
    System.out.println("Objętość shipment2: " + vol);
    System.out.println("Ciężar shipment2: "
                        + shipment2.weight);
    System.out.println("Koszt przesyłki w złotówkach: " + shipment2.cost);
  }
}
