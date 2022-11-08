/* Wyświetla zawartość pliku tekstowego

   Podczas uruchamiania programu podaj nazwę
   pliku do wyświetlenia,
   na przykład wyświetlenie pliku o nazwie TEST.TXT
   wymaga wpisania poniższego wiersza

   java ShowFile2 TEST.TXT

   Ta wersja programu umieszcza kod otwierający plik i
   uzyskujący dostęp do jego zawartości w jednym bloku
   try, plik jest zamykany w bloku finally
*/
import java.io.*;

class ShowFile2 {
  public static void main(String args[])
  {
    int i;
    FileInputStream fin = null;

    // Sprawdza, czy podano nazwę pliku
    if(args.length != 1) {
      System.out.println("Sposób użycia: ShowFile2 nazwa-pliku");
      return;
    }

    // Poniższy kod otwiera plik, odczytuje jego zawartość do momentu
    // osiągnięcia końca pliku, po czym zamyka plik w bloku finally
    try {
      fin = new FileInputStream(args[0]);
      
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(FileNotFoundException e) {
      System.out.println("Nie znaleziono pliku");
    } catch(IOException e) {
      System.out.println("Wystąpił błąd wejścia-wyjścia");
    } finally {
      // Zamyka plik niezależnie od sytuacji
      try {
        if(fin != null) fin.close();
      } catch(IOException e) {
        System.out.println("Błąd zamykania pliku");
      }
    }
  }
}
