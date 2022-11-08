// Demonstracja formatów czasu
import java.text.*;
import java.util.*;

public class TimeFormatDemo {
   public static void main(String args[]) {
      Date date = new Date();
      DateFormat df;

      df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
      System.out.println("Japonia: " + df.format(date));

      df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
      System.out.println("Wielka Brytania: " + df.format(date));

      df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
      System.out.println("Kanada: " + df.format(date));
   }
}
