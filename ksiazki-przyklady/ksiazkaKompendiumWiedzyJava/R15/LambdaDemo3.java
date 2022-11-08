// Przedstawia wyrażenie lambda z dwoma parametrami
 
interface NumericTest2 { 
  boolean test(int n, int d); 
} 
 
class LambdaDemo3 { 
  public static void main(String args[]) 
  { 
    // To wyrażenie lambda sprawdza, czy jedna liczba jest
    // czynnikiem drugiej
    NumericTest2 isFactor = (n, d) -> (n % d) == 0; 
 
    if(isFactor.test(10, 2)) 
      System.out.println("Liczba 2 jest czynnikiem liczby 10"); 
 
    if(!isFactor.test(10, 3)) 
      System.out.println("Liczba 3 nie jest czynnikiem liczby 10");
  } 
}
