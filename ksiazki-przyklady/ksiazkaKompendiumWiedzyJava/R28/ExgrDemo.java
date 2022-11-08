// Przykład wykorzystania klasy Exchanger

import java.util.concurrent.Exchanger;

class ExgrDemo {
  public static void main(String args[]) {
    Exchanger<String> exgr = new Exchanger<String>();

    new Thread(new UseString(exgr)).start();
    new Thread(new MakeString(exgr)).start();
  }
}

// Wątek, który tworzy ciąg znaków
class MakeString implements Runnable {
  Exchanger<String>ex;
  String str;

  MakeString(Exchanger<String> c) {
    ex = c;
    str = new String();
  }

  public void run() {
    char ch = 'A';

    for(int i=0; i<3; i++) {

      // Wypełnianie bufora
      for(int j = 0; j<5; j++)
        str += (char) ch++;

      try {
        // Wymiana pełnego bufora na pusty
        str = ex.exchange(str);
      } catch(InterruptedException exc) {
        System.out.println(exc);
      }
    }
  }
}

// Wątek, który wykorzystuje ciąg znaków
class UseString implements Runnable {
  Exchanger<String> ex;
  String str;

  UseString(Exchanger<String> c) {
    ex = c;
  }

  public void run() {

    for(int i=0; i<3; i++) {
      try {
        // Zamiana pustego bufora na pełny
        str = ex.exchange(new String());
        System.out.println("Otrzymałem: " + str);
      } catch(InterruptedException exc) {
        System.out.println(exc);
      }
    }
  }
}
