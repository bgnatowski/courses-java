// Teraz metoda volume() zwraca objętość pudełka

class Box {
  double width;
  double height;
  double depth;

  // Oblicz i zwróć objętość
  double volume() {
    return width * height * depth;
  }
}

class BoxDemo4 {
  public static void main(String args[]) {
    Box mybox1 = new Box();
    Box mybox2 = new Box();
    double vol;

    // Przypisanie wartości do zmiennych obiektu mybox1
    mybox1.width = 10;
    mybox1.height = 20;
    mybox1.depth = 15;

    // Przypisanie wartości do zmiennych obiektu mybox2
    mybox2.width = 3;
    mybox2.height = 6;
    mybox2.depth = 9;

    // Pobranie objętości pierwszego pudełka
    vol = mybox1.volume();
    System.out.println("Objętość: " + vol);

    // Pobranie objętości drugiego pudełka
    vol = mybox2.volume();
    System.out.println("Objętość: " + vol);
  }
}
