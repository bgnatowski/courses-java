// Przedstawia wyrażenie lambda z parametrem
 
// Kolejny interfejs funkcyjny
interface NumericTest { 
 boolean test(int n);  
} 
 
class LambdaDemo2 { 
  public static void main(String args[]) 
  { 
    // Wyrażenie lambda sprawdzające, czy liczba jest parzysta
    NumericTest isEven = (n) -> (n % 2)==0; 
 
    if(isEven.test(10)) System.out.println("10 jest liczbą parzystą"); 
    if(!isEven.test(9)) System.out.println("9 nie jest liczbą parzystą"); 
 
    // A teraz przykład wyrażenia lambda, które sprawdza, czy 
    // przekazana liczba nie jest ujemna
    NumericTest isNonNeg = (n) -> n >= 0; 
 
    if(isNonNeg.test(1)) System.out.println("1 nie jest liczbą ujemną"); 
    if(!isNonNeg.test(-1)) System.out.println("-1 jest liczbą ujemną"); 
  } 
}
