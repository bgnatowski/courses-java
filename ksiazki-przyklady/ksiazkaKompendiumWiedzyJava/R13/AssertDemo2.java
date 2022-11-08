// Bardzo zły sposób stosowania asercji!!!
class AssertDemo2 {
  // Ustalenie wartości początkowej
  static int val = 3;

  // Zwrócenie liczby całkowitej
  static int getnum() {
    return val--;
  }

  public static void main(String args[])
  {
    int n = 0;

    for(int i=0; i < 10; i++) {

      assert (n = getnum()) > 0; // To na pewno nie jest dobry pomysł!

      System.out.println("n wynosi " + n);
    }
  }
}
