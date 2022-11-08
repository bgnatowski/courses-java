/* Klasa Box zawiera trzy konstruktory, które
   na różne sposoby inicjalizują wymiary pudełka
*/
class Box {
  double width;
  double height;
  double depth;

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

class OverloadCons {
  public static void main(String args[]) {
    // Utworzenie pudełek za pomocą różnych konstruktorów
    Box mybox1 = new Box(10, 20, 15);
    Box mybox2 = new Box();
    Box mycube = new Box(7);

    double vol;

    // Pobranie objętości pierwszego pudełka
    vol = mybox1.volume();
    System.out.println("Objętość mybox1 wynosi " + vol);

    // Pobranie objętości drugiego pudełka
    vol = mybox2.volume();
    System.out.println("Objętość mybox2 wynosi " + vol);

    // Pobranie objętości sześcianu
    vol = mycube.volume();
    System.out.println("Objętość mycube wynosi " + vol);
  }
}
