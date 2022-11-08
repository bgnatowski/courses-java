// Długość tekstu a pojemność obiektu StringBuffer
class StringBufferDemo {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer("Witaj");

    System.out.println("bufor = " + sb);
    System.out.println("długość = " + sb.length());
    System.out.println("pojemność = " + sb.capacity());
  }
}
