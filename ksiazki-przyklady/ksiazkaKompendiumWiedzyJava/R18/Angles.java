// Przykład użycia metod toDegrees() i toRadians()
class Angles {
  public static void main(String args[]) {
    double theta = 120.0;
    
    System.out.println(theta + " stopni to " +
                       Math.toRadians(theta) + " radianów.");

    theta = 1.312;
    System.out.println(theta + " radianów to " +
                       Math.toDegrees(theta) + " stopni.");
  }
}
