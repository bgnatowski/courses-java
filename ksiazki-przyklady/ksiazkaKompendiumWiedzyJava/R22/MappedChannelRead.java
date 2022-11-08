// Przykład odczytu odwzorowanej zawartości pliku

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class MappedChannelRead {
  public static void main(String args[]) {

    // Uzyskujemy kanał do pliku (wewnątrz bloku instrukcji try-with-resources)
    try ( FileChannel fChan =
         (FileChannel) Files.newByteChannel(Paths.of("test.txt")) )
    {

      // Uzyskuje rozmiar pliku
      long fSize = fChan.size();

      // Odwzorowuje plik na bufor
      MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

      // Odczytuje i wyświetla kolejne bajty z bufora
      for(int i=0; i < fSize; i++)
        System.out.print((char)mBuf.get());
      
      System.out.println();
      
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
