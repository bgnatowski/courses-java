public class Solution {
    public static void main(String[] args) {
        System.out.println(konwertujCelsjuszaNaFahrenheita(41));
    }

    public static double konwertujCelsjuszaNaFahrenheita(int celsjusz) {
        //tutaj wpisz swój kod
        double fahrenheit = celsjusz/(5.0/9)  + 32;
        return fahrenheit;
    }
}