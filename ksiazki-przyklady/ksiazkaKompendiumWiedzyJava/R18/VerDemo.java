// Przykład zastosowania klasy Runtime.Version
class VerDemo { 
  public static void main(String args[]) { 
    Runtime.Version ver = Runtime.version(); 

    // Wyświetlenie poszczególnych liczników 
    System.out.println("Licznik wersji z nowymi możliwościai: " + ver.feature()); 
    System.out.println("Licznik wersji tymczasowej: " + ver.interim()); 
    System.out.println("Licznik wersji aktualizacji: " + ver.update()); 
    System.out.println("Licznik wersji łatki: " + ver.patch()); 
  } 
}
