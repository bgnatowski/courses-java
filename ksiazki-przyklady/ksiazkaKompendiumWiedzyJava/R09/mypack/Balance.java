package mypack;

/* Teraz klasa Balance, jej konstruktor oraz metoda
   show() są publiczne, co oznacza to, że mogą być używane
   przez klasy z innych pakietów
*/
public class Balance {
  String name;
  double bal;

  public Balance(String n, double b) {
    name = n;
    bal = b;
  }

  public void show() {
    if(bal<0)
      System.out.print("-->> ");
    System.out.println(name + ": " + bal+ " zł");
  }
}
