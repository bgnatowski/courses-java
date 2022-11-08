// Przykład użycia klasy RecursiveTask<V>
import java.util.concurrent.*;

// Klasa rozszerzająca klasę RecursiveTask i obliczająca sumę elementów tablicy liczb typu double
class Sum extends RecursiveTask<Double> {

  // Wartość progu przetwarzania sekwencyjnego
  final int seqThresHold = 500;

  // Tablica do przetworzenia
  double[] data;

  // Określa fragment danych do przetworzenia
  int start, end;

  Sum(double[] vals, int s, int e ) {
    data = vals;
    start = s;
    end = e;
  }

  // Oblicza sumę elementów tablicy złożonej z liczb typu double
  protected Double compute() {
    double sum = 0;

    // Jeśli liczba elementów jest mniejsza od progu przetwarzania sekwencyjnego,
    // przetwarza dane sekwencyjnie
    if((end - start) < seqThresHold) {
      // Sumuje elementy
      for(int i = start; i < end; i++) sum += data[i];
    }
    else {
      // W przeciwnym razie kontynuuje dzielenie danych na mniejsze fragmenty
      // Wyznacza punkt środkowy
      int middle = (start + end) / 2;

      // Wywołuje nowe zadania dla podzielonych danych
      Sum subTaskA = new Sum(data, start, middle);
      Sum subTaskB = new Sum(data, middle, end);

      // Rozpoczyna dwa podzadania za pomocą metody fork()
      subTaskA.fork();
      subTaskB.fork();

      // Czeka na zwrócenie sterowania przez podzadania i łączy uzyskane wyniki
      sum = subTaskA.join() + subTaskB.join();
    }
    // Zwraca łączną sumę wartości
    return sum;
  }
}

// Demonstruje równoległe wykonywanie zadań
class RecurTaskDemo {
  public static void main(String args[]) {
    // Tworzy pulę zadań
    ForkJoinPool fjp = new ForkJoinPool();

    double[] nums = new double[5000];

    // Inicjalizuje tablicę nums, stosując naprzemiennie
    // wartości dodatnie i ujemne
    for(int i=0; i < nums.length; i++)
      nums[i] = (double) (((i%2) == 0) ? i : -i) ;

    Sum task = new Sum(nums, 0, nums.length);

    // Uruchamia zadania typu ForkJoinTasks; łatwo zauważyć, że tym razem
    // metoda invoke() zwraca wynik
    double summation = fjp.invoke(task);

    System.out.println("Suma: " + summation);
  }
}
