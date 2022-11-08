// Wykorzystanie metody trim() do przetwarzania poleceń
import java.io.*;

class UseTrim {
  public static void main(String args[])
    throws IOException
  {
    // Utworzenie BufferedReader przy użyciu System.in
    BufferedReader br = new
      BufferedReader(new InputStreamReader(System.in));
    String str;

    System.out.println("Wpisz 'stop', aby wyjść.");
    System.out.println("Wpisz nazwę województwa: ");
    do {
      str = br.readLine();
      str = str.trim(); // Usunięcie znaków białych

      if(str.equals("śląskie"))
        System.out.println("Miasto wojewódzkie: Katowice");
      else if(str.equals("mazowieckie"))
        System.out.println("Miasto wojewódzkie: Warszawa");
      else if(str.equals("małopolskie"))
        System.out.println("Miasto wojewódzkie: Kraków");
      else if(str.equals("opolskie"))
        System.out.println("Miasto wojewódzkie: Opole");
      // ...
    } while(!str.equals("stop"));
  }
}
