// Ten program nie korzysta z synchronizacji
class Callme {
  void call(String msg) {
    System.out.print("[" + msg);
    try {
      Thread.sleep(1000);
    } catch(InterruptedException e) {
      System.out.println("Przerwano");
    }
    System.out.println("]");
  }
}

class Caller implements Runnable {
  String msg;
  Callme target;
  Thread t;

  public Caller(Callme targ, String s) {
    target = targ;
    msg = s;
    t = new Thread(this);
  }

  public void run() {
    target.call(msg);
  }
}

class Synch {
  public static void main(String args[]) {
    Callme target = new Callme();
    Caller ob1 = new Caller(target, "Witaj");
    Caller ob2 = new Caller(target, "Zsynchronizowany");
    Caller ob3 = new Caller(target, "Świecie");

    // Uruchomienie wątków
    ob1.t.start();
    ob2.t.start();
    ob3.t.start();

    // Czeka na zakończenie wątków
    try {
      ob1.t.join();
      ob2.t.join();
      ob3.t.join();
    } catch(InterruptedException e) {
      System.out.println("Przerwano");
    }
  }
}
