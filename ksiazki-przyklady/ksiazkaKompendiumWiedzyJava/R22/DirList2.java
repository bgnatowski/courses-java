// Wyświetla zawartość katalogu złożoną tylko z plików dostępnych do zapisu

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class DirList2 {
  public static void main(String args[]) {
    String dirname = "MyDir";

    // Tworzy filtr zwracający wartość true tylko dla plików dostępnych do zapisu
    DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
      public boolean accept(Path filename) throws IOException {
        if(Files.isWritable(filename)) return true;
          return false;
      }
    };

    // Uzyskuje strumień katalogu z plikami dostępnymi do zapisu i zarządza otrzymanym obiektem (w bloku try)
    try (DirectoryStream<Path> dirstrm =
            Files.newDirectoryStream(Path.of(dirname), how) )
    {
      System.out.println("Katalog " + dirname);

      for(Path entry : dirstrm) {
        BasicFileAttributes attribs =
          Files.readAttributes(entry, BasicFileAttributes.class);

        if(attribs.isDirectory())
          System.out.print("<DIR> ");
        else
          System.out.print(" ");

        System.out.println(entry.getName(1));
      }
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch(NotDirectoryException e) {
      System.out.println(dirname + " nie jest katalogiem.");
    } catch (IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e); 
    }
  }
}
