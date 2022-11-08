import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class SzafaGrajaca3 {
    private ArrayList<Piosenka> listaPiosenek = new ArrayList<Piosenka>();

    public static void main(String[] args){
        new SzafaGrajaca3().doRoboty();
    }

    private void doRoboty(){
        pobierzPiosenke();
        System.out.println(listaPiosenek);
        Collections.sort(listaPiosenek);
        System.out.println(listaPiosenek);
    }
    private void pobierzPiosenke(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("ListaPiosenek.txt")));
            String wiersz = null;
            while ((wiersz = reader.readLine()) != null){
                dodajPiosenke(wiersz);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void dodajPiosenke(String wierszDoAnalizy) {
        String[] elementy = wierszDoAnalizy.split("/");
        Piosenka nastepnaPiosenka = new Piosenka(elementy[0], elementy[1], elementy[2], elementy[3]);
        listaPiosenek.add(nastepnaPiosenka);
    }
}
