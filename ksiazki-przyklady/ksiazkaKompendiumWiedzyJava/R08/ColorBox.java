// Nowa klasa rozszerza klasę Box o zmienną color
class ColorBox extends Box {
  int color; // Kolor pudełka

  ColorBox(double w, double h, double d, int c) {
    width = w;
    height = h;
    depth = d;
    color = c;
  }
}
