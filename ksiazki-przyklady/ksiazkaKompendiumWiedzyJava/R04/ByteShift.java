// Przesunięcie bajta w lewo
class ByteShift {
  public static void main(String args[]) {
    byte a = 64, b;
    int i;

    i = a << 2;
    b = (byte) (a << 2);

    System.out.println("Oryginalna wartość a: "+a);
    System.out.println("i oraz b: "+i+" "+b);
  }
}
