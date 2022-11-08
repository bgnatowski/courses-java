// Ten program zawiera błąd, więc nie uda się go skompilować
// UWAGA - aby skompilować tę klasę, należy ją zapisać w pliku ThrowsDemo.java
class ThrowsDemo {
  static void throwOne() {
    System.out.println("Wewnątrz throwOne");
    throw new IllegalAccessException("demo");
  }
  public static void main(String args[]) {
    throwOne();
  }
}
