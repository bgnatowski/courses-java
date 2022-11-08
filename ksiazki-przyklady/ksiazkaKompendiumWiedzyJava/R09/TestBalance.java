import mypack.Balance;

class TestBalance {
  public static void main(String args[]) {

    /* Ponieważ klasa Balance jest klasą publiczną, można
       jej użyć i wywołać jej konstruktor */
    Balance test = new Balance("J.J. Jaspers", 99.88);

    test.show(); // Wywołanie metody show() także nie sprawi problemów
  }
}
