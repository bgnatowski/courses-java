// Prezentacja klasy Optional<T>

import java.util.*;

class OptionalDemo {
  public static void main(String args[]) {

    Optional<String> noVal = Optional.empty();

    Optional<String> hasVal = Optional.of("ABCDEFG");    

    if(noVal.isPresent()) 
      System.out.println("Ten komunikat nie zostanie wyświetlony.");
    else 
      System.out.println("Zmienna noVal nie zawiera wartości.");

    if(hasVal.isPresent()) 
      System.out.println("Łańcuch w zmiennej hasVal to: " +
                                               hasVal.get());

    String defStr = noVal.orElse("Łańcuch domyślny");
    System.out.println(defStr);
  }
}
