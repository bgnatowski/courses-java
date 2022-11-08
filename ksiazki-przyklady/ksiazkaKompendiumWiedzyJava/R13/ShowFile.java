/* Wyświetla zawartość pliku tekstowego

   Aby użyć programu, określ nazwę
   pliku do wyświetlenia,
   na przykład wyświetlenie pliku o nazwie TEST.TXT
   wymaga wpisania poniższego wiersza

   java ShowFile TEST.TXT
*/

import java.io.*;

class ShowFile {
  public static void main(String args[])
  {
    int i;
    FileInputStream fin;

    // Sprawdza, czy podano nazwę pliku
    if(args.length != 1) {
      System.out.println("Sposób użycia: ShowFile nazwa-pliku");
      return;
    }

    // Próba otwarcia pliku
    try {
      fin = new FileInputStream(args[0]);
    } catch(FileNotFoundException e) {
      System.out.println("Nie można otworzyć pliku ");
      return;
    }

    // Na tym etapie plik jest otwarty i gotowy do odczytu
    // Poniższy kod odczytuje znaki do momentu osiągnięcia końca pliku
    try {
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);
    } catch(IOException e) {
      System.out.println("Błąd odczytu pliku ");
    }

    // Zamyka plik
    try {
      fin.close();
    } catch(IOException e) {
      System.out.println("Błąd zamykania pliku ");
    }
  }
}
