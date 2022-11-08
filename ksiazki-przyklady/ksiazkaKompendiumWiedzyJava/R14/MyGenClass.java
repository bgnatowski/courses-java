// Niejednoznaczność powodowana przez znoszenie parametryzacji
// dla metod przeciążonych
class MyGenClass<T, V> {
  T ob1;
  V ob2;

  // ...

  // Te dwie przeciążone metody są niejednoznaczne, więc
  // nie uda się skompilować kodu
  void set(T o) {
    ob1 = o;
  }

  void set(V o) {
    ob2 = o;
  }
}
