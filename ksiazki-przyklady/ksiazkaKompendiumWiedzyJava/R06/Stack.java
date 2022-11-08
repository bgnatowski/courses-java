// Klasa definiuje stos liczb całkowitych mogący przechowywać do 10 wartości
class Stack {
  int stck[] = new int[10];
  int tos;

  // Inicjalizacja szczytu stosu
  Stack() {
    tos = -1;
  }

  // Umieszczenie elementu na szczycie stosu
  void push(int item) {
    if(tos==9)
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
