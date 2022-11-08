// Prezentacja prostego wyrażenia lambda
 
// Interfejs funkcyjny 
interface MyNumber { 
  double getValue();
} 
 
class LambdaDemo { 
  public static void main(String args[]) 
  { 
    MyNumber myNum;  // Deklaracja zmiennej referencyjnej typu interfejsu 
 
    // W tym przypadku wyrażenie lambda zwraca stałą
    // W momencie przypisania wyrażenia do zmiennej myNum tworzona jest
    // instancja klasy, w której wyrażenie lambda przesłania metodę 
    // getValue() interfejsu MyNumber i określa jej implementację
    myNum = () -> 123.45; 
 
    // Wywołuje metodę getValue(), która została przesłonięta przez
    // poprzednie przypisanie wyrażenia lambda
    System.out.println("Wartość stała: " + myNum.getValue()); 
 
    // Przykład użycia nieco bardziej złożonego wyrażenia
    myNum = () -> Math.random() * 100; 
 
    // Wywołuje wyrażenie lambda z poprzedniego wiersza
    System.out.println("Wartość losowa: " + myNum.getValue()); 
    System.out.println("Inna wartość losowa: " + myNum.getValue()); 
 
    // Wyrażenie lambda musi być zgodne z metodą zdefiniowaną 
    // w interfejsie funkcyjnym, dlatego próba użycia poniższego 
    // wyrażenia zgłosi błąd
    // myNum = () -> "123.03"; // Błąd! 
  } 
}
