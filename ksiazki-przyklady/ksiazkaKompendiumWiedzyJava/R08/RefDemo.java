class RefDemo {
  public static void main(String args[]) {
    BoxWeight weightbox = new BoxWeight(3, 5, 7, 8.37);
    Box plainbox = new Box();
    double vol;

    vol = weightbox.volume();
    System.out.println("Objętość weightbox: " + vol);
    System.out.println("Ciężar weightbox: " + weightbox.weight);
    System.out.println();

    // Przypisanie referencji BoxWeight do referencji Box
    plainbox = weightbox;

    vol = plainbox.volume(); // Poprawne, metoda volume() jest zdefiniowana dla Box
    System.out.println("Objętość plainbox: " + vol);

    /* Poniższa instrukcja nie jest poprawna, ponieważ plainbox
       nie definiuje składowej weight */
    // System.out.println("Waga obiektu plainbox wynosi: " + plainbox.weight);
  }
}
