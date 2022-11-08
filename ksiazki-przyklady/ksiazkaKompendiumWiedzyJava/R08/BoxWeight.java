// Klasa BoxWeight używa referencji super do inicjalizacji atrybutów klasy Box
class BoxWeight extends Box {
  double weight; // Ciężar pudełka

  // Inicjalizacja width, height i depth za pomocą konstruktora super()
  BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // Wywołanie konstruktora klasy bazowej
    weight = m;
  }
}
