// Prosty przykład użycia metody walkFileTree() do wyświetlania drzewa katalogów

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

// Tworzy własną wersję klasy SimpleFileVisitor przesłaniającą
// metodę visitFile()
class MyFileVisitor extends SimpleFileVisitor<Path> {
  public FileVisitResult visitFile(Path path, BasicFileAttributes attribs)
      throws IOException
  {
    System.out.println(path);
    return FileVisitResult.CONTINUE;
  }
}

class DirTreeList {
  public static void main(String args[]) {
    String dirname = "MyDir";

    System.out.println("Drzewo katalogów rozpoczynające się od " + dirname + ":\n");

    try {
      Files.walkFileTree(Path.of(dirname), new MyFileVisitor());
    } catch (IOException exc) {
      System.out.println("Błąd wejścia-wyjścia");
    }
  }
}
