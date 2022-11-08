import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ProstyKlientPogawedek {
    private JTextArea odebraneWiadomosci;
    private JTextField wiadomosc;
    private BufferedReader czytelnik;
    private PrintWriter pisarz;
    private Socket gniazdo;
    private JFrame ramka;
    private JPanel panelGlowny;
    private Font czcionka;

    public static void main(String[] args) {
        ProstyKlientPogawedek klient = new ProstyKlientPogawedek();
        klient.doDziela();
    }

    public void doDziela(){
        ramka = new JFrame("Śmiesznie prosty klient pogawędek");
        panelGlowny = new JPanel();

        czcionka = new Font("sansserif", Font.ROMAN_BASELINE, 15);

        odebraneWiadomosci = new JTextArea(15,35);
        odebraneWiadomosci.setFont(czcionka);
        odebraneWiadomosci.setForeground(Color.BLACK);
        odebraneWiadomosci.setBackground(Color.WHITE);
        odebraneWiadomosci.setLineWrap(true);
        odebraneWiadomosci.setWrapStyleWord(true);
        odebraneWiadomosci.setEnabled(false);

        JScrollPane przewijanieOdebranych = new JScrollPane(odebraneWiadomosci);
        przewijanieOdebranych.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        przewijanieOdebranych.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        przewijanieOdebranych.setForeground(Color.BLACK);

        wiadomosc = new JTextField(20);

        JButton przyciskWyslij = new JButton("Wyślij");
        przyciskWyslij.addActionListener(new PrzyciskWyslijListener());

        panelGlowny.add(przewijanieOdebranych);
        panelGlowny.add(wiadomosc);
        panelGlowny.add(przyciskWyslij);
        konfigurujKomunikacje();

        Thread watekOdbiorcy = new Thread(new OdbiorcaKomunikatow());
        watekOdbiorcy.start();

        ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
        ramka.setSize(500,400);
        ramka.setVisible(true);
    }

    private void konfigurujKomunikacje() {
        try {
            gniazdo = new Socket("127.0.0.1", 5000);
            InputStreamReader czytelnikStrm = new InputStreamReader(gniazdo.getInputStream());
            czytelnik = new BufferedReader(czytelnikStrm);
            pisarz = new PrintWriter(gniazdo.getOutputStream());
            System.out.println("obsługa sieci gotowa do użycia");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class PrzyciskWyslijListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pisarz.println(wiadomosc.getText());
                pisarz.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            wiadomosc.setText("");
            wiadomosc.requestFocus();
            ramka.repaint();

        }
    }

    public class OdbiorcaKomunikatow implements Runnable {
        @Override
        public void run() {
            String wiadom;
            try {
                while((wiadom = czytelnik.readLine()) != null ){
                    System.out.println("Odczytano " + wiadom);
                    odebraneWiadomosci.append(wiadom + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

