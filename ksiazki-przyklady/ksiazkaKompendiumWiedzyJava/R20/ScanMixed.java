// Użycie klasy Scanner do odczytywania z pliku tekstowego różnych typów danych
import java.util.*; 
import java.io.*; 
 
class ScanMixed { 
  public static void main(String args[]) 
    throws IOException { 
 
    int i; 
    double d; 
    boolean b; 
    String str; 
 
    // Zapisuje dane wyjściowe w pliku tekstowym
    FileWriter fout = new FileWriter("test.txt"); 
    fout.write("Testowanie klasy Scanner 10 12.2 jeden true dwa false"); 
    fout.close(); 
 
    FileReader fin = new FileReader("Test.txt"); 
 
    Scanner src = new Scanner(fin); 
  
    // Odczytuje wszystkie dane wejściowe
    while(src.hasNext()) { 
      if(src.hasNextInt()) { 
        i = src.nextInt(); 
        System.out.println("int: " + i); 
      } 
      else if(src.hasNextDouble()) { 
        d = src.nextDouble(); 
        System.out.println("double: " + d); 
      } 
      else if(src.hasNextBoolean()) { 
        b = src.nextBoolean(); 
        System.out.println("boolean: " + b); 
      } 
      else { 
        str = src.next(); 
        System.out.println("String: " + str); 
      } 
    } 
 
    src.close(); 
  } 
}
