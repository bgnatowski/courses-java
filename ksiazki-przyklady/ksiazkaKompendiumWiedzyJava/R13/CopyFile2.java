/* Wersja programu CopyFile korzystająca z instrukcji try-with-resources
   Program demonstruje sposób zarządzania dwoma zasobami (w tym przypadku
   plikami) przez pojedyncze wyrażenie try
*/

import java.io.*;

class CopyFile2 {
  public static void main(String args[]) throws IOException
  {
    int i;

    // Najpierw sprawdza, czy podano nazwy obu plików
    if(args.length != 2) {
      System.out.println("Sposób użycia: CopyFile2 źródło cel");
      return;
    }

    // Otwiera dwa pliki i zarządza nimi w ramach wyrażenia try
    try (FileInputStream fin = new FileInputStream(args[0]);
         FileOutputStream fout = new FileOutputStream(args[1]))
    {

      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
