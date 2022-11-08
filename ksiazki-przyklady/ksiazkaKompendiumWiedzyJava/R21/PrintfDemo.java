// Demonstruje użycie metody printf()

class PrintfDemo {
  public static void main(String args[]) {
    System.out.println("Poniżej przedstawiono kilka wartości liczbowych " +
                      "w różnych formatach.\n");

    System.out.printf("Różne formaty liczb całkowitych: ");
    System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

    System.out.println();

    System.out.printf("Domyślny format liczb zmiennoprzecinkowych: %f\n",
                      1234567.123);
    System.out.printf("Liczba zmiennoprzecinkowa z dodatkowymi przecinkami: %,f\n",
                      1234567.123);
    System.out.printf("Domyślny format ujemnych liczb zmiennoprzecinkowych: %,f\n",
                      -1234567.123);
    System.out.printf("Inna opcja formatowania ujemnych liczb zmiennoprzecinkowych: %,(f\n",
                      -1234567.123);

    System.out.println();

    System.out.printf("Wyrównywanie wartości dodatnich i ujemnych:\n");
    System.out.printf("% ,.2f\n% ,.2f\n",
                      1234567.123, -1234567.123);

  }
}
