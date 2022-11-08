// Prosty przykład wykorzystania semafora

import java.util.concurrent.*;

class SemDemo {

  public static void main(String args[]) {
    Semaphore sem = new Semaphore(1);

    new Thread(new IncThread(sem, "A")).start();
    new Thread(new DecThread(sem, "B")).start();

  }
}

// Zasoby udostępnione
class Shared {
  static int count = 0;
}

// Wątek, którego uruchomienie powoduje zwiększenie wartości przechowywanej w liczniku
class IncThread  implements Runnable {
  String name;
  Semaphore sem;

  IncThread(Semaphore s, String n) {
    sem = s;
    name = n;
  }

  public void run() {

    System.out.println("Uruchamiam " + name);

    try {
      // Najpierw musimy uzyskać pozwolenie
      System.out.println(name + " czeka na pozwolenie.");
      sem.acquire();
      System.out.println(name + " uzyskał pozwolenie.");

      // Teraz kolej na dostęp do zasobów udostępnionych
      for(int i=0; i < 5; i++) {
        Shared.count++;
        System.out.println(name +  ": " + Shared.count);

        // Teraz, jeśli to możliwe, pozwalamy na zmianę kontekstu
        Thread.sleep(10);
      }
    } catch (InterruptedException exc) {
      System.out.println(exc);
    }

    // Zwalniamy pozwolenie
    System.out.println(name + " zwalnia pozwolenie na dostęp.");
    sem.release();
  }
}

// Wątek, którego uruchomienie powoduje zmniejszenie wartości przechowywanej w liczniku
class DecThread implements Runnable {
  String name;
  Semaphore sem;
  
  DecThread(Semaphore s, String n) {
    sem = s;
    name = n;
  }
  
  public void run() {

    System.out.println("Uruchamiam " + name);

    try {
       // Najpierw musimy uzyskać pozwolenie
      System.out.println(name + " czeka na pozwolenie.");
      sem.acquire();
      System.out.println(name + " uzyskał pozwolenie.");

      // Teraz kolej na dostęp do zasobów udostępnionych
      for(int i=0; i < 5; i++) {
        Shared.count--;
        System.out.println(name +  ": " + Shared.count);

        // Teraz, jeśli to możliwe, pozwalamy na zmianę kontekstu
        Thread.sleep(10);
      }
    } catch (InterruptedException exc) {
      System.out.println(exc);
    }

    // Zwalniamy pozwolenie
    System.out.println(name + " zwalnia pozwolenie na dostęp.");
    sem.release();
  }
}
