// Definicja interfejsu dla stosu liczb całkowitych
interface IntStack {
  void push(int item); // Zapamiętanie elementu
  int pop(); // Pobranie elementu


  /*  Kod dodany w przykładzie z pliku listing_28.java
    
  // Ponieważ metoda clear() definiuje implementację domyślną,
  // zatem nie trzeba jej implementować w istniejących klasach 
  // korzystających z interfejsu IntStack.
  default void clear() {
    System.out.println("Metoda clear() nie została zaimplementowana.");
  }
  */

  /* Kod dodany w przykładzie z pliku listing_30.java
  
  // Metoda domyślna zwracająca tablicę zawierającą 
  // n elementów z wierzchołka stosu.
  default int[] popNElements(int n) {
    // Ta instrukcja żądane elementy.
    return getElements(n);
  }
  
  // Metoda domyślna, która pomija określoną liczbę elementów,
  // a następnie zwraca n kolejnych elementów stosu.
  default int[] skipAndPopNElements(int skip, int n) {
    // To wywołanie pomija podną liczbę elementów z wierzchołka stosu.
    getElements(skip);
    // Ta instrukcja zwraca żądaną liczbę elementów z wierzchołka stosu.
    return getElements(n);
  }
  
  // Metoda prywatna, która zwraca tablicę zawierającą 
  // n elementów z wierzchołka stosu.
  private int[] getElements(int n) {
    int[] elements = new int[n];
    for(int i=0; i < n; i++) elements[i] = pop();
    return elements;
  }
  */  

}
