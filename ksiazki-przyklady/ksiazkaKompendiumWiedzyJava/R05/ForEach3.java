// Pętla typu for-each dla tablicy dwuwymiarowej
class ForEach3 {
  public static void main(String args[]) {
    int sum = 0;
    int nums[][] = new int[3][5];

    // Wypełnienie tablicy wartościami
    for(int i = 0; i < 3; i++)
      for(int j=0; j < 5; j++)
        nums[i][j] = (i+1)*(j+1);

    // Użycie pętli typu for-each do wyświetlenia i zsumowania wartości
    for(int x[] : nums) {
      for(int y : x) {
        System.out.println("Wartość - " + y);
        sum += y;
      }
    }
    System.out.println("Suma wartości: " + sum);
  }
}
