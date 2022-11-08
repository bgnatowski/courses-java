// Użycie metody collect() w celu zwracania zawartości 
// strumienia w formie obiektów List i Set
 
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
 
class StreamDemo7 { 
 
  public static void main(String[] args) { 
 
    // Lista imion, numerów telefonów i adresów e-mail
    ArrayList<NamePhoneEmail> myList = new ArrayList<>( ); 
 
    myList.add(new NamePhoneEmail("Janek", "555-5555", 
                                  "Janek@SajtDomowy.priv.pl")); 
    myList.add(new NamePhoneEmail("Krysia", "555-4444", 
                                  "Krysia@SajtDomowy.priv.pl ")); 
    myList.add(new NamePhoneEmail("Marysia", "555-3333", 
                                  "Marysia@SajtDomowy.priv.pl ")); 
 
    // Tworzy nowy strumień zawierający wyłącznie imiona 
    // i numery telefonów
    Stream<NamePhone> nameAndPhone = myList.stream().map( 
                                     (a) -> new NamePhone(a.name,a.phonenum) 
                                   ); 
 
    // Wywołuje metodę collect(), by zwrócić imiona i numery telefonów
    // w formie obiektu typu List
    List<NamePhone> npList = nameAndPhone.collect(Collectors.toList()); 
 
    System.out.println("Imiona i telefony w formie obiektu List:"); 
    for(NamePhone e : npList)  
      System.out.println(e.name + ": " + e.phonenum); 
 
    // Tworzy kolejny strumień zawierający jedynie imiona i numery
    // telefonów 
    nameAndPhone = myList.stream().map( 
                                     (a) -> new NamePhone(a.name,a.phonenum) 
                                    ); 
 
    // Używa metody collect() do zwrócenia zawartości strumienia w formie
    // obiektu typu Set
    Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet()); 
 
    System.out.println("\nImiona i telefony w formie obiektu Set:"); 
    for(NamePhone e : npSet)  
      System.out.println(e.name + ": " + e.phonenum); 
  } 
}
