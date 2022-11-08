// Zastosowanie sparametryzowanego interfejsu funkcyjnego 
// z wyrażeniami lambda
 
// Sparametryzowany interfejs funkcyjny 
interface SomeFunc<T> { 
  T func(T t); 
} 
 
class GenericFunctionalInterfaceDemo { 
  public static void main(String args[]) 
  { 
 
    // Zastosowanie interfejsu SomeFunc z typem String 
    SomeFunc<String> reverse = (str) ->  { 
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
 
    // A teraz interfejs SomeFunc zostanie użyty z typem Integer 
    SomeFunc<Integer> factorial = (n) ->  { 
      int result = 1; 
 
      for(int i=1; i <= n; i++) 
        result = i * result; 
 
      return result; 
    }; 
 
    System.out.println("Silnia liczby 3 wynosi " + factorial.func(3)); 
    System.out.println("Silnia liczby 5 wynosi " + factorial.func(5)); 
  } 
}
