// Wykorzystanie pętli do-while do przetwarzania menu -- prosty system pomocy
class Menu {
  public static void main(String args[]) 
    throws java.io.IOException {
    char choice;

    do {
      System.out.println("Pomoc na temat:");
      System.out.println("  1. if");
      System.out.println("  2. switch");
      System.out.println("  3. while");
      System.out.println("  4. do-while");
      System.out.println("  5. for\n");
      System.out.println("Wybierz jedną opcję:");
      choice = (char) System.in.read();
    } while( choice < '1' || choice > '5');

    System.out.println("\n");
 
    switch(choice) {
      case '1':
        System.out.println("Instrukcja if:\n");
        System.out.println("if(warunek) instrukcja;");
        System.out.println("else instrukcja;");
        break;
      case '2':
        System.out.println("Instrukcja switch:\n");
        System.out.println("switch(wyrażenie) {");
        System.out.println("  case stała:");
        System.out.println("    sekwencja instrukcji");
        System.out.println("  break;");
        System.out.println("  // ...");
        System.out.println("}");
        break;
      case '3':
        System.out.println("Pętla while:\n");
        System.out.println("while(warunek) instrukcja;");
        break;
      case '4':
        System.out.println("Pętla do-while:\n");
        System.out.println("do {");
        System.out.println("  instrukcja;");
        System.out.println("} while (warunek);");
        break;
      case '5':
        System.out.println("Pętla for:\n");
        System.out.print("for(inicjalizacja; warunek; iteracja)");
        System.out.println(" instrukcja;");
        break;
    }
  }
}
