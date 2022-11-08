// Przykład grup wątków
class NewThread extends Thread {
  boolean suspendFlag;

  NewThread(String threadname, ThreadGroup tgOb) {
    super(tgOb, threadname);
    System.out.println("Nowy wątek: " + this);
    suspendFlag = false;
  }

  // Początek wątku
  public void run() {
    try {
      for(int i = 5; i > 0; i--) {
        System.out.println(getName() + ": " + i);
        Thread.sleep(1000);
        synchronized(this) {
          while(suspendFlag) {
            wait();
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Wyjątek w " + getName());
    }
    System.out.println(getName() + " zakończony");
  }

  void mysuspend() {
    suspendFlag = true;
  }

  synchronized void myresume() {
    suspendFlag = false;
    notify();
  }
}

class ThreadGroupDemo {
  public static void main(String args[]) {
    ThreadGroup groupA = new ThreadGroup("Grupa A");
    ThreadGroup groupB = new ThreadGroup("Grupa B");

    NewThread ob1 = new NewThread("Jeden", groupA);
    NewThread ob2 = new NewThread("Dwa", groupA);
    NewThread ob3 = new NewThread("Trzy", groupB);
    NewThread ob4 = new NewThread("Cztery", groupB);

    ob1.start();
    ob2.start();
    ob3.start();
    ob4.start();

    System.out.println("\nOto wynik działania list():");
    groupA.list();
    groupB.list();
    System.out.println();
    
    System.out.println("Zawieszenie grupy A");
    Thread tga[] = new Thread[groupA.activeCount()];
    groupA.enumerate(tga); // Pobranie wątków z grupy
    for(int i = 0; i < tga.length; i++) {
      ((NewThread)tga[i]).mysuspend(); // Zawieszenie poszczególnych wątków
    }

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      System.out.println("Przerwano główny wątek");
    }

    System.out.println("Wznowienie grupy A");
    for(int i = 0; i < tga.length; i++) {
      ((NewThread)tga[i]).myresume(); // Wznowienie wątków z grupy
    }

    // Oczekiwanie na zakończenie wątków
    try {
      System.out.println("Oczekiwanie na zakończenie wątków");
      ob1.join();
      ob2.join();
      ob3.join();
      ob4.join();
    } catch (Exception e) {
      System.out.println("Wyjątek w głównym wątku");
    }

    System.out.println("Zakończenie wątku głównego");
  }
}
