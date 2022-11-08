// Program używa referencji do metody w celu odnalezienia największej
// wartości w kolekcji
import java.util.*; 
 
class MyClass { 
  private int val; 
 
  MyClass(int v) { val = v; } 
 
  int getVal() { return val; } 
} 
 
class UseMethodRef { 
  // Metoda compare() zgodna z metodą definiowaną przez 
  // interfejs Comparator<T>
  static int compareMC(MyClass a, MyClass b) { 
    return a.getVal() - b.getVal(); 
  } 
 
  public static void main(String args[]) 
  { 
    ArrayList<MyClass> al = new ArrayList<MyClass>(); 
 
    al.add(new MyClass(1)); 
    al.add(new MyClass(4)); 
    al.add(new MyClass(2)); 
    al.add(new MyClass(9)); 
    al.add(new MyClass(3)); 
    al.add(new MyClass(7)); 
 
    // Odnajduje największą wartość kolekcji al, używając 
    // przy tym metody compareMC()
    MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC); 
 
    System.out.println("Wartością maksymalną jest: " + maxValObj.getVal()); 
  } 
}
