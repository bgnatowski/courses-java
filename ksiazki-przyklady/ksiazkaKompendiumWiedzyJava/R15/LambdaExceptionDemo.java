// Zgłaszanie wyjątków w wyrażeniach lambda
 
interface DoubleNumericArrayFunc { 
  double func(double[] n) throws EmptyArrayException; 
} 
 
class EmptyArrayException extends Exception { 
  EmptyArrayException() { 
    super("Tablica jest pusta"); 
  } 
} 
 
class LambdaExceptionDemo { 
 
  public static void main(String args[]) throws EmptyArrayException 
  { 
    double[] values  = { 1.0, 2.0, 3.0, 4.0 }; 
 
    // To blokowe wyrażenie lambda oblicza średnią liczb typu 
    // double zapisanych w przekazanej tablicy
    DoubleNumericArrayFunc average = (n) ->  { 
      double sum = 0; 
 
      if(n.length == 0) 
        throw new EmptyArrayException(); 
 
      for(int i=0; i < n.length; i++) 
        sum += n[i]; 
 
      return sum / n.length; 
    }; 
 
    System.out.println("Średnia wynosi " + average.func(values)); 
 
    // To wywołanie spowoduje zgłoszenie wyjątku
    System.out.println("Średnia wynosi " + average.func(new double[0])); 
  } 
}
