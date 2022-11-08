// Przykład użycia kilku metod klasy String
class StringDemo2 {
  public static void main(String args[]) {
    String strOb1 = "Pierwszy tekst";
    String strOb2 = "Drugi tekst";
    String strOb3 = strOb1;

    System.out.println("Długość strOb1: " +
                       strOb1.length());

    System.out.println("Znak o indeksie 3 z strOb1: " +
                       strOb1.charAt(3));

    if(strOb1.equals(strOb2))
      System.out.println("strOb1 == strOb2");
    else
      System.out.println("strOb1 != strOb2");

    if(strOb1.equals(strOb3))
      System.out.println("strOb1 == strOb3");
    else
      System.out.println("strOb1 != strOb3");
  }
}
