// Zastosowanie wbudowanego interfejsu funkcyjnego Function 

// Importuje interfejs Function 
import java.util.function.Function;

class UseFunctionInterfaceDemo {
  public static void main(String args[])
  {
    // To blokowe wyrażenie lambda wyznacza silnię liczby całkowitej 
    // W tym rozwiązaniu został zastosowany budowany 
    // interfejs funkcyjny Function 
    Function<Integer, Integer> factorial = (n) -> {
      int result = 1;
      for(int i=1; i <= n; i++)
        result = i * result;
      return result;
    };

    System.out.println("Silnia liczby 3 wynosi " + factorial.apply(3));
    System.out.println("Silnia liczby 5 wynosi " + factorial.apply(5));
  }
}
