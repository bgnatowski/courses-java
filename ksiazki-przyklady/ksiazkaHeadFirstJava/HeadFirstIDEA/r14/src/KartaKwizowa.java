public class KartaKwizowa {
    private String pytanie;
    private String odpowiedz;

    KartaKwizowa(String p, String o){
        pytanie = p;
        odpowiedz = o;
    }

    public String getPytanie(){
        return pytanie;
    }

    public String getOdpowiedz(){
        return odpowiedz;
    }
}
