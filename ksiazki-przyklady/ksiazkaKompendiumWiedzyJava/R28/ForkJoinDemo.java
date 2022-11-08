// Prosty przykład strategii dziel i zwyciężaj
// W tym przypadku zostanie użyta klasa RecursiveAction
import java.util.concurrent.*;
import java.util.*;

// Klasa ForkJoinTask (za pośrednictwem klasy RecursiveAction) przekształcająca
// elementy tablicy liczb typu double na ich pierwiastki kwadratowe

class SqrtTransform extends RecursiveAction {
  // Na potrzeby tego przykładu użyto przypadkowo wybranej wartości progu równej 1000
  // W rzeczywistym kodzie należałoby wyznaczyć optymalną wartość,
  // stosując technikę profilowania i przeprowadzając odpowiednie eksperymenty

  final int seqThreshold = 1000;

  // Tablica do przetworzenia
  double[] data;

  // Określa fragment danych do przetworzenia
  int start, end;

  SqrtTransform(double[] vals, int s, int e ) {
    data = vals;
    start = s;
    end = e;
  }

  // W tej metodzie będą wykonywane równoległe obliczenia
  protected void compute() {

    // Jeśli liczba elementów jest mniejsza od progu przetwarzania sekwencyjnego,
    // przetwarza dane sekwencyjnie
    if((end - start) < seqThreshold) {
      // Przekształca każdy element, wyznaczając jego pierwiastek kwadratowy
      for(int i = start; i < end; i++) {
        data[i] = Math.sqrt(data[i]);
      }
    }
    else {
      // W przeciwnym razie kontynuuje dzielenie danych na mniejsze fragmenty

      // Wyznacza punkt środkowy
      int middle = (start + end) / 2;

      // Wywołuje nowe zadania dla podzielonych danych
      invokeAll(new SqrtTransform(data, start, middle),
                new SqrtTransform(data, middle, end));
    }
  }
}

// Demonstruje równoległe wykonywanie zadań
class ForkJoinDemo {
  public static void main(String args[]) {
    // Tworzy pulę zadań
    ForkJoinPool fjp = new ForkJoinPool();

    double[] nums = new double[100000];

    // Nadaje wartości poszczególnym elementom tablicy
    for(int i = 0; i < nums.length; i++)
      nums[i] = (double) i;

    System.out.println("Fragment pierwotnej sekwencji:");

    for(int i=0; i < 10; i++)
      System.out.print(nums[i] + " ");
    System.out.println("\n");

    SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

    // Uruchamia główne zadanie typu ForkJoinTask
    fjp.invoke(task);

    System.out.println("Fragment przekształconej sekwencji" +
                       " (do czterech miejsc po przecinku):");
    for(int i=0; i < 10; i++)
      System.out.format("%.4f ", nums[i]);
    System.out.println();
  }
}
