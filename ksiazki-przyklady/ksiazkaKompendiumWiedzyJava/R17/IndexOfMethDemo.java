class IndexOfMethDemo {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer("jeden dwa jeden");
    int i;
    i = sb.indexOf("jeden");
    System.out.println("Indeks pierwszego wystąpienia: " + i);

    i = sb.lastIndexOf("jeden");
    System.out.println("Indeks ostatniego wystąpienia: " + i);
  }
}
