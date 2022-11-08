// Demonstruje użycie metody findInLine()
import java.util.*; 
 
class FindInLineDemo { 
  public static void main(String args[]) { 
    String instr = "Imię: Tomasz Wiek: 28 ID: 77"; 
 
    Scanner conin = new Scanner(instr); 
 
    // Odnajduje i wyświetla wiek 
    conin.findInLine("Wiek:"); // Znajduje "Wiek:"
    
    if(conin.hasNext()) 
      System.out.println(conin.next()); 
    else 
      System.out.println("Błąd!"); 
 
    conin.close();
  } 
}
