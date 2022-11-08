// Przedstawia zastosowanie metody map() do utworzenia nowego
// strumienia zawierającego wyłącznie wybrane aspekty
// strumienia początkowego
 
import java.util.*; 
import java.util.stream.*; 
 
class NamePhoneEmail { 
  String name;   
  String phonenum; 
  String email; 
 
  NamePhoneEmail(String n, String p, String e) { 
    name = n; 
    phonenum = p; 
    email = e; 
  } 
} 
 
class NamePhone { 
  String name; 
  String phonenum; 
 
  NamePhone(String n, String p) { 
    name = n; 
    phonenum = p; 
  } 
} 
 
class StreamDemo5 { 
 
  public static void main(String[] args) { 
 
    // Lista imion, numerów telefonów i adresów e-mail
    ArrayList<NamePhoneEmail> myList = new ArrayList<>( ); 
 
    myList.add(new NamePhoneEmail("Janek", "555-5555", 
                                  "Janek@SajtDomowy.priv.pl")); 
    myList.add(new NamePhoneEmail("Krysia", "555-4444", 
                                  "Krysia@SajtDomowy.priv.pl ")); 
    myList.add(new NamePhoneEmail("Marysia", "555-3333", 
                                  "Marysia@SajtDomowy.priv.pl ")); 
 
    System.out.println("Początkowa zawartość listy myList: "); 
    myList.stream().forEach( (a) -> { 
      System.out.println(a.name + " " + a.phonenum + " " + a.email); 
    }); 
    System.out.println(); 
 
    // Odwzorowuje imiona i numery telefonów do nowego strumienia
    Stream<NamePhone> nameAndPhone = myList.stream().map( 
                                     (a) -> new NamePhone(a.name,a.phonenum) 
                                   ); 
 
    System.out.println("Lista imion i telefonów: "); 
    nameAndPhone.forEach( (a) -> { 
      System.out.println(a.name + " " + a.phonenum); 
    }); 
  } 
}
