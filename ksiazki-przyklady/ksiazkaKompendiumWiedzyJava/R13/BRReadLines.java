// Odczyt łańcucha z konsoli za pomocą klasy BufferedReader
import java.io.*;

class BRReadLines {
  public static void main(String args[]) 
    throws IOException
  {
    // Utworzenie BufferedReader na podstawie System.in
    BufferedReader br = new BufferedReader(new 
                            InputStreamReader(System.in));
    String str;
    System.out.println("Wpisz wiersze tekstu.");
    System.out.println("Wpisz 'stop', aby wyjść.");
    do {
      str = br.readLine();
      System.out.println(str);
    } while(!str.equals("stop"));
  }
}
