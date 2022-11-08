// Konkatenacja zapobiega konieczności tworzenia bardzo długich wierszy tekstu
class ConCat {
  public static void main(String args[]) {
    String longStr = "To byłby bardzo " +
      "długi wiersz, gdyby miał zostać napisany " +
      "w całości. Można temu zapobiec, stosując " +
      "konkatenację łańcuchów.";

    System.out.println(longStr);
  }
}
