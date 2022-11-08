// Poprawna wersja
class ThrowsDemo {
  static void throwOne() throws IllegalAccessException {
    System.out.println("Wewnątrz throwOne");
    throw new IllegalAccessException("demo");
  }
  public static void main(String args[]) {
    try {
      throwOne();
    } catch (IllegalAccessException e) {
      System.out.println("Przechwycono " + e);
    }
  }
}
