// Przykładowa klasa sparametryzowana z dwoma  
// parametrami typu: T i V 
class TwoGen<T, V> { 
  T ob1; 
  V ob2; 
   
  // Przekazanie do konstruktora referencji do 
  // obiektów typu T i V 
  TwoGen(T o1, V o2) { 
    ob1 = o1; 
    ob2 = o2; 
  } 
 
  // Wyświetlenie typów T i V 
  void showTypes() { 
    System.out.println("Typ T to " + 
                       ob1.getClass().getName()); 
 
    System.out.println("Typ V to " + 
                       ob2.getClass().getName()); 
  } 
 
  T getob1() { 
    return ob1; 
  } 
 
  V getob2() { 
    return ob2; 
  } 
} 
 
// Przykład użycia klasy TwoGen 
class SimpGen { 
  public static void main(String args[]) { 
 
    TwoGen<Integer, String> tgObj = 
      new TwoGen<Integer, String>(88, "Parametryzacja"); 
 
    // Wyświetlenie typów 
    tgObj.showTypes(); 
 
    // Pobranie i wyświetlenie wartości 
    int v = tgObj.getob1(); 
    System.out.println("wartość: " + v); 
 
    String str = tgObj.getob2(); 
    System.out.println("wartość: " + str); 
  } 
}
