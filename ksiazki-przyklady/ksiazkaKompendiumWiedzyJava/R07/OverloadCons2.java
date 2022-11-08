// Jeden obiekt Box może posłużyć do inicjalizacji innego obiektu Box

class Box {
  double width;
  double height;
  double depth;

  // Tworzenie klonu obiektu
  Box(Box ob) { // Przekazanie obiektu do konstruktora
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
  
class OverloadCons2 {
  public static void main(String args[]) {
    // Tworzenie pudełek za pomocą różnych konstruktorów
    Box mybox1 = new Box(10, 20, 15);
    Box mybox2 = new Box();
    Box mycube = new Box(7);

    Box myclone = new Box(mybox1); // Tworzenie kopii obiektu mybox1

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

    // Pobranie objętości klonu
    vol = myclone.volume();
    System.out.println("Objętość clone wynosi " + vol);
  }
}
