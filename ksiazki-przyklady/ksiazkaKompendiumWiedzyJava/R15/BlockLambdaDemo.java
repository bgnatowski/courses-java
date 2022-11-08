// Blokowe wyrażenie lambda obliczające silnię podanej liczby
 
interface NumericFunc { 
  int func(int n); 
} 
 
class BlockLambdaDemo { 
  public static void main(String args[]) 
  { 
 
    // To blokowe wyrażenie lambda oblicza silnię przekazanej
    // liczby całkowitej
    NumericFunc factorial = (n) ->  { 
      int result = 1; 
 
      for(int i=1; i <= n; i++) 
        result = i * result; 
 
      return result; 
    }; 
 
    System.out.println("Silnia liczby 3 wynosi " + factorial.func(3)); 
    System.out.println("Silnia liczby 5 wynosi " + factorial.func(5)); 
  } 
}
