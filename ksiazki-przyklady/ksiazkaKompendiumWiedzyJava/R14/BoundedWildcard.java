// Ograniczone argumenty wieloznaczne

// Współrzędne dwuwymiarowe
class TwoD {
  int x, y;

  TwoD(int a, int b) {
    x = a;
    y = b;
  }
}
// Współrzędne trójwymiarowe
class ThreeD extends TwoD {
  int z;

  ThreeD(int a, int b, int c) {
    super(a, b);
    z = c;
  }
}

// Współrzędne czterowymiarowe
class FourD extends ThreeD {
  int t;

  FourD(int a, int b, int c, int d) {
    super(a, b, c);
    t = d;
  }
}

// Klasa przechowuje tablicę obiektów współrzędnych
class Coords<T extends TwoD> {
  T[] coords;

  Coords(T[] o) { coords = o; }
}

// Przykład użycia ograniczonego argumentu wieloznacznego
class BoundedWildcard {
  static void showXY(Coords<?> c) {
    System.out.println("Współrzędne X Y:");
    for(int i=0; i < c.coords.length; i++)
      System.out.println(c.coords[i].x + " " +
                         c.coords[i].y);
    System.out.println();
  }

  static void showXYZ(Coords<? extends ThreeD> c) {
    System.out.println("Współrzędne X Y Z:");
    for(int i=0; i < c.coords.length; i++)
      System.out.println(c.coords[i].x + " " +
                         c.coords[i].y + " " +
                         c.coords[i].z);
    System.out.println();
  }

  static void showAll(Coords<? extends FourD> c) {
    System.out.println("Współrzędne X Y Z T:");
    for(int i=0; i < c.coords.length; i++)
      System.out.println(c.coords[i].x + " " +
                         c.coords[i].y + " " +
                         c.coords[i].z + " " +
                         c.coords[i].t);
    System.out.println();
  }

  public static void main(String args[]) {
    TwoD td[] = {
      new TwoD(0, 0),
      new TwoD(7, 9),
      new TwoD(18, 4),
      new TwoD(-1, -23)
    };

    Coords<TwoD> tdlocs = new Coords<TwoD>(td);

    System.out.println("Zawartość tdlocs");
    showXY(tdlocs); // Poprawne, jest typu TwoD
//  showXYZ(tdlocs); // Błąd, nie jest typu ThreeD
//  showAll(tdlocs); // Błąd, nie jest typu FourD

    // Utworzenie kilku obiektów FourD
    FourD fd[] = {
      new FourD(1, 2, 3, 4),
      new FourD(6, 8, 14, 8),
      new FourD(22, 9, 4, 9),
      new FourD(3, -2, -23, 17)
    };

    Coords<FourD> fdlocs = new Coords<FourD>(fd);

    System.out.println("Zawartość fdlocs");
    // Teraz wszystkie wywołania są poprawne
    showXY(fdlocs);
    showXYZ(fdlocs);
    showAll(fdlocs);
  }
}
