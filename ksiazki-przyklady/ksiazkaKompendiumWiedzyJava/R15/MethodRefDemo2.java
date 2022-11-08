// Prezentacja referencji do metod instancyjnych
 
// Interfejs funkcyjny reprezentujący operacje na łańcuchach
interface StringFunc { 
  String func(String n); 
} 
 
// W tym przypadku klasa definiuje metodę instancyjną o nazwie
// strReverse()
class MyStringOps { 
  String strReverse(String str) { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
  } 
}     
 
class MethodRefDemo2 { 
 
  // Ta metoda ma pierwszy parametr, którego typem jest 
  // interfejs funkcyjny, a zatem można do niej przekazać
  // dowolną instancję tego interfejsu, w tym także referencję do
  // metody
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Wyrażenia lambda zwiększają możliwości Javy"; 
    String outStr; 
 
    // Tworzy obiekt klasy MyStringOps
    MyStringOps strOps = new MyStringOps( ); 
 
    // Teraz do metody stringOp() przekazywana jest referencja do 
    // instancyjnej metody strReverse
    outStr = stringOp(strOps::strReverse, inStr); 
 
    System.out.println("Pierwotny łańcuch: " + inStr); 
    System.out.println("Odwrócony łańcuch: " + outStr); 
  } 
}
