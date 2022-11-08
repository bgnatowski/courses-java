// Kolejna wersja interfejsu IntStack, do której dodano
// metodę prywatną, używaną przez dwie metody domyślne
interface IntStack {
  void push(int item); // Zapamiętanie elementu
  int pop(); // Pobranie elementu
  
  // Metoda domyślna zwracająca tablicę zawierającą 
  // n elementów z wierzchołka stosu
  default int[] popNElements(int n) {
    // Ta instrukcja zwraca żądane elementy
    return getElements(n);
  }
  
  // Metoda domyślna, która pomija określoną liczbę elementów,
  // a następnie zwraca n kolejnych elementów stosu
  default int[] skipAndPopNElements(int skip, int n) {
    // To wywołanie pomija podaną liczbę elementów z wierzchołka stosu
    getElements(skip);
    // Ta instrukcja zwraca żądaną liczbę elementów z wierzchołka stosu
    return getElements(n);
  }
  
  // Metoda prywatna, która zwraca tablicę zawierającą 
  // n elementów z wierzchołka stosu
  private int[] getElements(int n) {
    int[] elements = new int[n];
    for(int i=0; i < n; i++) elements[i] = pop();
    return elements;
  }
}
