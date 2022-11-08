// Demonstruje użycie klasy File
import java.io.File;

class FileDemo {
  static void p(String s) {
    System.out.println(s);
  }

  public static void main(String args[]) {
    File f1 = new File("/java/COPYRIGHT");
    
    p("Nazwa pliku: " + f1.getName());
    p("Ścieżka: " + f1.getPath());
    p("Ścieżka bezwzględna: " + f1.getAbsolutePath());
    p("Katalog macierzysty: " + f1.getParent());
    p(f1.exists() ? "istnieje" : "nie istnieje");
    p(f1.canWrite() ? "jest dostępny do zapisu" : "nie jest dostępny do zapisu");
    p(f1.canRead() ? "jest dostępny do odczytu" : "nie jest dostępny do odczytu");
    p(f1.isDirectory() ? "jest katalogiem" : "nie jest katalogiem");
    p(f1.isFile() ? "jest normalnym plikiem" : "może być nazwanym potokiem");
    p(f1.isAbsolute() ? "jest bezwzględny" : "jest względny");
    p("Ostatnia modyfikacja pliku: " + f1.lastModified());
    p("Rozmiar pliku: " + f1.length() + " bajtów");
  }
}
