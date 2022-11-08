// Przykład użycia metod delete() i deleteCharAt()
class deleteDemo {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer("To jest test.");

    sb.delete(2, 7);
    System.out.println("Po delete: " + sb);

    sb.deleteCharAt(0);
    System.out.println("Po deleteCharAt: " + sb);
  }
}
