// Implementacja producenta i konsumenta
// wykorzystująca semafory do kontrolowania synchronizacji

import java.util.concurrent.Semaphore;

class Q {
  int n;

  // Zaczynamy od wyłączenia semafora konsumenta
  static Semaphore SemCon = new Semaphore(0);
  static Semaphore SemProd = new Semaphore(1);

  void get () {
    try {
      semCon.acquire();
    } catch(InterruptedException e) {
      System.out.println("Wyjątek InterruptedException przechwycony");
    }

    System.out.println("Pobrane: " + n);
    semProd.release();
  }

  void put(int n) {
    try{
      semProd.acquire();
    } catch(InterruptedException e) {
      System.out.println("Wyjątek InterruptedException przechwycony");
    }

    this.n = n;
    System.out.println("Włożone: " + n);
    semCon.release();
  }
}

class Producer implements Runnable {
  Q q;
  
  Producer(Q q) {
    this.q = q;
  }
  
  public void run() {
    for(int i=0; i<20; i++) q.put(i);
  }
}

class Consumer implements Runnable {
   Q q;

  Consumer(Q q) {
    this.q = q;
  }

  public void run() {
    for(int i=0; i<20; i++) q.get();
  }
}

class ProdCon {
  public static void main(String args[]) {
    Q q = new Q();
    new Thread(new Consumer(q), "Konsument").start();
    new Thread(new Producer(q), "Producent").start();
  }
}
