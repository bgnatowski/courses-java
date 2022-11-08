public interface MyIF { 
  // To jest "normalna" deklaracja metody interfejsu
  // NIE definiuje ona implementacji domyślnej 
  int getNumber(); 
 
  // To jest metoda domyślna. Zwróć uwagę, że udostępnia 
  // implementację domyślną
  default String getString() { 
    return "Łańcuch domyślny"; 
  } 

  /* Kod dodany w przykładzie z pliku listing_29.java
  // To jest metoda statyczna zdefiniowana w interfejsie. 
  static int getDefaultNumber() { 
    return 0; 
  } 
  */

}
