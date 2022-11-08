// Program demonstrujący tworzenie i stosowanie 
// referencji do konstruktorów
 
// MyFunc jest interfejsem funkcyjnym, którego metoda 
// zwraca referencję typu MyClass
interface MyFunc { 
   MyClass func(int n); 
} 
 
class MyClass { 
  private int val; 
 
  // Ten konstruktor wymaga przekazania jednego argumentu
  MyClass(int v) { val = v; } 
 
  // To jest konstruktor domyślny
  MyClass() { val = 0; } 
 
  // ...
 
  int getVal() { return val; };   
}     
 
class ConstructorRefDemo { 
  public static void main(String args[]) 
  { 
    // Ta instrukcja tworzy referencję do konstruktora 
    // klasy MyClass; ponieważ metoda func() interfejsu
    // MyFunc ma jeden parametr, w tym przypadku 
    // słowo new odwołuje się do konstruktora klasy MyClass,
    // który ma jeden parametr, a nie do konstruktora
    // domyślnego
    MyFunc myClassCons = MyClass::new; 
 
    // Tworzy instancję klasy MyClass, wywołując konstruktor
    // za pomocą utworzonej wcześniej referencji
    MyClass mc = myClassCons.func(100); 
 
    // Używa utworzonej wcześniej instancji klasy MyClass
    System.out.println("Zapisana wartość to: " + mc.getVal( )); 
  } 
}
