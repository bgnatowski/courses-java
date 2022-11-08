// Demonstruje użycie klasy FileOutputStream
// Program stosuje tradycyjny model zamykania plików
import java.io.*;

class FileOutputStreamDemo {
  public static void main(String args[]) throws IOException {
    String source = "Nadszedł czas, aby wszyscy porządni obywatele\n"
      + " wreszcie zrozumieli potrzeby swojego kraju\n"
      + " i zaczęli uczciwie płacić podatki.";

    byte buf[] = source.getBytes();
    FileOutputStream f0 = null;
    FileOutputStream f1 = null;
    FileOutputStream f2 = null;

    try {
      f0 = new FileOutputStream("file1.txt");
      f1 = new FileOutputStream("file2.txt");
      f2 = new FileOutputStream("file3.txt");

      // Zapisuje w pierwszym pliku
      for (int i=0; i < buf.length; i += 2) f0.write(buf[i]);

      // Zapisuje w drugim pliku
      f1.write(buf);

      // Zapisuje w trzecim pliku
      f2.write(buf, buf.length-buf.length/4, buf.length/4);
    } catch(IOException e) {
      System.out.println("Wystąpił błąd wejścia-wyjścia");
    } finally {
      try {
        if(f0 != null) f0.close();
      } catch(IOException e) {
        System.out.println("Błąd podczas zamykania pliku file1.txt");
      }
      try {
        if(f1 != null) f1.close();
      } catch(IOException e) {
        System.out.println("Błąd podczas zamykania pliku file2.txt");
      }
      try {
        if(f2 != null) f2.close();
      } catch(IOException e) {
        System.out.println("Błąd podczas zamykania pliku file3.txt");
      }
    }
  }
}
