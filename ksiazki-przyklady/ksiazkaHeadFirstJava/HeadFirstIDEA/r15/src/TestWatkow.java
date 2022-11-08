import javax.swing.plaf.TableHeaderUI;

public class TestWatkow {
    public static void main(String[] args){
        WatekPierwszy w1 = new WatekPierwszy();
        WatekDrugi w2 = new WatekDrugi();
        Thread pierwszy = new Thread(w1);
        Thread drugi = new Thread(w2);

        pierwszy.start();
        drugi.start();

    }

}

class Sumator {
    private Sumator() {}
    private static Sumator s = new Sumator();
    private int licznik = 0;

    public static Sumator getSumator() {
        return s;
    }

    public int getLicznik() {
        return licznik;
    }

    public void aktualizujLicznik(int wart){
        licznik += wart;
    }

}

class WatekPierwszy implements Runnable {
    Sumator s = Sumator.getSumator();

    @Override
    public void run() {
        try {
            for (int x = 0; x < 98; x++){
                s.aktualizujLicznik(1000);
            }
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Pierwszy - " + s.getLicznik());
    }
}

class WatekDrugi implements Runnable {
    Sumator s = Sumator.getSumator();

    @Override
    public void run() {
        try {
            for (int x = 0; x < 99; x++){
                s.aktualizujLicznik(1);
            }
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Drugi - " + s.getLicznik());
    }
}
