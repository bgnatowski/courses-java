// Tradycyjna klasa może być klasą bazową dla
// sparametryzowanej podklasy

// Tradycyjna klasa
class NonGen {
  int num;

  NonGen(int i) {
    num = i;
  }

  int getnum() {
    return num;
  }
}

// Podklasa sparametryzowana
class Gen<T> extends NonGen {
  T ob; // Deklaracja obiektu typu T

  // Przekazanie do konstruktora referencji do
  // obiektu typu T
  Gen(T o, int i) {
    super(i);
    ob = o;
  }

  // Zwrócenie ob
  T getob() {
    return ob;
  }
}

// Utworzenie obiektu Gen
class HierDemo2 {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen dla String
    Gen<String> w = new Gen<String>("Witaj", 47);

    System.out.print(w.getob() + " ");
    System.out.println(w.getnum());
  }
}
