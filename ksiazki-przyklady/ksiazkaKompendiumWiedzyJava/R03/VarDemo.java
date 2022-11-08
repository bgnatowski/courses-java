// Prosta prezentacja wnioskowania typów zmiennych lokalnych
class VarDemo {
  public static void main(String args[]) {

    // Użycie wnioskowania do określenia typu zmiennej avg
    // W tym przypadku wywnioskowanym typem będzie double
    var avg = 10.0;
    System.out.println("Wartość zmiennej avg wynosi " + avg);
    
    // W tym kontekście var nie jest predefiniowanym identyfikatorem
    // Jest zwyczajną nazwą zmiennej definiowaną przez programistę
    int var = 1;
    System.out.println("Wartość zmiennej var wynosi " + var);
    
    // Co ciekawe, w poniższej instrukcji var jest używane
    // zarówno jako typ w deklaracji, jak i nazwa zmiennej 
    // w inicjalizatorze
    var k = -var;
    System.out.println("Wartość zmiennej k wynosi " + k);
  }
}
