// Przykład użycia metod equals() i equalsIgnoreCase()
class equalsDemo {
  public static void main(String args[]) {
    String s1 = "Witaj";
    String s2 = "Witaj";
    String s3 = "Cześć";
    String s4 = "WITAJ";
    System.out.println(s1 + " equals " + s2 + " -> " +
                       s1.equals(s2));
    System.out.println(s1 + " equals " + s3 + " -> " +
                       s1.equals(s3));
    System.out.println(s1 + " equals " + s4 + " -> " +
                       s1.equals(s4));
    System.out.println(s1 + " equalsIgnoreCase " + s4 + " -> " +
                       s1.equalsIgnoreCase(s4));
  }
}
