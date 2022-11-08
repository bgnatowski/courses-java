// Przykład użycia kilku metod is...

class IsDemo {
  public static void main(String args[]) {
    char a[] = {'a', 'b', '5', '?', 'A', ' '};

    for(int i=0; i<a.length; i++) {
      if(Character.isDigit(a[i]))
        System.out.println(a[i] + " jest cyfrą.");
      if(Character.isLetter(a[i]))
        System.out.println(a[i] + " jest literą.");
      if(Character.isWhitespace(a[i]))
        System.out.println(a[i] + " jest znakiem białym.");
      if(Character.isUpperCase(a[i]))
        System.out.println(a[i] + " jest wielką literą.");
      if(Character.isLowerCase(a[i]))
        System.out.println(a[i] + " jest małą literą.");
    }
  }
}
