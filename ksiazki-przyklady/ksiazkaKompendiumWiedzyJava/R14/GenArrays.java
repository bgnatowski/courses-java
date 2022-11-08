// Typy sparametryzowane i tablice
class Gen<T extends Number> {
  T ob;

  T vals[]; // Poprawne

  Gen(T o, T[] nums) {
    ob = o;

    // Poniższa instrukcja jest błędna
    // vals = new T[10]; // Nie można utworzyć tablicy typu T

    // Poniższa instrukcja jest poprawna
    vals = nums; // Można przypisać referencję do tablicy do istniejącej zmiennej
  }
}

class GenArrays {
  public static void main(String args[]) {
    Integer n[] = { 1, 2, 3, 4, 5 };

    Gen<Integer> iOb = new Gen<Integer>(50, n);

    // Nie można utworzyć tablicy, podając jako parametr typu konkretny typ
    // Gen<Integer> gens[] = new Gen<Integer>[10]; // Błąd!

    // Poniższa instrukcja jest poprawna
    Gen<?> gens[] = new Gen<?>[10]; // Poprawne
  }
}
