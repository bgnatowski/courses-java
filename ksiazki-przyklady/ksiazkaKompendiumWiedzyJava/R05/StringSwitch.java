// Przykład użycia łańcucha do sterowania instrukcją switch

class StringSwitch {
  public static void main(String args[]) {

    String str = "dwa";

    switch(str) {
      case "jeden":
        System.out.println("jeden");
        break;
      case "dwa":
        System.out.println("dwa");
        break;
      case "trzy":
        System.out.println("trzy");
        break;
      default:
        System.out.println("brak dopasowania");
        break;
    }
  }
}
