public class Piosenka implements Comparable<Piosenka>{
    private String tytul;
    private String artysta;
    private String ocena;
    private String bpm;

    Piosenka(String t, String a, String o, String b){
        tytul = t;
        artysta = a;
        ocena = o;
        bpm = b;
    }

    public boolean equals(Object o){
        Piosenka piosenka = (Piosenka) o;
        return getTytul().equals(piosenka.getTytul());
    }

    public int hashCode(){
        return tytul.hashCode();
    }

    public String getTytul(){
        return tytul;
    }

    public String getArtysta(){
        return artysta;
    }

    public String getOcena() {
        return ocena;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString(){
        //String tytulArtysta = tytul + ": " + artysta;
        //return tytulArtysta;
        return tytul;
    }

    @Override
    public int compareTo(Piosenka p) {
        return tytul.compareTo(p.getTytul());
    }
}
