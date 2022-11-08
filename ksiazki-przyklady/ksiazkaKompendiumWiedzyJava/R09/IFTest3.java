/* Utworzenie zmiennej referencyjnej interfejsu i
   użycie jej do dostępu do stosu
*/
class IFTest3 {
  public static void main(String args[]) {
    IntStack mystack; // Utworzenie zmiennej referencyjnej interfejsu
    DynStack ds = new DynStack(5);
    FixedStack fs = new FixedStack(8);

    mystack = ds; // Załadowanie stosu dynamicznego
    // Umieszczenie wartości na stosie
    for(int i=0; i<12; i++) mystack.push(i);

    mystack = fs; // Załadowanie stosu o stałym rozmiarze
    for(int i=0; i<8; i++) mystack.push(i);

    mystack = ds;
    System.out.println("Wartości na stosie dynamicznym:");
    for(int i=0; i<12; i++)
       System.out.println(mystack.pop());

    mystack = fs;
    System.out.println("Wartości na stosie o stałym rozmiarze:");
    for(int i=0; i<8; i++)
       System.out.println(mystack.pop());
  }
}
