// Korzystanie z operatora instanceof dla hierarchii klas sparametryzowanych
class Gen<T> {
  T ob;

  Gen(T o) {
    ob = o;
  }

  // Zwraca ob
  T getob() {
    return ob;
  }
}

// Podklasa klasy Gen
class Gen2<T> extends Gen<T> {
  Gen2(T o) {
    super(o);
  }
}

// Analiza hierarchii klas sparametryzowanych
class HierDemo3 {
  public static void main(String args[]) {

    // Utworzenie obiektu Gen dla Integer
    Gen<Integer> iOb = new Gen<Integer>(88);

    // Utworzenie obiektu Gen2 dla Integer
    Gen2<Integer> iOb2 = new Gen2<Integer>(99);

    // Utworzenie obiektu Gen2 dla String
    Gen2<String> strOb2 = new Gen2<String>("Test parametryzacji");

    // Sprawdzenie, czy iOb2 to pewna postać Gen2
    if(iOb2 instanceof Gen2<?>)
      System.out.println("iOb2 to egzemplarz Gen2");

    // Sprawdzenie, czy iOb2 to pewna postać Gen
    if(iOb2 instanceof Gen<?>)
      System.out.println("iOb2 to egzemplarz Gen");

    System.out.println();

    // Sprawdzenie, czy strOb2 to egzemplarz Gen2
    if(strOb2 instanceof Gen2<?>)
      System.out.println("strOb to egzemplarz Gen2");

    // Sprawdzenie, czy strOb2 to egzemplarz Gen
    if(strOb2 instanceof Gen<?>)
      System.out.println("strOb to egzemplarz Gen");

    System.out.println();

    // Sprawdzenie, czy iOb to pewna postać Gen2; jest to fałsz
    if(iOb instanceof Gen2<?>)
      System.out.println("iOb to egzemplarz Gen2");

    // Sprawdzenie, czy iOb to pewna postać Gen; jest to prawda
    if(iOb instanceof Gen<?>)
      System.out.println("iOb to egzemplarz Gen");

    // Poniższego kodu nie można skompilować, ponieważ informacje na temat
    // typu sparametryzowanego nie istnieją w trakcie pracy programu
//    if(iOb2 instanceof Gen2<Integer>)
//      System.out.println("iOb2 to egzemplarz Gen2<Integer>");
  }
}
