// Demonstruje użycie klasy ByteArrayOutputStream

import java.io.*;

class ByteArrayOutputStreamDemo {
  public static void main(String args[]) {
    ByteArrayOutputStream f = new ByteArrayOutputStream();
    String s = "Ten łańcuch powinien się znaleźć w odpowiedniej tablicy";
    byte buf[] = s.getBytes();

    try {
      f.write(buf);
    } catch(IOException e) {
      System.out.println("Błąd zapisu w buforze");
      return;
    }

    System.out.println("Bufor z następującej postaci łańcuchowej:");
    System.out.println(f.toString());
    System.out.println("jest przekształcany w odpowiednią tablicę:");
    byte b[] = f.toByteArray();

    for (int i=0; i<b.length; i++) System.out.print((char) b[i]);

    System.out.println("\nI trafia do konstruktora OutputStream()");

    // Używa instrukcji try-with-resources do zarządzania strumieniem plikowym
    try ( FileOutputStream f2 = new FileOutputStream("test.txt") )
    {
      f.writeTo(f2);
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
      return;
    }

    System.out.println("Resetowanie strumienia");
    f.reset();

    for (int i=0; i<3; i++) f.write('X');

    System.out.println(f.toString());
  }
}
