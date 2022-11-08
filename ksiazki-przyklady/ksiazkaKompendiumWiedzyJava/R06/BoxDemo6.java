/* Klasa Box używa konstruktora 
   w celu ustalenia początkowych wymiarów pudełka
*/
class Box {
  double width;
  double height;
  double depth;

  // Konstruktor klasy Box
  Box() {
    System.out.println("Konstrukcja obiektu Box");
    width = 10;
    height = 10;
    depth = 10;
  }

  // Oblicz i zwróć objętość
  double volume() {
    return width * height * depth;
  }
}

class BoxDemo6 {
  public static void main(String args[]) {
    // Deklaracja, alokacja i inicjalizacja obiektów Box
    Box mybox1 = new Box();
    Box mybox2 = new Box();

    double vol;

    // Pobranie objętości pierwszego pudełka
    vol = mybox1.volume();
    System.out.println("Objętość: " + vol);

    // Pobranie objętości drugiego pudełka
    vol = mybox2.volume();
    System.out.println("Objętość: " + vol);
  }
}
