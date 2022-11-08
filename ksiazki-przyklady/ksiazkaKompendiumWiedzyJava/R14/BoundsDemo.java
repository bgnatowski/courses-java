// W tej wersji klasy Stats argumentem typu T
// musi być klasa Number lub jedna z jej podklas
class Stats<T extends Number> {
  
  T[] nums; // Tablica Number lub jej podklasy

  // Przekazanie do konstruktora referencji do
  // tablicy typu Number lub jej podklasy
  Stats(T[] o) {
    nums = o;
  }

  // Zawsze zwracanie średniej jako typu double
  double average() {
    double sum = 0.0;

    for(int i=0; i < nums.length; i++)
      sum += nums[i].doubleValue();

    return sum / nums.length;
  }
}

// Przykład użycia klasy Stats
class BoundsDemo {
  public static void main(String args[]) {

    Integer inums[] = { 1, 2, 3, 4, 5 };
    Stats<Integer> iob = new Stats<Integer>(inums);
    double v = iob.average();
    System.out.println("Średnia dla iob wynosi " + v);

    Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
    Stats<Double> dob = new Stats<Double>(dnums);
    double w = dob.average();
    System.out.println("Średnia dla dob wynosi " + w);

    // Tego fragmentu nie uda się skompilować, ponieważ String
    // nie jest podklasą klasy Number
//    String strs[] = { "1", "2", "3", "4", "5" };
//    Stats<String> strob = new Stats<String>(strs);

//    double x = strob.average();
//    System.out.println("Średnia dla strob wynosi " + v);

  }
}
