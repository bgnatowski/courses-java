// Prosty przykład listy adresów pocztowych
import java.util.*;

class Address {
  private String name;
  private String street;
  private String city;
  private String state;
  private String code;

  Address(String n, String s, String c,
          String st, String cd) {
    name = n;
    street = s;
    city = c;
    state = st;
    code = cd;
  }

  public String toString() {
    return name + "\n" + street + "\n" +
           code + " " + city + ", " +state;
  }
}

class MailList {
  public static void main(String args[]) {
    LinkedList<Address> ml = new LinkedList<Address>();

    // Dodanie elementów do listy
    ml.add(new Address("Jan Kowalski", "Klonowa 11",
                       "Warszawa", "mazowieckie", "00-591"));
    ml.add(new Address("Danuta Sroka", "Fojkisa 43/2",
                       "Ruda Śląska", "śląskie", "41-700"));
    ml.add(new Address("Piotr Nowak", "Zwycięstwa 345",
                       "Kraków", "małopolskie", "31-563"));

    // Wyświetlenie zawartości listy
    for(Address element : ml)
      System.out.println(element + "\n");

    System.out.println();
  }
}
