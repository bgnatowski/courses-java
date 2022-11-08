// Zastosowanie argumentu wieloznacznego
class Stats<T extends Number> {
  T[] nums; // Tablica obiektów klasy Number lub jej podklasy

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

  // Sprawdź, czy dwie średnie są identyczne
  // Zauważ użycie argumentu wieloznacznego
  boolean sameAvg(Stats<?> ob) {
    if(average() == ob.average())
      return true;

    return false;
  }
}

// Przykład użycia argumentu wieloznacznego
class WildcardDemo {
  public static void main(String args[]) {
    Integer inums[] = { 1, 2, 3, 4, 5 };
    Stats<Integer> iob = new Stats<Integer>(inums);
    double v = iob.average();
    System.out.println("Średnia iob wynosi " + v);

    Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
    Stats<Double> dob = new Stats<Double>(dnums);
    double w = dob.average();
    System.out.println("Średnia dob wynosi " + w);

    Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
    Stats<Float> fob = new Stats<Float>(fnums);
    double x = fob.average();
    System.out.println("Średnia fob wynosi " + x);

    // Sprawdź, które tablice mają takie same średnie
    System.out.print("Średnie iob i dob są ");
    if(iob.sameAvg(dob))
      System.out.println("takie same");
    else
      System.out.println("różne");

    System.out.print("Średnie iob i fob są ");
    if(iob.sameAvg(fob))
      System.out.println("takie same");
    else
      System.out.println("różne");
  }
}
