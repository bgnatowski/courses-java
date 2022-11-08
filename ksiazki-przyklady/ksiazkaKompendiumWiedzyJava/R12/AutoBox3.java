// Automatyczne opakowywanie w wyrażeniach

class AutoBox3 {
  public static void main(String args[]) {

    Integer iOb, iOb2;
    int i;

    iOb = 100;
    System.out.println("Oryginalna wartość iOb: " + iOb);

    // Poniższy kod powoduje automatyczne rozpakowanie iOb,
    // inkrementowanie wartości i ponowne opakowanie
    // wyniku w obiekcie iOb
    ++iOb;
    System.out.println("Po ++iOb: " + iOb);

    // Tutaj iOb jest rozpakowywane, obliczana jest wartość
    // wyrażenia i wynik jest ponownie pakowany do iOb2
    iOb2 = iOb + (iOb / 3);
    System.out.println("iOb2 po wyrażeniu: " + iOb2);
    
    // Obliczenie tego samego wyrażenia,
    // ale bez automatycznego opakowywania
    i = iOb + (iOb / 3);
    System.out.println("i po wyrażeniu: " + i);

  }
}
