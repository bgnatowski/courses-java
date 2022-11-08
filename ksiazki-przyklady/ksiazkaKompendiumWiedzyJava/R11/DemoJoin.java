// Użycie metody join() do oczekiwania na zakończenie wątku
class NewThread implements Runnable {
  String name; // Nazwa wątku
  Thread t;

  NewThread(String threadname) {
    name = threadname;
    t = new Thread(this, name);
    System.out.println("Nowy wątek: " + t);
  }

  // To jest metoda, od której zaczyna się wykonywanie drugiego wątku
  public void run() {
    try {
      for(int i = 5; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Przerwano " + name);
    }
    System.out.println("Zakończenie " + name);
  }
}

class DemoJoin {
  public static void main(String args[]) {
    NewThread nt1 = new NewThread("Jeden");
    NewThread nt2 = new NewThread("Dwa");
    NewThread nt3 = new NewThread("Trzy");

    // Uruchomienie wątków
    nt1.t.start();
    nt2.t.start();
    nt3.t.start();

    System.out.println("Wątek Jeden żyje: "
                        + nt1.t.isAlive());
    System.out.println("Wątek Dwa żyje: "
                        + nt2.t.isAlive());
    System.out.println("Wątek Trzy żyje: "
                        + nt3.t.isAlive());
    // Oczekiwanie na zakończenie wątków
    try {
      System.out.println("Oczekiwanie na zakończenie wątków");
      nt1.t.join();
      nt2.t.join();
      nt3.t.join();
    } catch (InterruptedException e) {
      System.out.println("Przerwano wątek główny");
    }

    System.out.println("Wątek Jeden żyje: "
                        + nt1.t.isAlive());
    System.out.println("Wątek Dwa żyje: "
                        + nt2.t.isAlive());
    System.out.println("Wątek Trzy żyje: "
                        + nt3.t.isAlive());

    System.out.println("Koniec wątku głównego");
  }
}
