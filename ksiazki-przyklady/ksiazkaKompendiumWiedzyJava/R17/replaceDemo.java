// Przykład użycia metody replace()
class replaceDemo {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer("To jest test.");

    sb.replace(3, 7, "był");
    System.out.println("Po replace: " + sb);
  }
}
