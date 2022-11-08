/* Kopiowanie plików tekstowych

   Aby użyć programu, należy wpisać nazwę 
   pliku źródłowego i docelowego,
   na przykład aby skopiować plik FIRST.TXT
   do pliku SECOND.TXT, trzeba wpisać poniższe
   polecenie w wierszu poleceń

   java CopyFile FIRST.TXT SECOND.TXT
*/

import java.io.*;

class CopyFile {
  public static void main(String args[]) throws IOException
  {
    int i;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // Najpierw sprawdza, czy podano nazwy obu plików
    if(args.length != 2) {
      System.out.println("Sposób użycia: CopyFile źródło cel");
      return;
    }

    // Kopiuje plik
    try {
      // Próba otwarcia plików
      fin = new FileInputStream(args[0]);
      fout = new FileOutputStream(args[1]);

      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    } finally {
      try {
        if(fin != null) fin.close();
      } catch(IOException e2) {
        System.out.println("Błąd zamykania pliku źródłowego");
      }
      try {
        if(fout != null) fout.close();
      } catch(IOException e2) {
        System.out.println("Błąd zamykania pliku docelowego");
      }
    }
  }
}
