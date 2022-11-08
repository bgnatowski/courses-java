// Demonstruje użycie klasy FileOutputStream
// Program używa instrukcji try-with-resources
import java.io.*;

class FileOutputStreamDemo2 {
  public static void main(String args[]) {
    String source = "Nadszedł czas, aby wszyscy porządni obywatele\n"
      + " wreszcie zrozumieli potrzeby swojego kraju\n"
      + " i zaczęli uczciwie płacić podatki.";
    byte buf[] = source.getBytes();

    // Używa instrukcji try-with-resources do zarządzania strumieniem plikowym
    try (FileOutputStream f0 = new FileOutputStream("file1.txt");
         FileOutputStream f1 = new FileOutputStream("file2.txt");
         FileOutputStream f2 = new FileOutputStream("file3.txt") )
    {
      // Zapisuje w pierwszym pliku
      for (int i=0; i < buf.length; i += 2) f0.write(buf[i]);

      // Zapisuje w drugim pliku
      f1.write(buf);

      // Zapisuje w trzecim pliku
      f2.write(buf, buf.length-buf.length/4, buf.length/4);
    } catch(IOException e) {
      System.out.println("Wystąpił błąd wejścia-wyjścia");
    }
  }
}
