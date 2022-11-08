// Wyliczenie odmian jabłek
enum Apple {  
  Jonathan, GoldenDel, RedDel, Winesap, Cortland 
} 
 
class EnumDemo { 
  public static void main(String args[])  
  { 
    Apple ap; 
 
    ap = Apple.RedDel; 
 
    // Wyświetlenie wartości wyliczenia
    System.out.println("Wartość ap: " + ap); 
    System.out.println(); 
 
    ap = Apple.GoldenDel; 
 
    // Porównanie wartości dwóch wyliczeń
    if(ap == Apple.GoldenDel)  
      System.out.println("ap zawiera GoldenDel.\n"); 
 
    // Wykorzystanie wyliczenia do sterowania instrukcją switch
    switch(ap) { 
      case Jonathan: 
        System.out.println("Jonathan jest czerwone."); 
        break; 
      case GoldenDel: 
        System.out.println("Golden Delicious jest żółte."); 
        break; 
      case RedDel:  
        System.out.println("Red Delicious jest czerwone."); 
        break; 
      case Winesap: 
        System.out.println("Winesap jest czerwone."); 
        break; 
      case Cortland: 
        System.out.println("Cortland jest czerwone."); 
        break; 
    } 
  } 
}
