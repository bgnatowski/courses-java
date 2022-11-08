// Tablica obiektów typu String
class StringDemo3 {
  public static void main(String args[]) {
    String str[] = { "jeden", "dwa", "trzy" };

    for(int i=0; i<str.length; i++)
      System.out.println("str[" + i + "]: " +
                          str[i]);
  }
}
