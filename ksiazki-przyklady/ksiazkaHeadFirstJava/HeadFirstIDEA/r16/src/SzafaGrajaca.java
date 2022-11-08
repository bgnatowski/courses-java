import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SzafaGrajaca {
    private ArrayList<String> listaPiosenek = new ArrayList<String>();

    public static void main(String[] args){
        new SzafaGrajaca().doRoboty();
    }

    private void doRoboty(){
        pobierzPiosenke();
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
        listaPiosenek.add(elementy[0]);
    }
}
