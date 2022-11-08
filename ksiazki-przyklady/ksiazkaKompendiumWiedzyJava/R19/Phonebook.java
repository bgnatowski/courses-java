/* Prosta baza danych z numerami telefonów korzystająca
   z listy właściwości. */
import java.io.*;
import java.util.*;

class Phonebook {
  public static void main(String args[])
    throws IOException
  {
    Properties ht = new Properties();
    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
    String name, number;
    FileInputStream fin = null;
    boolean changed = false;

    // Próba otwarcia pliku ksiazkatel.dat
    try {
      fin = new FileInputStream("ksiazkatel.dat");
    } catch(FileNotFoundException e) {
      // Zignorowanie, jeśli plik nie istnieje
    }

    /* Jeśli plik bazy danych istnieje,
       załadowanie istniejących numerów telefonów */
    try {
      if(fin != null) {
        ht.load(fin);
        fin.close();
      }
    } catch(IOException e) {
      System.out.println("Błąd odczytu pliku");
    }

    // Niech użytkownik wpisze nowe dane
    do {
      System.out.println("Wpisz nowe imię i nazwisko" +
                         " (wpisz 'koniec', aby zakończyć): ");
      name = br.readLine();
      if(name.equals("koniec")) continue;

      System.out.println("Wpisz numer telefonu: ");
      number = br.readLine();

      ht.setProperty(name, number);
      changed = true;
    } while(!name.equals("koniec"));

    // Jeśli książka została zmieniona, zapisz dane
    if(changed) {
      FileOutputStream fout = new FileOutputStream("ksiazkatel.dat");

      ht.store(fout, "Książka telefoniczna");
      fout.close();
    }

    // Wyszukaj numer po podaniu imienia i nazwiska
    do {
      System.out.println("Wpisz imię i nazwisko do wyszukania" +
                         " (wpisz 'koniec', aby zakończyć): ");
      name = br.readLine();
      if(name.equals("koniec")) continue;

      number = (String) ht.get(name);
      System.out.println(number);
    } while(!name.equals("koniec"));
  }
}
