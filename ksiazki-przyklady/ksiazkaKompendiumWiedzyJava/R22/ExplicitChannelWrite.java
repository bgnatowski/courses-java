// Zapisywanie danych w pliku za pomocą elementów systemu NIO

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelWrite {
  public static void main(String args[]) {
    
    // Uzyskujemy kanał do pliku (wewnątrz bloku instrukcji try-with-resources)
    try ( FileChannel fChan = (FileChannel)
            Files.newByteChannel(Path.of("test.txt"),
                                 StandardOpenOption.WRITE,
                                 StandardOpenOption.CREATE) )
    {
      // Tworzy bufor.
      ByteBuffer mBuf = ByteBuffer.allocate(26);

      // Zapisuje bajty w buforze.
      for(int i=0; i<26; i++)
        mBuf.put((byte)('A' + i));

      // Zeruje pozycję w buforze, aby można było zapisać jego zawartość
      mBuf.rewind();

      // Zapisuje zawartość bufora w pliku wyjściowym
      fChan.write(mBuf);

    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e); 
      System.exit(1);
    }
  }
}
