// Wyświetla zawartość katalogu

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class DirList {
  public static void main(String args[]) {
    String dirname = "MyDir";

    // Uzyskuje strumień katalogu i zarządza otrzymanym obiektem (w bloku try)
    try ( DirectoryStream<Path> dirstrm =
            Files.newDirectoryStream(Path.of(dirname)) )
    {
      System.out.println("Katalog " + dirname);

      // Ponieważ DirectoryStream implementuje interfejs Iterable,
      // do wyświetlania zawartości katalogu możemy użyć pętli for-each
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
