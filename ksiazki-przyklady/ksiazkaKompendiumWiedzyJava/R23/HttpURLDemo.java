// Przykład użycia klasy HttpURLConnection
import java.net.*;
import java.io.*;
import java.util.*;

class HttpURLDemo
{

  public static void main(String args[]) throws Exception {
    URL hp = new URL("http://www.google.com");

    HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

    // Wyświetla metodę żądania
    System.out.println("Metoda żądania: " +
                       hpCon.getRequestMethod());

    // Wyświetla kod odpowiedzi
    System.out.println("Kod odpowiedzi: " +
                       hpCon.getResponseCode());

    // Wyświetla komunikat odpowiedzi
    System.out.println("Komunikat odpowiedzi: " +
                       hpCon.getResponseMessage());

    // Uzyskuje listę pól nagłówka i zbiór
    // kluczy nagłówka
    Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
    Set<String> hdrField = hdrMap.keySet();

    System.out.println("\nOto nagłówek:");

    // Wyświetla wszystkie klucze i wartości nagłówka
    for(String k : hdrField) {
      System.out.println("Klucz: " + k +
                         " Wartość: " + hdrMap.get(k));
    }
  }
}
