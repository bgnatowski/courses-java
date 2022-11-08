// Pełna implementacja klasy BoxWeight
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

// Teraz klasa BoxWeight w pełni implementuje wszystkie konstruktory
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
  
class DemoSuper {
  public static void main(String args[]) {
    BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
    BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
    BoxWeight mybox3 = new BoxWeight(); // Domyślny
    BoxWeight mycube = new BoxWeight(3, 2);
    BoxWeight myclone = new BoxWeight(mybox1);
    double vol;

    vol = mybox1.volume();
    System.out.println("Objętość mybox1: " + vol);
    System.out.println("Ciężar mybox1: " + mybox1.weight);
    System.out.println();

    vol = mybox2.volume();
    System.out.println("Objętość mybox2: " + vol);
    System.out.println("Ciężar mybox2: " + mybox2.weight);
    System.out.println();

    vol = mybox3.volume();
    System.out.println("Objętość mybox3: " + vol);
    System.out.println("Ciężar mybox3: " + mybox3.weight);
    System.out.println();
 
    vol = myclone.volume();
    System.out.println("Objętość myclone: " + vol);
    System.out.println("Ciężar myclone: " + myclone.weight);
    System.out.println();

    vol = mycube.volume();
    System.out.println("Objętość mycube: " + vol);
    System.out.println("Ciężar mycube: " + mycube.weight);
    System.out.println();
  }
}
