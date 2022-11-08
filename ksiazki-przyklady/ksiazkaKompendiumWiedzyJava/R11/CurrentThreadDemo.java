// Sterowanie wątkiem głównym
class CurrentThreadDemo {
  public static void main(String args[]) {
    Thread t = Thread.currentThread();

    System.out.println("Aktualny wątek: " + t);

    // Zmiana nazwy wątku
    t.setName("Mój wątek");
    System.out.println("Po zmianie nazwy: " + t);

    try {
      for(int n = 5; n > 0; n--) {
        System.out.println(n);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Przerwanie wątku głównego");
    }
  }
}
