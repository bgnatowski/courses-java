// Aby skompilować ten interfejs należy zapisać go w pliku o nazwie IntStack.java

interface IntStack {
  void push(int item); // Zapamiętanie elementu
  int pop(); // Pobranie elementu

  // Ponieważ metoda clear() definiuje implementację domyślną,
  // nie trzeba jej implementować w istniejących klasach 
  // korzystających z interfejsu IntStack
  default void clear() {
    System.out.println("Metoda clear() nie została zaimplementowana.");
  }
}
