package p2;

class Protection2 extends p1.Protection {
  Protection2() {
    System.out.println("konstruktor klasy pochodnej z innego pakietu");

    // Tylko ta sama klasa lub pakiet
    //  System.out.println("n = " + n);

    // Tylko ta sama klasa
    //  System.out.println("n_pri = " + n_pri);

    System.out.println("n_pro = " + n_pro);
    System.out.println("n_pub = " + n_pub);
  }
}
