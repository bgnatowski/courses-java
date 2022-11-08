import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ProstyKlientPogawedekA {
    JTextField wiadomosc;
    PrintWriter pisarz;
    Socket gniazdo;

    public static void main(String[] args){
        new ProstyKlientPogawedekA().doDziela();
    }

    public void doDziela(){
        JFrame ramka = new JFrame("Śmiesznie prosty klient pogawędek");
        JPanel panelGlowny = new JPanel();
        wiadomosc = new JTextField(20);
        JButton przyciskWyslij = new JButton("Wyślij");
        przyciskWyslij.addActionListener(new PrzyciskWyslijListener());
        panelGlowny.add(wiadomosc);
        panelGlowny.add(przyciskWyslij);
        konfigurujKomunikacje();
        ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
        ramka.setSize(400,90);
        ramka.setVisible(true);
    }

    private void konfigurujKomunikacje() {
        try {
            gniazdo = new Socket("127.0.0.1", 5000);
            pisarz = new PrintWriter(gniazdo.getOutputStream());
            System.out.println("obsługa sieci gotowa do użycia");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class PrzyciskWyslijListener implements ActionListener{
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
        }
    }
}
