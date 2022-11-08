// Przykład użycia klasy Arrays
import java.util.*;

class ArraysDemo {
  public static void main(String args[]) {

    // Alokacja i inicjalizacja tablicy
    int array[] = new int[10];
    for(int i = 0; i < 10; i++)
      array[i] = -3 * i;

    // Wyświetlenie, posortowanie i ponowne wyświetlenie tablicy
    System.out.print("Pierwotna zawartość: ");
    display(array);
    Arrays.sort(array);
    System.out.print("Po sortowaniu: ");
    display(array);

    // Wypełnienie i wyświetlenie tablicy
    Arrays.fill(array, 2, 6, -1);
    System.out.print("Po fill(): ");
    display(array);

    // Posortowanie i wyświetlenie tablicy
    Arrays.sort(array);
    System.out.print("Po kolejnym sortowaniu: ");
    display(array);

    // Wyszukiwanie binarne dla wartości -9
    System.out.print("Wartość -9 znajduje się pod indeksem ");
    int index =
      Arrays.binarySearch(array, -9);

    System.out.println(index);
  }

  static void display(int array[]) {
    for(int i: array)
      System.out.print(i + " ");

    System.out.println();
  }
}
