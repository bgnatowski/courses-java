import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KwizGra {
    private JTextArea pytanie;
    private JTextArea odpowiedz;
    private ArrayList<KartaKwizowa> listaKart;
    private KartaKwizowa biezacaKarta;
    private int indeksBiezacejKarty;
    private JFrame ramka;
    private JButton przyciskNastepnaKarta;
    private boolean czyPrezentowanaOdpowiedz;

    public static void main(String[] args){
        KwizGra gra = new KwizGra();
        gra.doRoboty();
    }
    public void doRoboty(){
        // utworzenie i wyswieltenie graficznego interfejsu uzytkownika
        ramka = new JFrame("Kwiz");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelGlowny = new JPanel();
        //panelGlowny.setLayout(new BoxLayout(panelGlowny, BoxLayout.Y_AXIS));
        Font czcionkaDuza = new Font("sansserif", Font.BOLD, 24);

        pytanie = new JTextArea(10,20);
        pytanie.setFont(czcionkaDuza);
        pytanie.setLineWrap(true);
        pytanie.setWrapStyleWord(true);

        JScrollPane przewijanieP = new JScrollPane(pytanie);
        przewijanieP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        przewijanieP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        przyciskNastepnaKarta = new JButton("Pokaż pytanie");
        panelGlowny.add(przewijanieP);
        panelGlowny.add(przyciskNastepnaKarta);
        przyciskNastepnaKarta.addActionListener(new NastepnaKartaListener());

        JMenuBar pasekMenu = new JMenuBar();
        JMenu menuPlik = new JMenu("Plik");
        JMenuItem opcjaOtworz = new JMenuItem("Otwórz zbiór kart");
        opcjaOtworz.addActionListener(new OtworzMenuListener());
        menuPlik.add(opcjaOtworz);
        pasekMenu.add(menuPlik);
        ramka.setJMenuBar(pasekMenu);
        ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
        ramka.setSize(500,460);
        ramka.setVisible(true);
    }

    public class NastepnaKartaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // jesli aktualnie prezentowane jest pytanie, pokazujemy odpowiedz, w przeciwnym razie pokazujemy nastepne pytanie ustawienie flagi okreslajacej, co jest prezentowane
            if(czyPrezentowanaOdpowiedz){
                //pokaz odpowiedz, bo uzytkownik juz widzial pytanie
                pytanie.setText(biezacaKarta.getOdpowiedz());
                przyciskNastepnaKarta.setText("Nastepna karta");
                czyPrezentowanaOdpowiedz = false;
            } else {
                //pokaz nastepne pytanie
                if (indeksBiezacejKarty < listaKart.size()) {
                    pokazNastepnaKarte();
                } else {
                    //nie ma wiecej kart
                    pytanie.setText("To była ostatnia karta");
                    przyciskNastepnaKarta.setEnabled(false);
                }
            }
        }
    }

    public class OtworzMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // wyswietlenie okna dialogowego obslugi plikow
            // umozliwienie uzytkownikowi wybrania pliku, ktory chce otworzyć
            JFileChooser dialogFile = new JFileChooser();
            dialogFile.showOpenDialog(ramka);
            wczytajPlik(dialogFile.getSelectedFile());
        }
    }
    private void wczytajPlik(File file){
        // nalezy stworzyć tablicę ArrayList zawierającą karty odczytujac dane z pliku
        // metoda jest wywolywana przez klase OtworzMenuListener, odczytuje zawartość pliku wiersz po wierszu i dla każdego z nich wywoluje metode tworzKartę(), aby utworzyć kartę(każdy wiersz w pliku zawiera zarowno pytanie jak i odpowiedz, oddzielone od siebie znakiem "/")
        listaKart = new ArrayList<KartaKwizowa>();
        try {
            BufferedReader czytelnik = new BufferedReader(new FileReader(file));
            String wiersz = null;
            while((wiersz = czytelnik.readLine()) != null) {
                tworzKarte(wiersz);
            }
            czytelnik.close();

        } catch (IOException ex){
            System.out.println("Nie udało się otworzyć pliku kart");
            ex.printStackTrace();
        }
        //czas zaczynac
        pokazNastepnaKarte();
    }

    private void tworzKarte(String wierszDanych){
        //wywołana przez metodę wczytajPlik(), pobira wiersze danych z pliku tekstowego i dzieli na dwie części - pyt i odp - na podstawie ktorych tworzy obiekt kartaKwizowa i dodaje go do tablicy kart (tablicaKart) typu ArrayList

        String[] wynik = wierszDanych.split("/");
        KartaKwizowa karta = new KartaKwizowa(wynik[0], wynik[1]);
        listaKart.add(karta);
        System.out.println("utworzono kartę");
    }

    private void pokazNastepnaKarte() {
        biezacaKarta = listaKart.get(indeksBiezacejKarty);
        indeksBiezacejKarty++;
        pytanie.setText(biezacaKarta.getPytanie());
        przyciskNastepnaKarta.setText("Pokaż odpowiedź");
        czyPrezentowanaOdpowiedz = true;
    }
}
