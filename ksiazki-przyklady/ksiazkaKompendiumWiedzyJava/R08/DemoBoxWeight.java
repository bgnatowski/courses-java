// Program używa dziedziczenia dla rozszerzenia klasy Box
class Box {
  double width;
  double height;
  double depth;

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

// Oto wersja klasy Box rozszerzona o zmienną weight
class BoxWeight extends Box {
  double weight; // Ciężar pudełka

  // Konstruktor dla BoxWeight
  BoxWeight(double w, double h, double d, double m) {
    width = w;
    height = h;
    depth = d;
    weight = m;
  }    
}
  
class DemoBoxWeight {
  public static void main(String args[]) {
    BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
    BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
    double vol;

    vol = mybox1.volume();
    System.out.println("Objętość mybox1: " + vol);
    System.out.println("Ciężar mybox1: " + mybox1.weight);
    System.out.println();

    vol = mybox2.volume();
    System.out.println("Objętość mybox2: " + vol);
    System.out.println("Ciężar mybox2: " + mybox2.weight);
  }
}
