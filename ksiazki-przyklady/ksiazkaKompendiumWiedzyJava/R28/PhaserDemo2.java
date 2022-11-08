// Rozszerza klasę Phaser i przesłania metodę onAdvance(), tak aby
// była wykonywana określona liczba faz

import java.util.concurrent.*;

// Rozszerza klasę Phaser, aby umożliwić wykonanie
// określonej liczby faz
class MyPhaser extends Phaser {
  int numPhases;

  MyPhaser(int parties, int phaseCount) {
    super(parties);
    numPhases = phaseCount - 1;
  }

  // Przesłania onAdvance(), tak aby obiekt wykonywał
  // określoną liczbę faz
  protected boolean onAdvance(int p, int regParties) {
    // To wywołanie println() ma tylko ilustrować działanie programu
    // W normalnych okolicznościach metoda onAdvance() nie wyświetla danych wynikowych
    System.out.println("Faza nr " + p + " zakończona\n");

    // Jeśli wszystkie fazy zostały zakończone, zwraca wartość true
    if(p == numPhases || regParties == 0) return true;

    // W przeciwnym razie zwraca wartość false
    return false;
  }
}

class PhaserDemo2 {
  public static void main(String args[]) {

    MyPhaser phsr = new MyPhaser(1, 4);

    System.out.println("Start\n");

    new Thread(new MyThread(phsr, "A")).start();
    new Thread(new MyThread(phsr, "B")).start();
    new Thread(new MyThread(phsr, "C")).start();

    // Czeka na zakończenie określonej liczby faz
    while(!phsr.isTerminated()) {
      phsr.arriveAndAwaitAdvance();
    }

    System.out.println("Obiekt klasy Phaser zakończył działanie");
  }
}

// Wątek wykonywania używający obiektu klasy Phaser
class MyThread implements Runnable {
  Phaser phsr;
  String name;

  MyThread(Phaser p, String n) {
    phsr = p;
    name = n;
    phsr.register();
  }

  public void run() {

    while(!phsr.isTerminated()) {
      System.out.println("Wątek " + name + " rozpoczął fazę nr " +
                         phsr.getPhase());

      phsr.arriveAndAwaitAdvance();

      // Chwilowe wstrzymanie działania, aby uniknąć zniekształcenia danych wynikowych
      // Ta część ma na celu tylko ilustrację działania
      // Podobne rozwiązania nie są wymagane do prawidłowego działania klasy Phaser
      try {
        Thread.sleep(100);
      } catch(InterruptedException e) {
        System.out.println(e);
      }
    }
  }
}
