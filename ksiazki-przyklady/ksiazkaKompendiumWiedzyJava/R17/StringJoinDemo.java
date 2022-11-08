// Prezentacja metody join() zdefiniowanej w klasie String
class StringJoinDemo {
  public static void main(String args[]) {

    String result = String.join(" ", "alpha", "beta", "gamma");
    System.out.println(result);

    result = String.join(", ", "John", "ID#: 569",
                        "e-mail: John@HerbSchildt.com");
    System.out.println(result);
  }
}
