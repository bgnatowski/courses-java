// Prosty program umożliwiający eksperymenty i obserwację skutków
// zmian progu i poziomu równoległości obiektu typu ForkJoinTask
import java.util.concurrent.*;

// Klasa ForkJoinTask (za pośrednictwem klasy RecursiveAction) przekształcająca
// elementy tablicy liczb typu double
class Transform extends RecursiveAction {

  // Próg przetwarzania sekwencyjnego ustawiany przez konstruktor
  int seqThreshold;

  // Tablica do przetworzenia
  double[] data;

  // Określa fragment danych do przetworzenia
  int start, end;

  Transform(double[] vals, int s, int e, int t ) {
    data = vals;
    start = s;
    end = e;
    seqThreshold = t;
  }

  // W tej metodzie będą wykonywane równoległe obliczenia
  protected void compute() {

    // Jeśli liczba elementów jest mniejsza od progu przetwarzania sekwencyjnego,
    // przetwarza dane sekwencyjnie
    if((end - start) < seqThreshold) {
      // Poniższy kod przypisuje elementowi z parzystym indeksem
      // pierwiastek kwadratowy oryginalnej wartości, elementowi z nieparzystym indeksem
      // jest przypisywany pierwiastek sześcienny. Kod zaprojektowano z myślą
      // o zajmowaniu czasu procesora, tak aby można było łatwiej obserwować
      // efekty przetwarzania współbieżnego
      for(int i = start; i < end; i++) {
        if((data[i] % 2) == 0)
          data[i] = Math.sqrt(data[i]);
        else
          data[i] = Math.cbrt(data[i]);
      }
    }
    else {
      // W przeciwnym razie kontynuuje dzielenie danych na mniejsze fragmenty

      // Wyznacza punkt środkowy
      int middle = (start + end) / 2;

      // Wywołuje nowe zadania dla podzielonych danych
      invokeAll(new Transform(data, start, middle, seqThreshold),
                new Transform(data, middle, end, seqThreshold));
    }
  }
}

// Demonstruje równoległe wykonywanie zadań
class FJExperiment {

  public static void main(String args[]) {
    int pLevel;
    int threshold;

    if(args.length != 2) {
      System.out.println("Sposób użycia: FJExperiment poziom-równoległości próg ");
      return;
    }

    pLevel = Integer.parseInt(args[0]);
    threshold = Integer.parseInt(args[1]);

    // Poniższe zmienne służą do mierzenia czasu wykonywania zadania
    long beginT, endT;

    // Tworzy pulę zadań; warto zwrócić uwagę na ustawiony poziom równoległości
    ForkJoinPool fjp = new ForkJoinPool(pLevel);

    double[] nums = new double[1000000];

    for(int i = 0; i < nums.length; i++)
      nums[i] = (double) i;

    Transform task = new Transform(nums, 0, nums.length, threshold);

    // Rozpoczyna pomiar czasu
    beginT = System.nanoTime();

    // Rozpoczyna główne zadanie typu ForkJoinTask
    fjp.invoke(task);

    // Koniec pomiaru czasu
    endT = System.nanoTime();

    System.out.println("Poziom równoległości: " + pLevel);
    System.out.println("Próg przetwarzania sekwencyjnego: " + threshold);
    System.out.println("Czas działania: " + (endT - beginT) + " ns");
    System.out.println();
  }
}
