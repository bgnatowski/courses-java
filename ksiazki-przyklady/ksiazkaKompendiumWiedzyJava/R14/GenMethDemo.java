// Przykład prostej klasy sparametryzowanej
class GenMethDemo {

  // Sprawdza, czy obiekt znajduje się w tablicy
  static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {

    for(int i=0; i < y.length; i++)
      if(x.equals(y[i])) return true;
    
    return false;
  }

  public static void main(String args[]) {

    // Użycie isIn() dla typu Integers
    Integer nums[] = { 1, 2, 3, 4, 5 };

    if(isIn(2, nums))
      System.out.println("2 znajduje się w nums");

    if(!isIn(7, nums))
      System.out.println("7 nie występuje w nums");

    System.out.println();

    // Użycie isIn() dla typu Strings
    String strs[] = { "jeden", "dwa", "trzy",
                      "cztery", "pięć" };

    if(isIn("dwa", strs))
      System.out.println("dwa znajduje się w strs");

    if(!isIn("siedem", strs))
      System.out.println("siedem nie występuje w strs");

    // Tego fragmentu nie uda się skompilować! Typy muszą być zgodne
//    if(isIn("dwa", nums))
//      System.out.println("dwa znajduje się w nums");
  }
}
