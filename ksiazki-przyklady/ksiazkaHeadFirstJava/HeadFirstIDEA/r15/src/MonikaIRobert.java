import java.time.temporal.Temporal;

class KontoBankowe {
    private int stan = 100;

    public int getStan(){
        return stan;
    }

    public void pobierz(int kwota) {
        stan -= kwota;
    }
}

public class MonikaIRobert implements Runnable {
    private KontoBankowe konto = new KontoBankowe();
    private int monikiHajs;
    private int robertaHajs;

    public static void main(String[] args){
        Runnable zadanie = new MonikaIRobert();
        Thread watek1 = new Thread(zadanie);
        Thread watek2 = new Thread(zadanie);

        watek1.setName("Robert");
        watek2.setName("Monika");
        watek1.start();
        watek2.start();
    }
    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            pobierzGotowke(10);
            if(konto.getStan() < 0){
                System.out.println("Przekroczenie limitu");
            }
        }
        System.out.println("Stan konta = " + konto.getStan());
    }

    private synchronized void pobierzGotowke(int kwota){
        if(konto.getStan() >= kwota) {
            System.out.println(Thread.currentThread().getName() + " ma zamiar pobrać gotówkę.");
            try {
                System.out.println("Wątek " + Thread.currentThread().getName() + " zaraz zostanie uśpiony.");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Wątek " + Thread.currentThread().getName() + " obudził się.");
            konto.pobierz(kwota);
            if(Thread.currentThread().getName().equals("Monika")){
                monikiHajs += kwota;
            } else {
                robertaHajs += kwota;
            }
            System.out.println("Wątek " + Thread.currentThread().getName() + " zakończył operację.");
            System.out.println("MonikiHajs = " + monikiHajs + ", RobertaHajs = " + robertaHajs);
        } else {
            System.out.println("Przykro mi, brak środków dla wątku " + Thread.currentThread().getName());
        }
    }
}
