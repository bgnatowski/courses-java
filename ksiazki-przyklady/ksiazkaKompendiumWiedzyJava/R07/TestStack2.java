// Ulepszona klasa Stack wykorzystująca rozmiar tablicy
class Stack {
  private int stck[];
  private int tos;

  // Alokacja i inicjalizacja stosu
  Stack(int size) {
    stck = new int[size];
    tos = -1;
  }

  // Umieszczenie elementu na szczycie stosu
  void push(int item) {
    if(tos==stck.length-1) // użycie zmiennej składowej length
      System.out.println("Stos jest pełny.");
    else
      stck[++tos] = item;
  }

  // Zdjęcie elementu ze szczytu stosu
  int pop() {
    if(tos < 0) {
      System.out.println("Stos nie zawiera żadnych elementów.");
      return 0;
    }
    else
      return stck[tos--];
  }
}

class TestStack2 {
  public static void main(String args[]) {
    Stack mystack1 = new Stack(5);
    Stack mystack2 = new Stack(8);
    
    // Umieszczenie liczb na stosach
    for(int i=0; i<5; i++) mystack1.push(i);
    for(int i=10; i<8; i++) mystack2.push(i);

    // Zdjęcie liczb ze stosów
    System.out.println("Stos w mystack1:");
    for(int i=0; i<5; i++)
       System.out.println(mystack1.pop());

    System.out.println("Stos w mystack2:");
    for(int i=0; i<8; i++)
       System.out.println(mystack2.pop());
  }
}
