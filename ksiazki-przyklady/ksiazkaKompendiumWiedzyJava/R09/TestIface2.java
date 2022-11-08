class TestIface2 {
  public static void main(String args[]) {
    Callback c = new Client();
    AnotherClient ob = new AnotherClient();

    c.callback(42);

    c = ob; // Teraz c odnosi się do obiektu AnotherClient
    c.callback(42);
  }
}
