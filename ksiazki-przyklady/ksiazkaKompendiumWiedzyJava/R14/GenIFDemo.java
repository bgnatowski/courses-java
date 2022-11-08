// Przykład interfejsu sparametryzowanego

// Interfejs MinMax
interface MinMax<T extends Comparable<T>> {
  T min();
  T max();
}

// Implementacja interfejsu MinMax
class MyClass<T extends Comparable<T>> implements MinMax<T> {
  T[] vals;

  MyClass(T[] o) { vals = o; }

  // Zwraca minimalną wartość z vals
  public T min() {
    T v = vals[0];

    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) < 0) v = vals[i];

    return v;
  }

  // Zwraca maksymalną wartość z vals
  public T max() {
    T v = vals[0];

    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) > 0) v = vals[i];

    return v;
  }
}

class GenIFDemo {
  public static void main(String args[]) {
    Integer inums[] = {3, 6, 2, 8, 6 };
    Character chs[] = {'b', 'r', 'p', 'w' };

    MyClass<Integer> iob = new MyClass<Integer>(inums);
    MyClass<Character> cob = new MyClass<Character>(chs);

    System.out.println("Maksymalna wartość w inums: " + iob.max());
    System.out.println("Minimalna wartość w inums: " + iob.min());

    System.out.println("Maksymalna wartość w chs: " + cob.max());
    System.out.println("Minimalna wartość w chs: " + cob.min());
  }
}
