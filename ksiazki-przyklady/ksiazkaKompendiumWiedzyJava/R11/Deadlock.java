// Przykład zakleszczenia
class A {
  synchronized void foo(B b) {
    String name = Thread.currentThread().getName();

    System.out.println(name + " wszedł do A.foo");

    try {
      Thread.sleep(1000);
    } catch(Exception e) {
      System.out.println("Przerwano A");
    }

    System.out.println(name + " próbuje wywołać B.last()");
    b.last();
  }

  synchronized void last() {
    System.out.println("Wewnątrz A.last");
  }
}

class B {
  synchronized void bar(A a) {
    String name = Thread.currentThread().getName();
    System.out.println(name + " wszedł do B.bar");

    try {
      Thread.sleep(1000);
    } catch(Exception e) {
      System.out.println("Przerwano B");
    }

    System.out.println(name + " próbuje wywołać A.last()");
    a.last();
  }

  synchronized void last() {
    System.out.println("Wewnątrz B.last");
  }
}

class Deadlock implements Runnable {
  A a = new A();
  B b = new B();
  Thread t;

  Deadlock() {
    Thread.currentThread().setName("Wątek główny");
    t = new Thread(this, "Wątek wyścigu");
  }

  void deadlockStart() {
    t.start();
    a.foo(b); // Uzyskanie blokady na a w tym wątku
    System.out.println("Powrót do wątku głównego");
  }

  public void run() {
    b.bar(a); // Uzyskanie blokady na b w drugim wątku
    System.out.println("Powrót do wątku głównego");
  }

  public static void main(String args[]) {
    Deadlock dl = new Deadlock();

    dl.deadlockStart();
  }
}
