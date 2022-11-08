// Zastosowanie wnioskowania typów w pętlach
class VarDemo3 {
  public static void main(String args[]) {

    // Zastosowanie wnioskowania w zmiennej kontrolnej pętli
    System.out.print("Wartości x: ");
    for(var x = 2.5; x < 100.0; x = x * 2)
      System.out.print(x + " ");

    System.out.println();

    // Zastosowanie wnioskowania w zmiennej iteracyjnej
    int[] nums = { 1, 2, 3, 4, 5, 6};
    System.out.print("Wartości z tablicy nums: ");
    for(var v : nums)
      System.out.print(v + " ");

    System.out.println();
  }
}
