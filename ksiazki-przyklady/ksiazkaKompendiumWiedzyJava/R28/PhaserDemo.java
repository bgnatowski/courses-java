// Przykład użycia klasy Phaser

import java.util.concurrent.*;

class PhaserDemo {
  public static void main(String args[]) {
    Phaser phsr = new Phaser(1);
    int curPhase;

    System.out.println("Start");

    new Thread(new MyThread(phsr, "A")).start();
    new Thread(new MyThread(phsr, "B")).start();
    new Thread(new MyThread(phsr, "C")).start();

    // Czeka, aż wszystkie wątki zakończą pierwszą fazę
    curPhase = phsr.getPhase();
    phsr.arriveAndAwaitAdvance();
    System.out.println("Faza nr " + curPhase + " zakończona");

    // Czeka, aż wszystkie wątki zakończą drugą fazę
    curPhase = phsr.getPhase();
    phsr.arriveAndAwaitAdvance();
    System.out.println("Faza nr " + curPhase + " zakończona");

    curPhase = phsr.getPhase();
    phsr.arriveAndAwaitAdvance();
    System.out.println("Faza nr " + curPhase + " zakończona");

    // Wyrejestrowuje główny wątek
    phsr.arriveAndDeregister();

    if(phsr.isTerminated())
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

    System.out.println("Wątek " + name + " rozpoczął fazę nr 1");
    phsr.arriveAndAwaitAdvance(); // Wysłanie sygnału

    // Chwilowe wstrzymanie działania, aby uniknąć zniekształcenia danych wynikowych
    // Ta część ma na celu tylko ilustrację działania
    // Podobne rozwiązania nie są wymagane do prawidłowego działania klasy Phaser
    try {
      Thread.sleep(100);
    } catch(InterruptedException e) {
      System.out.println(e);
    }

    System.out.println("Wątek " + name + " rozpoczął fazę nr 2");
    phsr.arriveAndAwaitAdvance(); // Wysłanie sygnału

    // Chwilowe wstrzymanie działania, aby uniknąć zniekształcenia danych wynikowych
    // Ta część ma na celu tylko ilustrację działania
    // Podobne rozwiązania nie są wymagane do prawidłowego działania klasy Phaser
    try {
      Thread.sleep(100);
    } catch(InterruptedException e) {
      System.out.println(e);
    }

    System.out.println("Wątek " + name + " rozpoczął fazę nr 3");
    phsr.arriveAndDeregister(); // Wysłanie sygnału i wyrejestrowanie
  }
}
