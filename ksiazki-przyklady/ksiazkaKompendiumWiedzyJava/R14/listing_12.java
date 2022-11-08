// Hierarchia klas sparametryzowanych
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
