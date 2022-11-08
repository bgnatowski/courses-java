/*  Ten program zawiera błąd
 
    Klasa pochodna musi się pojawić przed klasą bazową
    w ciągu klauzul catch, bo jeśli tak się nie stanie, 
    powstanie nieosiągalny kod i
    kompilator zgłosi błąd
*/
class SuperSubCatch {
  public static void main(String args[]) {
    try {
      int a = 0;
      int b = 42 / a;
    } catch(Exception e) {
      System.out.println("Przechwycenie ogólnego wyjątku");
    }
    /* Ta klauzula catch nigdy nie zostanie wykonana, ponieważ
       ArithmeticException to klasa pochodna klasy Exception */
    catch(ArithmeticException e) { // BŁĄD - nieosiągalność kodu
      System.out.println("Program nigdy tego nie wykona.");
    }
  }
}
