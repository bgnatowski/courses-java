// Zapis w odwzorowanym pliku

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class MappedChannelWrite {
  public static void main(String args[]) {

    // Uzyskujemy kanał do pliku (wewnątrz bloku instrukcji try-with-resources)
    try ( FileChannel fChan = (FileChannel)
          Files.newByteChannel(Path.of("test.txt"),
                               StandardOpenOption.WRITE,
                               StandardOpenOption.READ,
                               StandardOpenOption.CREATE) )
    {
      // Odwzorowuje następnie plik na bufor
      MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

      // Zapisuje bajty w buforze
      for(int i=0; i<26; i++)
        mBuf.put((byte)('A' + i));

    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
