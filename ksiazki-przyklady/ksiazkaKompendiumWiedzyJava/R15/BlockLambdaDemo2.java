// Blokowe wyrażenie lambda odwracające kolejność znaków
// w łańcuchu
 
interface StringFunc { 
  String func(String n); 
} 
 
class BlockLambdaDemo2 { 
  public static void main(String args[]) 
  { 
 
    // To blokowe wyrażenie lambda odwraca kolejność
    // znaków w łańcuchu
    StringFunc reverse = (str) ->  { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
    }; 
 
    System.out.println("Lambda po odwróceniu to: " + 
                         reverse.func("Lambda")); 
    System.out.println("Wyrażenia po odwróceniu to: " + 
                         reverse.func("Wyrażenia")); 
  } 
}
