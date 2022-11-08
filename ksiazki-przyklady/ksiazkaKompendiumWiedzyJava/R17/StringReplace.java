// Zastępowanie podłańcucha
class StringReplace {
  public static void main(String args[]) {
    String org = "To jest test. To też jest test.";
    String search = "jest";
    String sub = "był";
    String result = "";
    int i;

    do { // Zastąpienie wszystkich pasujących podłańcuchów
      System.out.println(org);
      i = org.indexOf(search);
      if(i != -1) {
        result = org.substring(0, i);
        result = result + sub;
        result = result + org.substring(i + search.length());
        org = result;
      }
    } while(i != -1);

  }
}
