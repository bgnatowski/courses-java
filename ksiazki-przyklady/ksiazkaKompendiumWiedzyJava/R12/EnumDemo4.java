// Przykład użycia metod ordinal(), compareTo() i equals()

// Wyliczenie odmian jabłek
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class EnumDemo4 {
  public static void main(String args[])
  {
    Apple ap, ap2, ap3;

    // Pobranie wartości przypisanych do stałych - metoda ordinal()
    System.out.println("Oto wszystkie stałe wyliczenia" +
                       " i ich wartości liczbowe: ");
    for(Apple a : Apple.values())
      System.out.println(a + " " + a.ordinal());

    ap =  Apple.RedDel;
    ap2 = Apple.GoldenDel;
    ap3 = Apple.RedDel;

    System.out.println();

    // Przykład zastosowania metod compareTo() i equals()
    if(ap.compareTo(ap2) < 0)
      System.out.println(ap + " znajduje się przed " + ap2);

    if(ap.compareTo(ap2) > 0)
      System.out.println(ap2 + " znajduje się przed " + ap);

    if(ap.compareTo(ap3) == 0)
      System.out.println(ap + " jest równe " + ap3);

    System.out.println();

    if(ap.equals(ap2))
      System.out.println("Błąd!");

    if(ap.equals(ap3))
      System.out.println(ap + " jest równe " + ap3);
    if(ap == ap3)
      System.out.println(ap + " == " + ap3);

  }
}
