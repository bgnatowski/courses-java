// Program przedstawia użycie referencji do metod do 
// wywoływania metody sparametryzowanej zadeklarowanej
// w niesparametryzowanej klasie
 
// Interfejs funkcyjny operujący na tablicy i wartości,
// który zwraca wynik typu int
interface MyFunc<T> { 
  int func(T[] vals, T v); 
} 
 
// Ta klasa definiuje metodę o nazwie countMatching(), która
// zwraca liczbę elementów tablicy równych przekazanej
// wartości; należy zwrócić uwagę, że metoda countMatching() 
// jest sparametryzowana, natomiast sama klasa MyArrayOps nie jest
class MyArrayOps { 
  static <T> int countMatching(T[] vals, T v) { 
    int count = 0; 
 
    for(int i=0; i < vals.length; i++) 
      if(vals[i] == v) count++; 
 
      return count; 
  } 
}     
 
class GenericMethodRefDemo { 
 
  // Typem pierwszego parametru tej metody jest interfejs funkcyjny
  // MyFunc, pozostałe dwa parametry umożliwiają przekazanie tablicy 
  // i wartości typu T
  static <T> int myOp(MyFunc<T> f, T[] vals, T v) { 
    return f.func(vals, v); 
  } 
 
  public static void main(String args[]) 
  { 
    Integer[] vals = { 1, 2, 3, 4, 2 ,3, 4, 4, 5 }; 
    String[] strs = { "Jeden", "Dwa", "Trzy", "Dwa" }; 
    int count; 
 
    count = myOp(MyArrayOps::<Integer>countMatching, vals, 4); 
    System.out.println("Tablica vals zawiera " + count + " wartości 4."); 
 
    count = myOp(MyArrayOps::<String>countMatching, strs, "Dwa"); 
    System.out.println("Tablica strs zawiera " + count + " łańcuchy \"Dwa\"."); 
  } 
}
