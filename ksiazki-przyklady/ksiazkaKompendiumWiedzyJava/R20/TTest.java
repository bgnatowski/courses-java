// Demonstruje użycie klas Timer i TimerTask

import java.util.*;

class MyTimerTask extends TimerTask {
  public void run() {
    System.out.println("Uruchomiono planowane zadanie.");
  }
}

class TTest {
  public static void main(String args[]) {
    MyTimerTask myTask = new MyTimerTask();
    Timer myTimer = new Timer();

    /* Ustawia początkowy czas wstrzymania równy 1 sekundzie,
       po czym powtarza działanie co pół sekundy
    */
    myTimer.schedule(myTask, 1000, 500);
    
    try {
      Thread.sleep(5000);
    } catch (InterruptedException exc) {}

    myTimer.cancel();
  }
}
