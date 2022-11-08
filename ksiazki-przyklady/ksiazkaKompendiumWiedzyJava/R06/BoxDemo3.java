// Program definiuje metodę wewnątrz klasy Box

class Box {
  double width;
  double height;
  double depth;

  // wyświetlenie objętości pudełka
  void volume() {
    System.out.print("Objętość: ");
    System.out.println(width * height * depth);
  }
}

class BoxDemo3 {
  public static void main(String args[]) {
    Box mybox1 = new Box();
    Box mybox2 = new Box();

    // Przypisanie wartości do zmiennych obiektu mybox1
    mybox1.width = 10;
    mybox1.height = 20;
    mybox1.depth = 15;

    // Przypisanie wartości do zmiennych obiektu mybox2
    mybox2.width = 3;
    mybox2.height = 6;
    mybox2.depth = 9;

    // Wyświetlenie objętości pierwszego pudełka
    mybox1.volume();

    // Wyświetlenie objętości drugiego pudełka
    mybox2.volume();
  }
}
