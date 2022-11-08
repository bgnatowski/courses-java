// Przykład użycia metod klasy Vector
import java.util.*;

class VectorDemo {
  public static void main(String args[]) {

    // Początkowa pojemność 3, inkrementacja o 2
    Vector<Integer> v = new Vector<Integer>(3, 2);

System.out.println("Początkowy rozmiar: " + v.size());
    System.out.println("Początkowa pojemność: " +
                       v.capacity());

    v.addElement(1);
    v.addElement(2);
    v.addElement(3);
    v.addElement(4);

    System.out.println("Pojemność po czterech dodawaniach: " +
                       v.capacity());
    v.addElement(5);
    System.out.println("Aktualna pojemność: " +
                       v.capacity());
    v.addElement(6);
    v.addElement(7);

    System.out.println("Aktualna pojemność: " +
                       v.capacity());
    v.addElement(9);
    v.addElement(10);

    System.out.println("Aktualna pojemność: " +
                       v.capacity());
    v.addElement(11);
    v.addElement(12);


    System.out.println("Pierwszy element: " + v.firstElement());
    System.out.println("Ostatni element: " + v.lastElement());

    if(v.contains(3))
      System.out.println("Wektor zawiera wartość 3.");

    // Wyliczenie elementów wektora
    Enumeration<Integer> vEnum = v.elements();

    System.out.println("\nElementy wektora:");
    while(vEnum.hasMoreElements())
      System.out.print(vEnum.nextElement() + " ");
    System.out.println();
  }
}
