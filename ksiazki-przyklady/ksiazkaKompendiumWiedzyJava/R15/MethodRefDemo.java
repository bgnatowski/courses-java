// Prezentacja referencji do metod statycznych
 
// Interfejs funkcyjny reprezentujący operacje na łańcuchach
interface StringFunc { 
  String func(String n); 
} 
 
// Ta klasa definiuje metodę statyczną o nazwie strReverse()
class MyStringOps { 
  // Metoda statyczna odwracająca kolejność znaków w łańcuchu
  static String strReverse(String str) { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
  } 
}     
 
class MethodRefDemo { 
 
  // Ta metoda ma pierwszy parametr, którego typem jest 
  // interfejs funkcyjny, a zatem można do niej przekazać
  // dowolną instancję tego interfejsu, w tym także referencję
  // do metody
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Wyrażenia lambda zwiększają możliwości Javy"; 
    String outStr; 
 
    // Tutaj do wywołania metody stringOp() zostaje przekazana
    // referencja do metody strReverse
    outStr = stringOp(MyStringOps::strReverse, inStr); 

    System.out.println("Pierwotny łańcuch: " + inStr); 
    System.out.println("Odwrócony łańcuch: " + outStr); 
  } 
}
