// Implementuje prostą metodę wytwórczą, używając 
// przy tym referencji do konstruktora
 
interface MyFunc<R, T> { 
   R func(T n); 
} 
 
// Prosta klasa sparametryzowana
class MyClass<T> { 
  private T val; 
 
  // Konstruktor z jednym parametrem
  MyClass(T v) { val = v; } 
 
  // Konstruktor domyślny; ten konstruktor
  // NIE jest używany w tym programie 
  MyClass() { val = null; } 
  // ...
 
  T getVal() { return val; };   
}     
 
// Prosta klasa niesparametryzowana
class MyClass2 { 
  String  str; 
 
  // Konstruktor z jednym parametrem
  MyClass2(String s) { str = s; } 
 
  // Konstruktor domyślny; ten konstruktor
  // NIE jest używany w tym programie
  MyClass2() { str = ""; } 
 
  // ...
 
  String getVal() { return str; };   
}     
 
class ConstructorRefDemo3 { 
 
  // Metoda wytwórcza do tworzenia obiektów; klasa musi 
  // definiować konstruktor z jednym parametrem typu T,
  // R określa typ tworzonego obiektu
  static <R,T> R myClassFactory(MyFunc<R, T> cons, T v) { 
    return cons.func(v); 
  } 
  
  public static void main(String args[]) 
  { 
    // Tworzy referencję do konstruktora klasy MyClass
    // W tym przypadku new odwołuje się do konstruktora pobierającego
    // jeden argument
    MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new; 
 
    // Tworzy instancję klasy MyClass, używając w tym celu
    // metody wytwórczej
    MyClass<Double> mc = myClassFactory(myClassCons, 100.1); 
 
    // Używa utworzonej wcześniej instancji klasy MyClass
    System.out.println("Zapisana wartość to: " + mc.getVal( )); 
 
    // Tworzy referencję do konstruktora innej klasy
    MyFunc<MyClass2, String> myClassCons2 = MyClass2::new; 
 
    // Tworzy instancję klasy MyClass2, używając w tym celu 
    // metody wytwórczej
    MyClass2 mc2 = myClassFactory(myClassCons2, "Lambda"); 
 
    // Używa utworzonej wcześniej instancji klasy MyClass2
    System.out.println("Łańcuch w zmiennej mc2 to: " + mc2.getVal( )); 
  } 
}
