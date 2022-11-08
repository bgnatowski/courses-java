/* Program korzystający z klasy Box

   Nadaj plikowi nazwę BoxDemo.java
*/
class Box {
  double width;
  double height;
  double depth;
}

// Ta klasa deklaruje obiekt typu Box
class BoxDemo {
  public static void main(String args[]) {
    Box mybox = new Box();
    double vol;

    // Przypisanie wartości zmiennym obiektu mybox
    mybox.width = 10;
    mybox.height = 20;
    mybox.depth = 15;

    // Obliczenie objętości pudełka
    vol = mybox.width * mybox.height * mybox.depth;

    System.out.println("Objętość: " + vol);
  }
}
