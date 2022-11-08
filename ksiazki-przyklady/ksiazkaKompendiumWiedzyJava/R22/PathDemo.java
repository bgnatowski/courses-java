// Uzyskiwanie informacji o ścieżce i pliku

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class PathDemo {
  public static void main(String args[]) {
    Path filepath = Path.of(".\\test.txt");

    System.out.println("Nazwa pliku: " + filepath.getName(1));
    System.out.println("Ścieżka: " + filepath);
    System.out.println("Ścieżka bezwzględna: " + filepath.toAbsolutePath());
    System.out.println("Katalog macierzysty: " + filepath.getParent());

    if(Files.exists(filepath))
      System.out.println("Plik istnieje");
    else
      System.out.println("Plik nie istnieje");

    try {
      if(Files.isHidden(filepath))
        System.out.println("Plik jest ukryty");
      else
        System.out.println("Plik nie jest ukryty");
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e); 
    }

    Files.isWritable(filepath);
    System.out.println("Plik jest dostępny do zapisu");

    Files.isReadable(filepath);
    System.out.println("Plik jest dostępny do odczytu");

    try {
      BasicFileAttributes attribs =
        Files.readAttributes(filepath, BasicFileAttributes.class);

      if(attribs.isDirectory())
        System.out.println("Plik jest katalogiem");
      else
        System.out.println("Plik nie jest katalogiem");

      if(attribs.isRegularFile())
        System.out.println("Plik jest zwykłym plikiem");
      else
        System.out.println("Plik nie jest zwykłym plikiem");

      if(attribs.isSymbolicLink())
        System.out.println("Plik jest dowiązaniem symbolicznym");
      else
        System.out.println("Plik nie jest dowiązaniem symbolicznym");

      System.out.println("Ostatnia modyfikacja pliku: " + attribs.lastModifiedTime());
      System.out.println("Rozmiar pliku: " + attribs.size() + " bajtów");
    } catch(IOException e) {
      System.out.println("Błąd odczytu atrybutów: " + e);
    }
  }
}
