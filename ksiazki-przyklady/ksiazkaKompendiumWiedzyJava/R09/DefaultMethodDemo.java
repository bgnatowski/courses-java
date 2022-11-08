// Zastosowanie metody domyślnej
class DefaultMethodDemo { 
  public static void main(String args[]) { 
 
    MyIFImp obj = new MyIFImp(); 
 
    // Wywołuje metodę getNumber(), gdyż jest ona jawnie
    // zaimplementowana w klasie MyIFImp 
    System.out.println(obj.getNumber()); 
 
    // Ze względu na implementację domyślną to wywołanie  
    // może mieć także postać getString()
    System.out.println(obj.getString()); 
  } 
}
