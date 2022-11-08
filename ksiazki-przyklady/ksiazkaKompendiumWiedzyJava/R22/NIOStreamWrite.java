// Przykład użycia strumienia wyjściowego z wykorzystaniem elementów systemu NIO 

import java.io.*;
import java.nio.file.*;

class NIOStreamWrite {
  public static void main(String args[])
  {
    // Otwiera plik i uzyskuje powiązany z nim strumień
    try ( OutputStream fout =
          new BufferedOutputStream(
                Files.newOutputStream(Path.of("test.txt"))) )
    {
      // Zapisuje bajty w strumieniu
      for(int i=0; i < 26; i++)
        fout.write((byte)('A' + i));
      
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e); 
    }
  }
}
