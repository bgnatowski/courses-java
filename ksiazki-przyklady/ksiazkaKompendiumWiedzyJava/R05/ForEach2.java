// Użycie instrukcji break w pętli typu for-each
class ForEach2 {
  public static void main(String args[]) {
    int sum = 0;
    int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    // Użycie pętli typu for-each do wyświetlenia i zsumowania wartości
    for(int x : nums) {
      System.out.println("Wartość - " + x);
      sum += x;
      if(x == 5) break; // Zatrzymaj przy wartości 5
    }
    System.out.println("Suma pierwszych pięciu elementów: " + sum);
  }
}
