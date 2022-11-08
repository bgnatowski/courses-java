// Błędna implementacja problemu producenta i konsumenta
class Q {
  int n;

  synchronized int get() {
    System.out.println("Pobrano: " + n);
    return n;
  }

  synchronized void put(int n) {
    this.n = n;
    System.out.println("Włożono: " + n);
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

class PC {
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
