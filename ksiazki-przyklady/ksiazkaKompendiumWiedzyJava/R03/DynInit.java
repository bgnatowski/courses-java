// Przykład inicjalizacji dynamicznej
class DynInit {
    public static void main(String args[]) {
      double a = 3.0, b = 4.0;
      
      // c jest inicjalizowane dynamicznie
      double c = Math.sqrt(a * a + b * b);

      System.out.println("Długość przeciwprostokątnej wynosi " + c);
    }
}
