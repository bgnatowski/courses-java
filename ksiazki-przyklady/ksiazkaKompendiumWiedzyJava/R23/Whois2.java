// Przykład użycia gniazd
import java.net.*;
import java.io.*;


class Whois2 {

  // Przykład zamknięcia gniazda za pomocą instrukcji try-with-resources
  public static void main(String args[]) throws Exception {
    int c;

    // Tworzy gniazdo połączone z serwerem internic.net (port 43); zarządza tym
    // gniazdem w ramach bloku try-with-resources
    try ( Socket s = new Socket("whois.internic.net", 43) ) {

      // Uzyskuje obiekty strumieni wejściowego i wyjściowego
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();

      // Konstruuje łańcuch żądania
      String str = (args.length == 0 ? "OraclePressBooks.com" : args[0]) + "\n";

      // Konwertuje ten łańcuch na tablicę bajtów
      byte buf[] = str.getBytes();

      // Wysyła żądanie
      out.write(buf);

      // Odczytuje i wyświetla odpowiedź
      while ((c = in.read()) != -1) {
        System.out.print((char) c);
      }
    }
    // Teraz gniazdo zostanie automatycznie zamknięte
  }


}
