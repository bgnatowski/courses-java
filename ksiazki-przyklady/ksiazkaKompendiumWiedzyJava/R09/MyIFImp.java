// Implementacja interfejsu MyIF 
class MyIFImp implements MyIF { 
  // Konieczne jest zaimplementowanie wyłącznie metody getNumber() 
  // interfejsu MyIF, w przypadku metody getString() można 
  // bowiem skorzystać z implementacji domyślnej
  public int getNumber() { 
    return 100; 
  } 
}
