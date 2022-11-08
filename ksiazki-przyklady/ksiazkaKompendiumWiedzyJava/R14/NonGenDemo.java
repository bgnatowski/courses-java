// NonGen jest funkcjonalnie równoważne Gen, 
// ale nie używa typów sparametryzowanych
class NonGen {  
  Object ob; // ob jest teraz typu Object 
    
  // Konstruktor otrzymuje referencję 
  // do obiektu typu Object
  NonGen(Object o) {  
    ob = o;  
  }  
  
  // Zwrócenie typu Object
  Object getob() {  
    return ob;  
  }  
 
  // Wyświetlenie typu ob
  void showType() {  
    System.out.println("Typ ob to " +  
                       ob.getClass().getName());  
  }  
}  
  
// Przykład użycia klasy bez typów sparametryzowanych  
class NonGenDemo {  
  public static void main(String args[]) {  
    NonGen iOb;   
  
    // Tworzenie obiektu NonGen i zapisanie w nim wartości
    // typu Integer; automatyczne opakowywanie nadal działa 
    iOb = new NonGen(88);  
  
    // Wyświetlenie typu danych używanego przez iOb
    iOb.showType(); 
 
    // Pobranie wartości iOb
    // Tym razem konieczne jest rzutowanie 
    int v = (Integer) iOb.getob();  
    System.out.println("wartość: " + v);  
  
    System.out.println();  
  
    // Utworzenie innego obiektu NonGen 
    // i zapamiętanie w nim typu String
    NonGen strOb = new NonGen("Test dla braku parametryzacji");  
  
    // Wyświetlenie typu danych używanego przez strOb 
    strOb.showType(); 
 
    // Pobranie wartości strOb 
    // Tym razem również konieczne jest rzutowanie
    String str = (String) strOb.getob();  
    System.out.println("wartość: " + str);  
 
    // Ten kod uda się skompilować, choć jest błędny koncepcyjnie! 
    iOb = strOb; 
    v = (Integer) iOb.getob(); // Błąd w trakcie działania programu! 
  }  
}
