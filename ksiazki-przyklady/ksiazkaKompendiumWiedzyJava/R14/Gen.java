// Nie można utworzyć egzemplarza klasy T
class Gen<T> {
  T ob;

  Gen() {
    ob = new T(); // Błąd!!!
  }
}
