// Instrukcja break jako ucywilizowana wersja instrukcji goto
class Break {
  public static void main(String args[]) {
    boolean t = true;

    first: {
      second: {
        third: {
          System.out.println("Przed break");
          if(t) break second; // Wyjście poza drugi blok
          System.out.println("To się nie wykona");
        }
        System.out.println("To się nie wykona");
      }
      System.out.println("Po drugim bloku");
    }
  }
}
