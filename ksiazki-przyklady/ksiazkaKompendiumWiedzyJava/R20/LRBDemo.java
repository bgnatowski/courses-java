// Przykład stosowania pakietów zasobów
import java.util.*;

class LRBDemo {
  public static void main(String args[]) {
    // Ładuje domyślny pakiet zasobów
    ResourceBundle rd = ResourceBundle.getBundle("SampleRB");

    System.out.println("Polska wersja: ");
    System.out.println("Łańcuch dla klucza Title: " +
                       rd.getString("title"));

    System.out.println("Łańcuch dla klucza StopText: " +
                       rd.getString("StopText"));

    System.out.println("Łańcuch dla klucza StartText: " +
                       rd.getString("StartText"));

    // Ładuje niemieckojęzyczny pakiet zasobów
    rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);

    System.out.println("\nNiemiecka wersja: ");
    System.out.println("Łańcuch dla klucza Title: " +
                       rd.getString("title"));

    System.out.println("Łańcuch dla klucza StopText: " +
                       rd.getString("StopText"));

    System.out.println("Łańcuch dla klucza StartText: " +
                       rd.getString("StartText"));
  }
}
