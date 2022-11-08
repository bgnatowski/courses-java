class Client implements Callback {
  // Implementuje interfejs Callback
  public void callback(int p) {
    System.out.println("wywołanie callback() z wartością " + p);
  }

  void nonIfaceMeth() {
    System.out.println("Klasa implementująca interfejs " +
                       "może zawierać także własne metody.");
  }
}
