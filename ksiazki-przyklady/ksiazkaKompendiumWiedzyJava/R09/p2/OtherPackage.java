package p2;

class OtherPackage {
  OtherPackage() {
    p1.Protection p = new p1.Protection();
    System.out.println("konstruktor z innego pakietu");

    //  Tylko ta sama klasa lub pakiet
    //  System.out.println("n = " + p.n);

    //  Tylko ta sama klasa
    //  System.out.println("n_pri = " + p.n_pri);

    //  Tylko ta sama klasa, pakiet lub klasa pochodna
    //  System.out.println("n_pro = " + p.n_pro);

    System.out.println("n_pub = " + p.n_pub);
  }
}
