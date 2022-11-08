// Przykład zastosowania metod charAt() i setCharAt()
class setCharAtDemo {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer("Witaj");
    System.out.println("bufor przed = " + sb);
    System.out.println("charAt(1) przed = " + sb.charAt(1));

      sb.setCharAt(1, 'y');
      sb.setLength(2);
      System.out.println("bufor po = " + sb);
      System.out.println("charAt(1) po = " + sb.charAt(1));
  }
}
