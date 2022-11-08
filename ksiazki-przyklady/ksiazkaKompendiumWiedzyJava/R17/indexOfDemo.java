// Przykład użycia indexOf() i lastIndexOf()
class indexOfDemo {
  public static void main(String args[]) {
    String s = "Czy być miłym znaczy to samo co być dobrym? " +
               "Czy bycie dobrym jest równoznaczne z byciem miłym?";

    System.out.println(s);
    System.out.println("indexOf(b) = " +
                       s.indexOf('b'));
    System.out.println("lastIndexOf(b) = " +
                       s.lastIndexOf('b'));
    System.out.println("indexOf(być) = " +
                       s.indexOf("być"));
    System.out.println("lastIndexOf(być) = " +
                       s.lastIndexOf("być"));
    System.out.println("indexOf(b, 10) = " +
                       s.indexOf('b', 10));
    System.out.println("lastIndexOf(b, 60) = " +
                       s.lastIndexOf('b', 60));
    System.out.println("indexOf(być, 10) = " +
                       s.indexOf("być", 10));
    System.out.println("lastIndexOf(bycie, 60) = " +
                       s.lastIndexOf("bycie", 60));
  }
}
