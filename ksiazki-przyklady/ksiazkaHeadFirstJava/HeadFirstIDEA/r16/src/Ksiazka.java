public class Ksiazka implements Comparable<Ksiazka> {
    String tytul;

    public Ksiazka(String t){
        tytul = t;
    }

    @Override
    public int compareTo(Ksiazka o) {
        return tytul.compareTo(o.tytul);
    }
}
