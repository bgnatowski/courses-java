// Poprawna implementacja producenta i konsumenta
class Q {
  int n;
  boolean valueSet = false;

  synchronized int get() {
    while(!valueSet)
      try {
        wait();

      } catch(InterruptedException e) {
        System.out.println("Złapano InterruptedException");
      }

      System.out.println("Pobrano: " + n);
      valueSet = false;
      notify();
      return n;
  }

  synchronized void put(int n) {
    while(valueSet)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("Złapano InterruptedException");
      }

      this.n = n;
      valueSet = true;
      System.out.println("Włożono: " + n);
      notify();
  }
}

class Producer implements Runnable {
  Q q;
  Thread t;

  Producer(Q q) {
    this.q = q;
    t = new Thread(this, "Producent");
  }

  public void run() {
    int i = 0;

    while(true) {
      q.put(i++);
    }
  }
}

class Consumer implements Runnable {
  Q q;
  Thread t;

  Consumer(Q q) {
    this.q = q;
    t = new Thread(this, "Konsument");
  }

  public void run() {
    while(true) {
      q.get();
    }
  }
}

class PCFixed {
  public static void main(String args[]) {
    Q q = new Q();
    Producer p = new Producer(q);
    Consumer c = new Consumer(q);

    // Uruchomienie wątków
    p.t.start();
    c.t.start();

    System.out.println("Naciśnij Ctrl+C, aby zakończyć.");
  }
}
