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
    a = i;
    b = i;
  }

  // Przypisuje składowym a oraz b domyślną wartość 0
  MyClass( ) {
    a = 0;
    b = 0;
  }
}
