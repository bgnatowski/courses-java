// Przykład asercji
class AssertDemo {
  static int val = 3;

  // Zwraca wartość całkowitoliczbową
  static int getnum() {
    return val--;
  }

  public static void main(String args[])
  {
    int n;

    for(int i=0; i < 10; i++) {
      n = getnum();

      assert n > 0; // Spowoduje zgłoszenie wyjątku dla n równego 0

      System.out.println("n wynosi " + n);
    }
  }
}
