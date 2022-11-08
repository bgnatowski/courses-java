import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KartaKwizowaEdytor {
    private JTextArea pytanie;
    private JTextArea odpowiedz;
    private ArrayList<KartaKwizowa> listaKart;
    private JFrame ramka;

    public static void main(String[] args){
        KartaKwizowaEdytor edytor = new KartaKwizowaEdytor();
        edytor.doDziela();
    }

    public void doDziela(){
        //stworzenie i wyswietlenie graficznego interfejsu użytkownika
        ramka = new JFrame("Edytor kart kwizowych");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelGlowny = new JPanel();
        Font czcionkaDuza = new Font("sansserif", Font.BOLD, 24);
        pytanie = new JTextArea(6,20);
        pytanie.setLineWrap(true);
        pytanie.setWrapStyleWord(true);
        pytanie.setFont(czcionkaDuza);

        JScrollPane przewijaniePyt = new JScrollPane(pytanie);
        przewijaniePyt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        przewijaniePyt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        odpowiedz = new JTextArea(6,20);
        odpowiedz.setLineWrap(true);
        odpowiedz.setWrapStyleWord(true);
        odpowiedz.setFont(czcionkaDuza);

        JScrollPane przewijanieOdp = new JScrollPane(odpowiedz);
        przewijanieOdp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        przewijanieOdp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton przyciskNastepna = new JButton("Nastepna karta");

        listaKart = new ArrayList<KartaKwizowa>();

        JLabel etykietaPyt = new JLabel("Pytanie:");
        JLabel etykietaOdp = new JLabel("Odpowiedź:");

        panelGlowny.add(etykietaPyt);
        panelGlowny.add(przewijaniePyt);
        panelGlowny.add(etykietaOdp);
        panelGlowny.add(przewijanieOdp);
        panelGlowny.add(przyciskNastepna);
        przyciskNastepna.addActionListener(new NastepnaKartaListener());

        JMenuBar menu = new JMenuBar();
        JMenu menuPlik = new JMenu("Plik");
        JMenuItem opcjaNowa = new JMenuItem("Nowy");
        JMenuItem opcjaZapisz = new JMenuItem("Zapisz");

        opcjaNowa.addActionListener(new NowyMenuListener());
        opcjaZapisz.addActionListener(new ZapiszMenuListener());

        menuPlik.add(opcjaNowa);
        menuPlik.add(opcjaZapisz);
        menu.add(menuPlik);
        ramka.setJMenuBar(menu);
        ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
        ramka.setSize(500,600);
        ramka.setVisible(true);

    }

    public class NastepnaKartaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //dodanie biezacej karteczki do listy i wyczyszczenie wielowierszowych pol tekstowych
            KartaKwizowa karta = new KartaKwizowa(pytanie.getText(), odpowiedz.getText());
            listaKart.add(karta);
            czyscKarte();
        }
    }

    public class ZapiszMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // wyswietlenie okna dialogowego oblugi plików, użytkownik moze podać nazwę pliku i zapisać w nim zbiór karteczek
            KartaKwizowa karta = new KartaKwizowa(pytanie.getText(), odpowiedz.getText());
            listaKart.add(karta);

            JFileChooser plikDanych = new JFileChooser();
            plikDanych.showSaveDialog(ramka);
            zapiszPlik(plikDanych.getSelectedFile());
        }
    }

    public class NowyMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // wyczyszczenie listy karteczek oraz wielowierszowych pól tekstowych
            listaKart.clear();
            czyscKarte();
        }
    }

    public void zapiszPlik (File plik){
        // odczytanie każdego elementu listy karteczek i zapisanie w pliku tekstowym w sposób pozwalający na jego późniejsze odczytanie(czyli z jednoznacznymi separatorami pomiędzy poszczególnymi elementami pliku
        try {
            BufferedWriter pisarz = new BufferedWriter(new FileWriter(plik));

            for(KartaKwizowa karta:listaKart){
                pisarz.write(karta.getPytanie() + "/");
                pisarz.write(karta.getOdpowiedz() + "\n");
            }
            pisarz.close();
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku kart!");
            ex.printStackTrace();
        }
    }

    public void czyscKarte(){
        //  czysci aktualne karty
        pytanie.setText("");
        odpowiedz.setText("");
        pytanie.requestFocus();
    }
}
