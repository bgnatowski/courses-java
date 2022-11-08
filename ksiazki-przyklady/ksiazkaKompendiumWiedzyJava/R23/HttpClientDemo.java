//R23/HttpClientDemo.java
// Przedstawia użycie klasy HttpClient.
import java.net.*;
import java.net.http.*;
import java.io.*;
import java.util.*;

class HttpClientDemo
{
  public static void main(String args[]) throws Exception {

    // Pobiera klienta z domyślnymi ustawieniami.
    HttpClient myHC = HttpClient.newHttpClient();

    // Tworzy żądanie.
    HttpRequest myReq = HttpRequest.newBuilder(
    new URI("http://www.google.com/")).build();

    // Wysyła żądanie i pobiera odpowiedź. Zawartość odpowiedzi jest 
    // pobierana jako strumień InputStream.
    HttpResponse<InputStream> myResp = myHC.send(myReq,
        HttpResponse.BodyHandlers.ofInputStream());
    
    // Wyświetla status odpowiedzi i metodę żądania.
    System.out.println("Status odpowiedzi: " + myResp.statusCode());
    System.out.println("Metoda żądania: " + myReq.method());
    
    // Pobiera nagłówki odpowiedzi.
    HttpHeaders hdrs = myResp.headers();
    
    // Pobiera nagłówki w formie mapy.
    Map<String, List<String>> hdrMap = hdrs.map();
    Set<String> hdrField = hdrMap.keySet();
    System.out.println("\nNagłówek: ");
    
    // Wyświetla wszystkie klucze i wartości nagłówków.
    for(String k : hdrField) {
    System.out.println("Klucz: " + k +
      " Wartość: " + hdrMap.get(k));
    }
    
    // Wyświetla zawartość odpowiedzi.
    System.out.println("\nZawartość odpowiedzi: ");
    InputStream input = myResp.body();
    int c;
    
    // Odczytuje i wyświetla całą zawartość odpowiedzi.
    while((c = input.read()) != -1) {
      System.out.print((char) c);
    }
  }
}
