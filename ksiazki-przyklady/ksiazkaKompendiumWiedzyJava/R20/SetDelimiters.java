// Użycie klasy Scanner do wyznaczenia średniej arytmetycznej dla listy 
// wartości oddzielonych przecinkami
import java.util.*; 
import java.io.*; 
 
class SetDelimiters { 
  public static void main(String args[]) 
    throws IOException { 
 
    int count = 0; 
    double sum = 0.0; 
 
    // Zapisuje dane wyjściowe w pliku tekstowym
    FileWriter fout = new FileWriter("test.txt"); 
 
    // Wartości są teraz umieszczane na liście elementów oddzielonych przecinkami
    fout.write("2, 3.4,    5,6, 7.4, 9.1, 10.5, gotowe"); 
    fout.close(); 
 
    FileReader fin = new FileReader("Test.txt"); 
 
    Scanner src = new Scanner(fin); 
 
    // Ustawia zbiór separatorów złożony z przecinka i spacji
    src.useDelimiter(", *"); 
 
    // Odczytuje i sumuje liczby
    while(src.hasNext()) { 
      if(src.hasNextDouble()) { 
        sum += src.nextDouble(); 
        count++; 
      } 
      else { 
        String str = src.next();  
        if(str.equals("gotowe")) break; 
        else { 
          System.out.println("Błąd formatu pliku"); 
          return; 
        } 
      } 
    } 
 
    src.close(); 
    System.out.println("Średnia wynosi " + sum / count); 
  } 
}
