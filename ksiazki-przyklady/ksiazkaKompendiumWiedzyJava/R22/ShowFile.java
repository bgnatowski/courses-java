/* Wyświetla zawartość pliku tekstowego za pomocą elementów systemu NIO obsługujących strumienie

   Podczas uruchamiania tego programu należy podać nazwę pliku, którego zawartość ma być wyświetlona
   Aby na przykład wyświetlić plik nazwany TEST.TXT, należy użyć następującego polecenia:

   java ShowFile TEST.TXT 
*/
import java.io.*;
import java.nio.file.*;

class ShowFile {
  public static void main(String args[])
  {
    int i;

    // Uzyskuje najpierw nazwę pliku podaną przez użytkownika
    if(args.length != 1) {
      System.out.println("Sposób użycia: ShowFile nazwa-pliku");
      return;
    }

    // Otwiera plik i uzyskuje powiązany z nim strumień
    try ( InputStream fin = Files.newInputStream(Path.of(args[0])) )
    {
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);
      
    } catch(InvalidPathException e) {
      System.out.println("Błąd ścieżki: " + e);
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
