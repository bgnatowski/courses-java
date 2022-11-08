// W razie korzystanie z dziedziczenia wywnioskowanym typem będzie 
// zadeklarowany typ inicjalizatora, który nie musi odpowiadać
// typowi obiektu, do którego odwołuje się inicjalizator
class MyClass {
  // ...
}

class FirstDerivedClass extends MyClass {
  int x;
  // ...
}

class SecondDerivedClass extends FirstDerivedClass {
  int y;
  // ...
}

class TypeInferenceAndInheritance {

  // Zwraca obiekt jakiegoś typu MyClass
  static MyClass getObj(int which) {
    switch(which) {
      case 0: return new MyClass();
      case 1: return new FirstDerivedClass();
      default: return new SecondDerivedClass();
  }

  }
  public static void main(String args[]) {

    // Choć metoda getObj() zwraca obiekty różnych typów 
    // należących do hierarchii klasy MyClass, to jednak 
    // została ona zadeklarowana jako metoda zwracająca 
    // obiekt MyClass. W efekcie we wszystkich trzech 
    // przedstawionych tu przypadkach wywnioskowanym typem
    // zmiennej będzie MyClass, niezależnie od tego, że metoda 
    // będzie zwracać obiekty innych typów. W poniższym wierszu
    // wywołanie metody zwraca obiekt MyClass

    var mc = getObj(0);

    // W tym przypadku zwracany jest obiekt FirstDerivedClass
    var mc2 = getObj(1);

    // W tym przypadku zwracany jest obiekt SecondDerivedClass
    var mc3 = getObj(2);

    // Ponieważ wywnioskowanym typem zmiennych mc2 i mc3 będzie
    // MyClass (gdyż jest to typ wyniku zwracanego przez metodę
    // getObj()), żadna z tych zmiennych nie pozwoli na odwołanie 
    // się do pól zdefiniowanych w klasach FirstDerivedClass i
    // SecondDerivedClass
// mc2.x = 10; // Błąd! Klasa MyClass nie dysponuje polem x
// mc3.y = 10; // Błąd! Klasa MyClass nie dysponuje polem y

  }
}