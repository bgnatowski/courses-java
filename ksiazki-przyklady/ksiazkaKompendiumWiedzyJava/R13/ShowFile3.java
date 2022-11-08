/* Ta wersja programu ShowFile używa wyrażenia try-with-resources
   do automatycznego zamknięcia pliku, który nie jest już potrzebny
*/

import java.io.*;

class ShowFile3 {
  public static void main(String args[])
  {
    int i;

    // Sprawdza, czy podano nazwę pliku
    if(args.length != 1) {
      System.out.println("Sposób użycia: ShowFile3 nazwa-pliku");
      return;
    }

    // Poniższy kod używa wyrażenia try-with-resources do otwarcia pliku, po czym
    // automatycznie zamyka ten plik w momencie zakończenia bloku try
    try(FileInputStream fin = new FileInputStream(args[0])) {

      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(FileNotFoundException e) {
      System.out.println("Nie znaleziono pliku.");
    } catch(IOException e) {
      System.out.println("Wystąpił błąd wejścia-wyjścia ");
    }

  }
}
