// Program używa sparametryzowanej metody

class Box {
  double width;
  double height;
  double depth;

  // Oblicz i zwróć objętość
  double volume() {
    return width * height * depth;
  }

  // Ustaw wymiary pudełka
  void setDim(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }
}

class BoxDemo5 {
  public static void main(String args[]) {
    Box mybox1 = new Box();
    Box mybox2 = new Box();
    double vol;

    // Inicjalizacja pudełek
    mybox1.setDim(10, 20, 15);
    mybox2.setDim(3, 6, 9);

    // Pobranie objętości pierwszego pudełka
    vol = mybox1.volume();
    System.out.println("Objętość: " + vol);

    // Pobranie objętości drugiego pudełka
    vol = mybox2.volume();
    System.out.println("Objętość: " + vol);
  }
}
