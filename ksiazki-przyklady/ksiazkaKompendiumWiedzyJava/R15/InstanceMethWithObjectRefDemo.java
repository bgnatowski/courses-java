// Program przedstawia zastosowanie referencji do metody
// instancyjnej wywoływanej na rzecz różnych obiektów
 
// Interfejs funkcyjny, którego metoda ma dwa parametry 
// typu referencyjnego i zwraca wynik typu boolean
interface MyFunc<T> { 
  boolean func(T v1, T v2); 
} 
 
// Klasa przechowująca informację o wysokości temperatury
// w ciągu dnia
class HighTemp { 
  private int hTemp; 
 
  HighTemp(int ht) { hTemp = ht; } 
 
  // Zwraca true, jeśli obiekt HighTemp, na rzecz którego metoda
  // została wywołana, ma tę samą temperaturę co przekazany 
  // obiekt ht2
  boolean sameTemp(HighTemp ht2) { 
    return hTemp == ht2.hTemp; 
  } 
 
  // Zwraca true, jeśli obiekt HighTemp, na rzecz którego metoda
  // została wywołana, ma niższą temperaturę niż przekazany
  // obiekt ht2
  boolean lessThanTemp(HighTemp ht2) { 
    return hTemp < ht2.hTemp; 
  } 
} 
 
class InstanceMethWithObjectRefDemo { 
 
  // Metoda zwraca liczbę obiektów spełniających 
  // kryterium przekazane jako parametr typu MyFunc
  static <T> int counter(T[] vals, MyFunc<T> f, T v) { 
    int count = 0; 
 
    for(int i=0; i < vals.length; i++) 
      if(f.func(vals[i], v)) count++; 
 
    return count;   
  } 
 
  public static void main(String args[]) 
  { 
    int count; 
 
    // Tworzy tablicę obiektów HighTemp
    HighTemp[] weekDayHighs = { new HighTemp(30), new HighTemp(27), 
                                new HighTemp(32), new HighTemp(30), 
                                new HighTemp(30), new HighTemp(33), 
                                new HighTemp(26), new HighTemp(25) }; 
 
    // Wywołanie metody counter() operującej na tablicy 
    // obiektów HighTemp; warto zwrócić uwagę na referencję do 
    // metody instancyjnej sameTemp() przekazywaną jako 
    // drugi argument wywołania
    count = counter(weekDayHighs, HighTemp::sameTemp, 
                  new HighTemp(30)); 
    System.out.println(count + " dni miały temperaturę 30 stopni."); 
 
    // Utworzenie i użycie kolejnej tablicy obiektów HighTemp
    HighTemp[] weekDayHighs2 = { new HighTemp(16), new HighTemp(6), 
                                new HighTemp(17), new HighTemp(10), 
                                new HighTemp(11), new HighTemp(10), 
                                new HighTemp(-1), new HighTemp(9) }; 
 
    count = counter(weekDayHighs2, HighTemp::sameTemp, 
                    new HighTemp(10)); 
    System.out.println(count + " dni miały temperaturę 10 stopni."); 
 
 
    // Zastosowanie metody lessThanTemp() do znalezienia liczby dni,
    // w których temperatura była niższa od zadanej
    count = counter(weekDayHighs, HighTemp::lessThanTemp, 
                    new HighTemp(30)); 
    System.out.println(count + " dni miały temperaturę poniżej 30 stopni."); 
 
    count = counter(weekDayHighs2, HighTemp::lessThanTemp, 
                    new HighTemp(10)); 
    System.out.println(count + " dni miały temperaturę poniżej 10 stopni."); 
  } 
}
