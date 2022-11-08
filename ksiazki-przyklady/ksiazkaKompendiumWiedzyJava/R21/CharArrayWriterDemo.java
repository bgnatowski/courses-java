// Demonstruje użycie klasy CharArrayWriter

import java.io.*;

class CharArrayWriterDemo {
  public static void main(String args[]) throws IOException {
    CharArrayWriter f = new CharArrayWriter();
    String s = " Ten łańcuch powinien się znaleźć w odpowiedniej tablicy";
    char buf[] = new char[s.length()];

    s.getChars(0, s.length(), buf, 0);

    try {
      f.write(buf);
    } catch(IOException e) {
      System.out.println("Błąd zapisu w buforze ");
      return;
    }

    System.out.println("Bufor z następującej postaci łańcuchowej");
    System.out.println(f.toString());
    System.out.println("jest przekształcany w odpowiednią tablicę");

    char c[] = f.toCharArray();
    for (int i=0; i<c.length; i++) {
      System.out.print(c[i]);
    }

    System.out.println("\nI trafia do konstruktora FileWriter()");

    // Instrukcja try-with-resources zarządzająca strumieniem plikowym
    try ( FileWriter f2 = new FileWriter("test.txt") )
    {
      f.writeTo(f2);
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }

    System.out.println("Resetowanie strumienia");
    f.reset();

    for (int i=0; i<3; i++) f.write('X');

    System.out.println(f.toString());
  }
}
