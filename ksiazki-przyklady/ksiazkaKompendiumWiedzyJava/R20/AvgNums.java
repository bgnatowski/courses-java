// Użycie klasy Scanner do wyznaczenia średniej arytmetycznej dla listy wartości
import java.util.*; 
 
class AvgNums { 
  public static void main(String args[]) { 
    Scanner conin = new Scanner(System.in); 
 
    int count = 0; 
    double sum = 0.0; 
 
    System.out.println("Podaj liczby do wyliczenia średniej"); 
 
    // Odczytuje i sumuje liczby
    while(conin.hasNext()) { 
      if(conin.hasNextDouble()) { 
        sum += conin.nextDouble(); 
        count++; 
      } 
      else { 
        String str = conin.next();  
        if(str.equals("gotowe")) break; 
        else { 
          System.out.println("Błąd formatu danych"); 
          return; 
        } 
      } 
    } 
 
    conin.close();
    System.out.println("Średnia wynosi " + sum / count); 
  } 
}
