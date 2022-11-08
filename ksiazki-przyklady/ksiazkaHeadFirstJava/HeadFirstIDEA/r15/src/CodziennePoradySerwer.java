import jdk.net.Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CodziennePoradySerwer {
    String[] listaPorad = {"Jedź na rower", "Zjedz obiad", "Używaj mniejszych bitów", "Chodź w dopasowanych spodniach. Nie, te nie sprawiają, że wygladasz grubo.", "Jedno słowo: nieodpowidznie", "Tylko dziś - bądź uczciwy - powiedz swojemu szefowi, co *naprawdę* czujesz", "Jesteś dwulicowa nara. Moze chcesz coś z Avonu?", "Może chcesz się zastanowić nad swoją fryzura."};

    public void doDziela(){
        try {
            ServerSocket gniazdoSrw = new ServerSocket(4242);

            while(true){
                Socket gniazdo = gniazdoSrw.accept();

                PrintWriter pisarz = new PrintWriter(gniazdo.getOutputStream());
                String porada = wybierzPorade();
                pisarz.println(porada);
                System.out.println(porada);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        CodziennePoradySerwer serwer = new CodziennePoradySerwer();
        serwer.doDziela();
    }

    private String wybierzPorade() {
        int random = (int) (Math.random() * listaPorad.length);
        return listaPorad[random];
    }
}
