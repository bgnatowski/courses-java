// Zastosowanie wyrażenia lambda jako argumentu metody
 
interface StringFunc { 
  String func(String n); 
} 
 
class LambdasAsArgumentsDemo { 
 
  // W tej metodzie typem pierwszego parametru jest interfejs 
  // funkcyjny, co oznacza, że można do niej przekazać dowolną 
  // referencję do instancji tego typu, w tym także instancji 
  // utworzonej przy użyciu wyrażenia lambda,
  // natomiast drugi parametr określa łańcuch znakowy, na którym należy 
  // operować
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Wyrażenia lambda rozszerzają możliwości Javy"; 
    String outStr; 
 
    System.out.println("Łańcuch wejściowy: " + inStr); 
 
    // To proste wyrażenie lambda zapisuje łańcuch przekazany 
    // do metody stringOp() wielkimi literami
    outStr = stringOp((str) -> str.toUpperCase(), inStr); 
    System.out.println("Łańcuch zapisany wielkimi literami: " + outStr); 
 
    // Tu do metody stringOp() przekazywane jest blokowe wyrażenie 
    // lambda usuwające z łańcucha znaki odstępu
    outStr = stringOp((str) ->  { 
                       String result = ""; 
                       int i; 
 
                       for(i = 0; i < str.length(); i++) 
                       if(str.charAt(i) != ' ') 
                         result += str.charAt(i); 
 
                       return result; 
                     }, inStr); 
 
    System.out.println("Łańcuch bez znaków odstępu: " + outStr); 
 
 
    // Można także przekazać instancję interfejsu StringFunc 
    // utworzoną przez jedno z wyrażeń lambda przedstawionych 
    // wcześniej; na przykład po wykonaniu tej deklaracji
    // zmienna reverse będzie zawierać sztuczną instancję 
    // interfejsu StringFunc
    StringFunc reverse = (str) ->  { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
    }; 
 
    // Teraz zmienną reverse można przekazać jako pierwszy 
    // argument wywołania metody stringOp(), gdyż zawiera 
    // referencję do obiektu StringFunc
    System.out.println("Odwrócony łańcuch: " + 
                       stringOp(reverse, inStr)); 
  } 
}
