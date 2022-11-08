// Wstrzymywanie i wznawianie wątku w nowoczesny sposób
class NewThread implements Runnable {
  String name; // Nazwa wątku
  Thread t;
  boolean suspendFlag;

  NewThread(String threadname) {
    name = threadname;
    t = new Thread(this, name);
    System.out.println("Nowy wątek: " + t);
    suspendFlag = false;
  }

  // To jest punkt startowy wątku
  public void run() {
    try {
      for(int i = 15; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(200);
        synchronized(this) {
          while(suspendFlag) {
            wait();
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println(name + " został przerwany");
    }

    System.out.println("Wyjście z wątku " + name);
  }

  synchronized void mysuspend() {
    suspendFlag = true;
  }

  synchronized void myresume() {
    suspendFlag = false;
    notify();
  }
}

class SuspendResume {
  public static void main(String args[]) {
    NewThread ob1 = new NewThread("Jeden");
    NewThread ob2 = new NewThread("Dwa");

    ob1.t.start();   // Uruchomienie wątku
    ob2.t.start();   // Uruchomienie wątku

    try {
      Thread.sleep(1000);
      ob1.mysuspend();
      System.out.println("Zawieszenie wątku Jeden");
      Thread.sleep(1000);
      ob1.myresume();
      System.out.println("Wznowienie wątku Jeden");
      ob2.mysuspend();
      System.out.println("Zawieszenie wątku Dwa");
      Thread.sleep(1000);
      ob2.myresume();
      System.out.println("Wznowienie wątku Dwa");
    } catch (InterruptedException e) {
      System.out.println("Przerwanie wątku głównego");
    }

    // Oczekuje na zakończenie wątków
    try {
      System.out.println("Oczekiwanie na zakończenie wątków");
      ob1.t.join();
      ob2.t.join();
    } catch (InterruptedException e) {
      System.out.println("Przerwanie wątku głównego");
    }

    System.out.println("Koniec wątku głównego");
  }
}
