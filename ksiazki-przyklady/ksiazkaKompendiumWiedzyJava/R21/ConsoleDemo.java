// Przykład demonstrujący działanie klasy Console
import java.io.*;

class ConsoleDemo {
  public static void main(String args[]) {
    String str;
    Console con;

    // Uzyskuje referencję do konsoli
    con = System.console();
    // Jeśli konsola nie jest dostępna, program kończy działanie
    if(con == null) return;

    // Odczytuje i wyświetla łańcuch
    str = con.readLine("Wpisz jakiś tekst: ");
    con.printf("Oto wpisany tekst: %s\n", str);
  }
}
