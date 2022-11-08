import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.zip.ZipEntry;

public class SzafaGrajaca6 {
    private ArrayList<Piosenka> listaPiosenek = new ArrayList<Piosenka>();

    public static void main(String[] args){
        new SzafaGrajaca6().doRoboty();
    }

    private class ArtystaCompare implements Comparator<Piosenka> {

        @Override
        public int compare(Piosenka o1, Piosenka o2) {
            return o1.getArtysta().compareTo(o2.getArtysta());
        }
    }

    private void doRoboty(){
        pobierzPiosenke();
        System.out.println(listaPiosenek);
        Collections.sort(listaPiosenek);
        System.out.println(listaPiosenek);

//        ArtystaCompare komparator = new ArtystaCompare();
//        Collections.sort(listaPiosenek, komparator);
//        System.out.println(listaPiosenek);

        HashSet<Piosenka> zbiorPiosenek = new HashSet<Piosenka>();
        zbiorPiosenek.addAll(listaPiosenek);
        System.out.println(zbiorPiosenek);

    }

    private void pobierzPiosenke(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("PelnaListaPiosenek.txt")));
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
