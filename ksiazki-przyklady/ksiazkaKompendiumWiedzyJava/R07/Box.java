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
