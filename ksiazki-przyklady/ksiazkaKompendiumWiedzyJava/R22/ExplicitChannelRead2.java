// Skrócona wersja kodu otwierającego kanał 

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelRead2 {
  public static void main(String args[]) {
    int count;

    // Tym razem kanał jest otwierany dla obiektu typu Path zwróconego przez metodę Path.of()
    // Zmienna filepath nie jest już potrzebna
    try ( SeekableByteChannel fChan =
            Files.newByteChannel(Path.of("test.txt")) )
    {
      // Alokacja bufora
      ByteBuffer mBuf = ByteBuffer.allocate(128);
      
      do {
        // Odczyt z bufora
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
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
