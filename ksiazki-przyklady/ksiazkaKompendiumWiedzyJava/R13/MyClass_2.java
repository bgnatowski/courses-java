// Aby skompilować tę klasę należy zmienić nazwę pliku na MyClass.java
// 
class MyClass {
  int a;
  int b;

  // Inicjalizuje składowe a oraz b
  MyClass(int i, int j) {
    a = i;
    b = j;
  }

  // Inicjalizuje składowe a oraz b przy użyciu tej samej wartości
  MyClass(int i) {
    this(i, i); // Wywołuje MyClass(i, i)
  }

  // Przypisuje składowym a oraz b domyślną wartość 0
  MyClass( ) {
    this(0); // Wywołuje MyClass(0)
  }
}
