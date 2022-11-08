// Przykład prostej blokady

import java.util.concurrent.locks.*;

class LockDemo {

  public static void main(String args[]) {
    ReentrantLock lock = new ReentrantLock();

    new Thread(new LockThread(lock, "A")).start();
    new Thread(new LockThread(lock, "B")).start();
  }
}

// Zasób udostępniony
class Shared {
  static int count = 0;
}

// Wątek zwiększający wartość przechowywaną w zmiennej count
class LockThread implements Runnable {
  String name;
  ReentrantLock lock;

  LockThread(ReentrantLock lk, String n) {
    lock = lk;
    name = n;
  }
  
  public void run() {
  
    System.out.println("Uruchamiam " + name);

    try {
      // Najpierw blokujemy dostęp do zmiennej count
      System.out.println(name + " czeka na zablokowanie zmiennej count.");
      lock.lock();
      System.out.println(name + " zablokował zmienną count.");

      Shared.count++;
      System.out.println(name + ": " + Shared.count);

      // Teraz pozwalamy na zmianę kontekstu (jeśli jest możliwa)
      System.out.println(name + " został zatrzymany.");
      Thread.sleep(1000);
    } catch (InterruptedException exc) {
      System.out.println(exc);
    } finally {
      // Odblokowywanie
      System.out.println(name + " odblokowuje zmienną count.");
      lock.unlock();
    }
  }
}
