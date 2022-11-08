// Demonstruje użycie klasy FileInputStream
import java.io.*;

class FileInputStreamDemo {
  public static void main(String args[]) {
    int size;

    // Instrukcja try-with-resources automatycznie zamyka strumień
    try ( FileInputStream f =
           new FileInputStream("FileInputStreamDemo.java") ) {

      System.out.println("Łączna liczba dostępnych bajtów: " +
                         (size = f.available()));

      int n = size/40;
      System.out.println("Metoda read() odczytała w jednym kroku" +
                         " pierwsze " + n + " bajtów pliku ");
      for (int i=0; i < n; i++) {
        System.out.print((char) f.read());
      }

      System.out.println("\nWciąż jest dostępnych: " +
                         f.available() + " bajtów");

      System.out.println("Odczytywanie następnych " + n +
                         " bajtów za pomocą metody read(b[])");
      byte b[] = new byte[n];
      if (f.read(b) != n) {
        System.err.println("Nie można odczytać " + n + " bajtów.");
      }

      System.out.println(new String(b, 0, n));
      System.out.println("\nLiczba wciąż dostępnych bajtów: " +
                         (size = f.available()));
      System.out.println("Pomijanie połowy pozostałych bajtów" +
                         " za pomocą metody skip()");
      f.skip(size/2);
      System.out.println("Liczba wciąż dostępnych bajtów: " +
                         f.available());

      System.out.println("Wczytywanie " + n/2 + " bajtów na koniec tablicy");
      if (f.read(b, n/2, n/2) != n/2) {
        System.err.println("Nie można odczytać " + n/2 + " bajtów.");
      }

      System.out.println(new String(b, 0, b.length));
      System.out.println("\n Liczba wciąż dostępnych bajtów: " +
                         f.available());
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
