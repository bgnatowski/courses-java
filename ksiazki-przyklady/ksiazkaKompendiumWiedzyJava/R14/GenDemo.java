// Prosta klasa sparametryzowana
// T jest parametrem typu, który zostanie zastąpiony 
// rzeczywistym typem w momencie tworzenia
// obiektu Gen
class Gen<T> { 
  T ob; // Deklaracja obiektu typu T 
   
  // Przekazanie konstruktorowi referencji  
  // do obiektu typu T
  Gen(T o) { 
    ob = o; 
  } 
  // Zwrócenie ob
  T getob() { 
    return ob; 
  } 
 
  // Wyświetlenie typu T
  void showType() { 
    System.out.println("Typ T to " + 
                       ob.getClass().getName()); 
  } 
} 
 
// Przykład użycia klasy sparametryzowanej 
class GenDemo { 
  public static void main(String args[]) { 
    // Utworzenie referencji do Gen dla typu Integer  
    Gen<Integer> iOb;
 
    // Utworzenie obiektu Gen<Integer> i przypisanie  
    // referencji do niego do iOb; zwróć uwagę na automatyczne
    // opakowanie wartości 88 w ramach obiektu typu Integer 
    iOb = new Gen<Integer>(88); 
 
    // Pokaż typ danych używany przez iOb
    iOb.showType(); 
 
    // Pobierz wartość w iOb; zauważ, że nie jest 
    // potrzebne żadne rzutowanie 
    int v = iOb.getob(); 
    System.out.println("wartość: " + v); 
 
    System.out.println(); 
 
    // Utworzenie obiektu Gen dla typu String 
    Gen<String> strOb = new Gen<String>("Test typów sparametryzowanych"); 
 
    // Pokaż typ danych używany przez strOb
    strOb.showType(); 
 
    // Pobierz wartość w strOb; także tutaj
    // nie jest potrzebne żadne rzutowanie 
    String str = strOb.getob(); 
    System.out.println("wartość: " + str); 
  } 
}
