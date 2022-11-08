// Demonstruje tworzenie referencji do konstruktorów 
// klas sparametryzowanych
 
// MyFunc jest obecnie sparametryzowanym interfejsem
// funkcyjnym
interface MyFunc<T> { 
   MyClass<T> func(T n); 
} 
 
class MyClass<T> { 
  private T val; 
 
  // Ten konstruktor wymaga przekazania jednego argumentu
  MyClass(T v) { val = v; } 
 
  // To jest konstruktor domyślny
  MyClass( ) { val = null;  } 
 
  // ...
 
  T getVal() { return val; };   
}     
 
class ConstructorRefDemo2 { 
 
  public static void main(String args[]) 
  { 
    // Tworzy referencję do konstruktora klasy MyClass<T>
    MyFunc<Integer> myClassCons = MyClass<Integer>::new; 
 
    // Tworzy instancję klasy MyClass<T> przy użyciu 
    // referencji do konstruktora
    MyClass<Integer> mc = myClassCons.func(100); 
 
    // Używa utworzonej wcześniej instancji klasy MyClass<T> 
    System.out.println("Zapisana wartość to: " + mc.getVal( )); 
  } 
}
