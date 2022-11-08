// Użycie importu statycznego do przeniesienia
// metod sqrt() i pow() do aktualnej przestrzeni nazw
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

// Obliczenie przeciwprostokątnej trójkąta prostokątnego
class Hypot2 {
  public static void main(String args[]) {
    double side1, side2;
    double hypot;

    side1 = 3.0;
    side2 = 4.0;

    // Tutaj wywołań sqrt() i pow() nie trzeba 
    // już poprzedzać nazwą klasy
    hypot = sqrt(pow(side1, 2) + pow(side2, 2));

    System.out.println("Dla przyprostokątnych " +
                       side1 + " i " + side2 +
                       " przeciwprostokątna wynosi " +
                       hypot);
  }
}
