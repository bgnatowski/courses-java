// Prosty przykład operacji atomowej

import java.util.concurrent.atomic.*;

class AtomicDemo {

  public static void main(String args[]) {
    new Thread(new AtomThread("A")).start();
    new Thread(new AtomThread("B")).start();
    new Thread(new AtomThread("C")).start();
  }
}

class Shared {
  static AtomicInteger ai = new AtomicInteger(0);
}

// Wątek powodujący zwiększenie wartości zmiennej count
class AtomThread implements Runnable {
  String name;

  AtomThread(String n) {
    name = n;
  }

public void run() {
  
  System.out.println("Uruchamiam " + name);

  for(int i=1; i <= 3; i++) 
    System.out.println(name + " uzyskał wartość: " + 
        Shared.ai.getAndSet(i));
  }
}
