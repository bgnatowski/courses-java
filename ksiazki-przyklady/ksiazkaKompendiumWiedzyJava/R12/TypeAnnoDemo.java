// Prezentacja kilku adnotacji typów 
import java.lang.annotation.*;  
import java.lang.reflect.*;  
 
// Adnotacja znacznikowa, którą można dodawać do typów
@Target(ElementType.TYPE_USE) 
@interface TypeAnno { } 
 
// Inna adnotacja znacznikowa, którą można dodawać do typów 
@Target(ElementType.TYPE_USE) 
@interface NotZeroLen {  
}  
 
// Jeszcze inna adnotacja znacznikowa, którą można dodawać
// do typów
@Target( ElementType.TYPE_USE ) 
@interface Unique { } 
 
// Adnotacja sparametryzowana, którą można dodawać do typów
@Target(ElementType.TYPE_USE) 
@interface MaxLen {  
  int value(); 
}  
 
// Adnotacja, którą można dodawać do parametru typu
@Target(ElementType.TYPE_PARAMETER) 
@interface What {  
  String description();  
}  
 
// Adnotacja, którą można dodawać do deklaracji pola
@Target(ElementType.FIELD) 
@interface EmptyOK { } 
 
// Adnotacja, którą można dodawać do deklaracji metody
@Target(ElementType.METHOD) 
@interface Recommended { } 
 
 
// Zastosowanie adnotacji dla parametru typu  
class TypeAnnoDemo<@What(description = "Ogólny typ danych") T> {  
 
  // Zastosowanie adnotacji typu dla konstruktora
  public @Unique TypeAnnoDemo() {}  
  
  // Adnotacja typu (w tym przypadku typu String), a nie pola
  @TypeAnno String str; 
 
  // A to jest adnotacja pola test
  @EmptyOK String test; 
 
  // Zastosowanie adnotacji typu dla this (odbiorcy)
  public int f(@TypeAnno TypeAnnoDemo<T> this, int x) { 
    return 10; 
  }   
 
  // Adnotacja dodana do typu wyniku zwracanego przez metodę
  public @TypeAnno Integer f2(int j, int k) { 
    return j+k; 
  } 
 
  // Adnotacja dodana do deklaracji metody
  public @Recommended Integer f3(String str) { 
    return str.length() / 2; 
  } 
 
  // Zastosowanie adnotacji typu w klauzuli throws
  public void f4() throws @TypeAnno NullPointerException { 
    // ... 
  } 
 
  // Adnotacje zastosowane do różnych poziomów tablicy
  String @MaxLen(10) [] @NotZeroLen [] w; 
 
  // Adnotacja zastosowana dla typu elementów tablicy
  @TypeAnno Integer[] vec; 
 
  public static void myMeth(int i) {  
 
    // Zastosowanie adnotacji typu dla argumentu typu
    TypeAnnoDemo<@TypeAnno Integer> ob = 
                             new TypeAnnoDemo<@TypeAnno Integer>();  
 
    // Zastosowanie adnotacji typu dla new
    @Unique TypeAnnoDemo<Integer> ob2 = new @Unique TypeAnnoDemo<Integer>(); 
 
    Object x = Integer.valueOf(10); 
    Integer y; 
 
    // Zastosowanie adnotacji typu dla rzutowania
    y = (@TypeAnno Integer) x; 
  } 
  
  public static void main(String args[]) {  
    myMeth(10);  
  }  
 
  // Zastosowanie adnotacji typu w deklaracji klasy
  class SomeClass extends @TypeAnno TypeAnnoDemo<Boolean> {} 
}
