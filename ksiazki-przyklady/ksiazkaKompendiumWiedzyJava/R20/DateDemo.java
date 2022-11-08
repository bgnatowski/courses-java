// Wyświetla datę i godzinę z wykorzystaniem samych metod klasy Date
import java.util.Date;

class DateDemo {
  public static void main(String args[]) {
    // Tworzy obiekt klasy Date
    Date date = new Date();
    
    // Wyświetla datę i godzinę za pomocą metody toString()
    System.out.println(date);

    // Wyświetla wyrażony w milisekundach czas, jaki upłynął od północy 1 stycznia 1970 roku (GMT)
    long msec = date.getTime();
    System.out.println("Milisekundy od 1 stycznia 1970 roku (GMT) = " + msec);
  }
}
