// Program tworzy dwa obiekty klasy Box

class Box {
  double width;
  double height;
  double depth;
}
  
class BoxDemo2 {
  public static void main(String args[]) {
    Box mybox1 = new Box();
    Box mybox2 = new Box();
    double vol;

    // Przypisanie wartości do zmiennych obiektu mybox1
    mybox1.width = 10;
    mybox1.height = 20;
    mybox1.depth = 15;

    // Przypisanie innych wartości do zmiennych obiektu mybox2
    mybox2.width = 3;
    mybox2.height = 6;
    mybox2.depth = 9;

    // Obliczenie objętości pierwszego pudełka
    vol = mybox1.width * mybox1.height * mybox1.depth;
    System.out.println("Objętość: " + vol);

    // Obliczenie objętości drugiego pudełka
    vol = mybox2.width * mybox2.height * mybox2.depth;
    System.out.println("Objętość: " + vol);
  }
}
