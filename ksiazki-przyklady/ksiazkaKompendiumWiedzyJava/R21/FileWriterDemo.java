// Demonstruje użycie klasy FileWriter

import java.io.*;

class FileWriterDemo {
  public static void main(String args[]) throws IOException {
    String source = "Nadszedł czas, aby wszyscy porządni obywatele\n"
      + " wreszcie zrozumieli potrzeby swojego kraju\n"
      + " i zaczęli uczciwie płacić podatki.";
    char buffer[] = new char[source.length()];
    source.getChars(0, source.length(), buffer, 0);

    try ( FileWriter f0 = new FileWriter("file1.txt");
          FileWriter f1 = new FileWriter("file2.txt");
          FileWriter f2 = new FileWriter("file3.txt") )
    {
      // Zapisuje w pierwszym pliku
      for (int i=0; i < buffer.length; i += 2) {
        f0.write(buffer[i]);
      }

      // Zapisuje w drugim pliku
      f1.write(buffer);

      // Zapisuje w trzecim pliku
      f2.write(buffer,buffer.length-buffer.length/4,buffer.length/4);
      
    } catch(IOException e) {
      System.out.println("Wystąpił błąd wejścia-wyjścia");
    }
  }
}
