// Nieudana próba utworzenia klasy sparametryzowanej
// obliczającej średnią elementów wskazanego typu
// znajdujących się w przekazanej tablicy
//
// Klasa zawiera błąd!
class Stats<T> {
  T[] nums; // nums to tablica typu T

  // Przekazanie do konstruktora referencji do
  // tablicy typu T
  Stats(T[] o) {
    nums = o;
  }

  // Zawsze zwracanie średniej jako typu double
  double average() {
    double sum = 0.0;

    for(int i=0; i < nums.length; i++)
      sum += nums[i].doubleValue(); // Błąd!!!

    return sum / nums.length;
  }
}
