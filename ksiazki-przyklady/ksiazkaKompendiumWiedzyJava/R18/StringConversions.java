/* Konwersja liczby całkowitej do postaci
   binarnej, szesnastkowej i ósemkowej
*/

class StringConversions {
  public static void main(String args[]) {
    int num = 19648;

    System.out.println(num + " zapisane binarnie: " +
                       Integer.toBinaryString(num));

    System.out.println(num + " zapisane ósemkowo: " +
                       Integer.toOctalString(num));

    System.out.println(num + " zapisane szesnastkowo: " +
                       Integer.toHexString(num));
  }
}
