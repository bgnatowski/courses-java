// Demonstruje użycie klasy URLConnection
import java.net.*;
import java.io.*;
import java.util.Date;

class UCDemo 
{
  public static void main(String args[]) throws Exception {
    int c;
    URL hp = new URL("http://www.internic.net");
    URLConnection hpCon = hp.openConnection();

    // Pobiera datę
    long d = hpCon.getDate(); 
    if(d==0)
      System.out.println("Brak informacji o dacie.");
    else
      System.out.println("Data: " + new Date(d));

    // Pobiera rodzaj zawartości
    System.out.println("Rodzaj zawartości: " + hpCon.getContentType());

    // Pobiera datę ważności
    d = hpCon.getExpiration(); 
    if(d==0)
      System.out.println("Brak informacji o dacie ważności.");
    else
      System.out.println("Wygasa: " + new Date(d));

    // Pobiera datę ostatniej modyfikacji
    d = hpCon.getLastModified(); 
    if(d==0)
      System.out.println("Brak informacji o dacie ostatniej modyfikacji.");
    else
      System.out.println("Ostatnio zmodyfikowany: " + new Date(d));

    // Pobiera długość zawartości
    long len = hpCon.getContentLengthLong();
    if(len == -1)
      System.out.println("Długość zawartości niedostępna.");
    else
      System.out.println("Długość zawartości: " + len);

    if(len != 0) {
      System.out.println("=== Zawartość ===");
      InputStream input = hpCon.getInputStream();

      while (((c = input.read()) != -1)) { 
        System.out.print((char) c);
      }
      input.close();

    } else {
      System.out.println("Brak dostępnej zawartości.");
    }

  }
}
