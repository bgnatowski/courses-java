// Przykład użycia kanału wejścia-wyjścia do odczytania pliku 

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelRead {
  public static void main(String args[]) {
    int count;
    Path filepath = null;

    // Uzyskujemy najpierw ścieżkę do pliku
    try {
      filepath = Path.of("test.txt");
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
      return;
    }

    // Uzyskujemy następnie kanał do tego pliku (wewnątrz bloku instrukcji try-with-resources)
    try ( SeekableByteChannel fChan = Files.newByteChannel(filepath) )
    {
      
      // Alokacja bufora
      ByteBuffer mBuf = ByteBuffer.allocate(128);
      do {
        // Odczytuje dane i umieszcza w buforze
        count = fChan.read(mBuf);

        // Przerywa w momencie osiągnięcia końca pliku
        if(count != -1) {
          // Cofa pozycję w buforze, aby można było odczytać jego zawartość
          mBuf.rewind();
          
          // Odczytuje i wyświetla dane z bufora
          // Na ekranie jest wyświetlana znakowa reprezentacja kolejnych bajtów
          for(int i=0; i < count; i++)
            System.out.print((char)mBuf.get());
        }
      } while(count != -1);
      
      System.out.println();
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}

