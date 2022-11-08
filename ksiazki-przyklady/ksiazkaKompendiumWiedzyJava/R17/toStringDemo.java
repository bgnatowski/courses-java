// Przykrycie metody toString() w klasie Box
class Box {
  double width;
  double height;
  double depth;

  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  public String toString() {
    return "Wymiary: " + width + " na " + 
            depth + " na " + height + ".";
  }
}

class toStringDemo {
  public static void main(String args[]) {
    Box b = new Box(10, 12, 14);
    String s = "Pudełko b: " + b; // Konkatenacja obiektu Box

    System.out.println(b); // Konwersja obiektu na tekst
    System.out.println(s);
  }
}
