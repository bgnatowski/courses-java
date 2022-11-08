// Przykład przechwytywania zmiennych lokalnych z zasięgu, w którym
// wyrażenie lambda zostało zdefiniowane
 
interface MyFunc { 
  int func(int n); 
} 
 
class VarCapture { 
  public static void main(String args[]) 
  { 
    // Zmienna lokalna, którą można przechwycić
    int num = 10; 
 
    MyFunc myLambda = (n) ->  { 
      // To prawidłowy sposób użycia zmiennej num,
      // jej wartość nie jest bowiem modyfikowana
      int v = num + n; 
 
      // Z kolei ta instrukcja jest nieprawidłowa, gdyż 
      // próbuje zmienić wartość zmiennej num
//    num++; 
 
      return v; 
    }; 
 
    // Także ta instrukcja będzie skutkowała zgłoszeniem błędu, gdyż 
    // powoduje ona, że zmienna num traci status zmiennej 
    // praktycznie finalnej
//  num = 9; 
  } 
}
