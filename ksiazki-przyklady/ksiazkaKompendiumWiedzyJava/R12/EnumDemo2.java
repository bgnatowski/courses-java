// Wykorzystanie wbudowanych metod typów wyliczeniowych
 
// Wyliczenie odmian jabłek
enum Apple {  
  Jonathan, GoldenDel, RedDel, Winesap, Cortland 
} 
 
class EnumDemo2 { 
  public static void main(String args[])  
  { 
    Apple ap; 
 
    System.out.println("Oto wszystkie stałe wyliczenia Apple:"); 
 
    // Użycie values() 
    Apple allapples[] = Apple.values(); 
    for(Apple a : allapples) 
      System.out.println(a); 
 
    System.out.println(); 
    
    // Użycie valueOf() 
    ap = Apple.valueOf("Winesap"); 
    System.out.println("ap zawiera " + ap); 
 
  } 
}
