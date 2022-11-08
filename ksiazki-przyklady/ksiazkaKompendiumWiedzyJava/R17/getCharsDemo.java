class getCharsDemo {
  public static void main(String args[]) {
    String s = "To jest przykład użycia metody getChars().";
    int start = 8;
    int end = 16;
    char buf[] = new char[end - start];

    s.getChars(start, end, buf, 0);
    System.out.println(buf);
  }
}
