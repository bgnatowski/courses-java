class MojeZadanie implements Runnable {
    @Override
    public void run() {

        doDziela();
    }

    public void doDziela(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        kolejnaRobota();
    }

    public void kolejnaRobota(){
        System.out.println("Wierzchołek stosu");
    }
}

class WatkiTester {
    public static void main(String[] args){
        Runnable zadanieWyjatku = new MojeZadanie();
        Thread mojWatek = new Thread(zadanieWyjatku);

        mojWatek.start();


        System.out.println("Z powrotem w metodzie main()");
    }
}