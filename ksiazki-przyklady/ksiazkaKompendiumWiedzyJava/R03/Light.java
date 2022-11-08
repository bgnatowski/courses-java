// Obliczanie odległości przebytej przez światło za pomocą zmiennych typu long
class Light {
  public static void main(String args[]) {
    int lightspeed;
    long days;
    long seconds; 
    long distance;

    // Przybliżona prędkość światła w kilometrach na sekundę
    lightspeed = 186000;

    days = 1000; // Określenie liczby dni

    seconds = days * 24 * 60 * 60; // Konwersja na sekundy

    distance = lightspeed * seconds; // Obliczenie odległości

    System.out.print("W " + days);
    System.out.print(" dni światło przebędzie ");
    System.out.println(distance + " kilometrów.");
  }
}