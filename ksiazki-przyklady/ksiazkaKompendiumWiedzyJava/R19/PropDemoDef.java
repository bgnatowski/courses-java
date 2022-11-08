// Wykorzystanie domyślnej listy właściwości
import java.util.*;

class PropDemoDef {
  public static void main(String args[]) {
    Properties defList = new Properties();
    defList.setProperty("świętokrzyskie", "Kielce");
    defList.setProperty("podlaskie", "Białystok");

    Properties capitals = new Properties(defList);

    capitals.setProperty("śląskiego", "Katowice");
    capitals.setProperty("małopolskiego", "Kraków");
    capitals.setProperty("mazowieckiego", "Warszawa");
    capitals.setProperty("opolskiego", "Opole");
    capitals.setProperty("wielkopolskiego", "Poznań");

    // Pobranie widoku kluczy
    Set<?> states = capitals.keySet();

    // Wyświetlenie województw i miast.
    for(Object name : states)
      System.out.println("Miasto wojewódzkie województwa " +
                         name + " to " +
                         capitals.getProperty((String)name)
                         + ".");

    System.out.println();

    // Teraz województwo świętokrzyskie zostanie znalezione na domyślnej liście
    String str = capitals.getProperty("świętokrzyskie");
    System.out.println("Miasto wojewódzkie województwa świętokrzyskiego to "
                       + str + ".");
  }
}
