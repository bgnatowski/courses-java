// Przetwarzanie dat i godzin zapisanych w formie tekstowej 
import java.time.*; 
import java.time.format.*; 
 
class DateTimeDemo4 { 
  public static void main(String args[]) { 
 
    // Pobiera obiekt LocalDateTime poprzez przeanalizowanie łańcucha 
    LocalDateTime curDateTime = 
         LocalDateTime.parse("czerwca 21, 2018 12:01 AM", 
                  DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a")); 
 
     // Wyświetla uzyskaną datę i godzinę 
    System.out.println(curDateTime.format( 
               DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a"))); 
  } 
}
 