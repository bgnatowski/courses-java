// Ten program się nie skompiluje
class ScopeErr {
   public static void main(String args[]) {
     int bar = 1;
     {              // Tworzy nowy zasięg
       int bar = 2; // Błąd kompilacji -- zmienna bar jest już zadeklarowana!
     }
   }
}
