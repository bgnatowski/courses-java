// Ciało pętli może być puste
class NoBody {
  public static void main(String args[]) {
    int i, j;

    i = 100;
    j = 200;

    // Znajduje środek między i oraz j
    while(++i < --j) ; // Brak ciała pętli

    System.out.println("Środek to wartość " + i);
  }
}
