/* Program sumuje listę wartości przekazanych przez
   użytkownika; do konwersji liczby z reprezentacji 
   tekstowej na wewnętrzną korzysta z metody parseInt()
*/

import java.io.*;

class ParseDemo {
  public static void main(String args[])
    throws IOException
  {
    // Utworzenie BufferedReader na podstawie System.in
    BufferedReader br = new
      BufferedReader(new InputStreamReader(System.in));
    String str;
    int i;
    int sum=0;

    System.out.println("Wpisz liczby; wpisz 0, aby wyjść.");
    do {
      str = br.readLine();
      try {
        i = Integer.parseInt(str);
      } catch(NumberFormatException e) {
        System.out.println("Błędny format");
        i = 0;
      }
      sum += i;
      System.out.println("Suma wpisanych liczb wynosi: " + sum);
    } while(i != 0);
  }
}
