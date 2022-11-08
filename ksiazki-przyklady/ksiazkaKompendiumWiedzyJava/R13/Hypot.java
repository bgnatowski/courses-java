// Obliczenie przeciwprostokątnej trójkąta prostokątnego
class Hypot {
  public static void main(String args[]) {
    double side1, side2;
    double hypot;

    side1 = 3.0;
    side2 = 4.0;

    // Zauważ, że metody sqrt() i pow() trzeba poprzedzać
    // nazwą klasy, w której się znajdują — Math
    hypot = Math.sqrt(Math.pow(side1, 2) +
                      Math.pow(side2, 2));

    System.out.println("Dla przyprostokątnych " +
                       side1 + " i " + side2 +
                       " przeciwprostokątna wynosi " +
                       hypot);
  }
}
