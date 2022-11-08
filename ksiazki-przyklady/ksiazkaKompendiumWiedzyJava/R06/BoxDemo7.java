/* Klasa Box używa konstruktora sparametryzowanego 
   w celu ustalenia początkowych wymiarów pudełka
*/
class Box {
  double width;
  double height;
  double depth;

  // Konstruktor klasy Box
  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  // Oblicz i zwróć objętość
  double volume() {
    return width * height * depth;
  }
}

class BoxDemo7 {
  public static void main(String args[]) {
    // Deklaracja, alokacja i inicjalizacja obiektów Box
    Box mybox1 = new Box(10, 20, 15);
    Box mybox2 = new Box(3, 6, 9);

    double vol;

    // Pobranie objętości pierwszego pudełka
    vol = mybox1.volume();
    System.out.println("Objętość: " + vol);

    // Pobranie objętości drugiego pudełka
    vol = mybox2.volume();
    System.out.println("Objętość: " + vol);
  }
}
