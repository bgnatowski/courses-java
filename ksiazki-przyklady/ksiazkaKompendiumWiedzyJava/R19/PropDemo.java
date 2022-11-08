// Przykład użycia listy właściwości
import java.util.*;

class PropDemo {
  public static void main(String args[]) {
    Properties capitals = new Properties();

    capitals.setProperty("śląskiego", "Katowice");
    capitals.setProperty("małopolskiego", "Kraków");
    capitals.setProperty("mazowieckiego", "Warszawa");
    capitals.setProperty("opolskiego", "Opole");
    capitals.setProperty("wielkopolskiego", "Poznań");

    // Pobranie widoku kluczy
    Set<?> states = capitals.keySet();

    // Wyświetlenie województw i miast
    for(Object name : states)
      System.out.println("Miasto wojewódzkie województwa " +
                         name + " to " +
                         capitals.getProperty((String)name)
                         + ".");

    System.out.println();

    // Poszukiwanie województwa spoza listy – skorzystanie z wartości domyślnej
    String str = capitals.getProperty("świętokrzyskie", "nie znaleziono");
    System.out.println("Miasto wojewódzkie województwa świętokrzyskiego to "
                       + str + ".");
  }
}
