// Inna implementacja interfejsu Callback
class AnotherClient implements Callback {
  // Implementuje interfejs Callback
  public void callback(int p) {
    System.out.println("Inna wersja metody callback()");
    System.out.println("p podniesione do kwadratu to " + (p*p));
  }
}
