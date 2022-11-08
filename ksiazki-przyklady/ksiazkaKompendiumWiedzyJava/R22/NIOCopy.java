// Kopiowanie pliku za pomocą systemu NIO
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NIOCopy {

  public static void main(String args[]) {

    if(args.length != 2) {
      System.out.println("Sposób użycia: Copy źródło cel");
      return;
    }

    try {
      Path source = Paths.get(args[0]);
      Path target = Paths.get(args[1]);

      // Kopiuje plik
      Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
