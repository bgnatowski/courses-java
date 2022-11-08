// Utworzenie drugiego wątku
class NewThread implements Runnable {
  Thread t;

  NewThread() {
    // Utworzenie nowego, drugiego wątku
    t = new Thread(this, "Przykładowy wątek");
    System.out.println("Wątek potomny: " + t);
  }

  // To jest metoda, od której zaczyna się wykonywanie drugiego wątku
  public void run() {
    try {
      for(int i = 5; i > 0; i--) {
        System.out.println("Wątek potomny: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("Przerwano działanie potomka");
    }
    System.out.println("Wyjście z wątku potomka");
  }
}

class ThreadDemo {
  public static void main(String args[]) {
    NewThread nt = new NewThread(); // Utworzenie nowego wątku

    nt.t.start(); // Uruchomienie wątku

    try {
      for(int i = 5; i > 0; i--) {
        System.out.println("Wątek główny: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Przerwano działanie głównego wątku.");
    }
    System.out.println("Wyjście z wątku głównego");
  }
}
