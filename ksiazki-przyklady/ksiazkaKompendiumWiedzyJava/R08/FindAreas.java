// Wykorzystanie polimorfizmu dynamicznego
class Figure {
  double dim1;
  double dim2;

  Figure(double a, double b) {
    dim1 = a;
    dim2 = b;
  }

  double area() {
    System.out.println("Pole figury nie jest zdefiniowane.");
    return 0;
  }
}

class Rectangle extends Figure {
  Rectangle(double a, double b) {
    super(a, b);
  }

  // Przesłonięcie pola dla prostokąta
  double area() {
    System.out.println("Wewnątrz metody area() z Rectangle");
    return dim1 * dim2;
  }
}

class Triangle extends Figure {
  Triangle(double a, double b) {
    super(a, b);
  }

  // Przesłonięcie pola dla trójkąta
  double area() {
    System.out.println("Wewnątrz metody area() z Triangle");
    return dim1 * dim2 / 2;
  }
}

class FindAreas {
  public static void main(String args[]) {
    Figure f = new Figure(10, 10);
    Rectangle r = new Rectangle(9, 5);
    Triangle t = new Triangle(10, 8);

    Figure figref;

    figref = r;
    System.out.println("Pole: " + figref.area());

    figref = t;
    System.out.println("Pole: " + figref.area());

    figref = f;
    System.out.println("Pole: " + figref.area());
  }
}
