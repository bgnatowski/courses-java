// Demonstruje użycie klasy Calendar
import java.util.Calendar;

class CalendarDemo {
  public static void main(String args[]) {
    String months[] = {
             "Sty", "Lut", "Mar", "Kwi", 
             "Maj", "Cze", "Lip", "Sie",
             "Wrz", "Paź", "Lis", "Gru"};

    // Tworzy obiekt klasy Calendar zainicjalizowany
    // bieżącą datą i godziną z domyślnymi ustawieniami
    // regionalnymi i domyślną strefą czasową
    Calendar calendar = Calendar.getInstance();

    // Wyświetla informacje o bieżącej dacie i godzinie
    System.out.print("Data: ");
    System.out.print(calendar.get(Calendar.DATE));
    System.out.print(" " + months[calendar.get(Calendar.MONTH)] + " ");
    System.out.println(calendar.get(Calendar.YEAR));

    System.out.print("Godzina: ");
    System.out.print(calendar.get(Calendar.HOUR) + ":");
    System.out.print(calendar.get(Calendar.MINUTE) + ":");
    System.out.println(calendar.get(Calendar.SECOND));

    // Ustawia i wyświetla informacje o dacie i godzinie
    calendar.set(Calendar.HOUR, 10);
    calendar.set(Calendar.MINUTE, 29);
    calendar.set(Calendar.SECOND, 22);

    System.out.print("Zaktualizowana godzina: ");
    System.out.print(calendar.get(Calendar.HOUR) + ":");
    System.out.print(calendar.get(Calendar.MINUTE) + ":");
    System.out.println(calendar.get(Calendar.SECOND));
  }
}
