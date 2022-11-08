// Demonstruje użycie klasy GregorianCalendar
import java.util.*;

class GregorianCalendarDemo {
  public static void main(String args[]) {
    String months[] = {
             "Sty", "Lut", "Mar", "Kwi", 
             "Maj", "Cze", "Lip", "Sie",
             "Wrz", "Paź", "Lis", "Gru"};
    int year;

    // Tworzy obiekt klasy GregorianCalendar zainicjalizowany
    // bieżącą datą i godziną z domyślnymi ustawieniami
    // regionalnymi i domyślną strefą czasową
    GregorianCalendar gcalendar = new GregorianCalendar();

    // Wyświetla informacje o bieżącej dacie i godzinie
    System.out.print("Data: ");
    System.out.print(gcalendar.get(Calendar.DATE));
    System.out.print(" " + months[gcalendar.get(Calendar.MONTH)] + " ");
    System.out.println(year = gcalendar.get(Calendar.YEAR));

    System.out.print("Godzina: ");
    System.out.print(gcalendar.get(Calendar.HOUR) + ":");
    System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
    System.out.println(gcalendar.get(Calendar.SECOND));

    // Sprawdza, czy bieżący rok jest rokiem przestępnym
    if(gcalendar.isLeapYear(year)) {
      System.out.println("Bieżący rok jest rokiem przestępnym");
    }
    else {
      System.out.println("Bieżący rok nie jest rokiem przestępnym");
    }
  }
}
