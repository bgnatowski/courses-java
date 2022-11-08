// Obsługa zdarzenia w programie na bazie biblioteki Swing

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EventDemo {

  JLabel jlab;

  EventDemo() {

    // Tworzy nowy kontener typu JFrame
    JFrame jfrm = new JFrame("Przykład zdarzenia");

    // Wskazuje obiekt FlowLayout jako menedżer układu graficznego
    jfrm.setLayout(new FlowLayout());

    // Określa początkowe wymiary ramki
    jfrm.setSize(220, 90);

    // Kończy program w momencie zamknięcia aplikacji przez użytkownika
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Tworzy dwa przyciski
    JButton jbtnAlpha = new JButton("Alfa");
    JButton jbtnBeta = new JButton("Beta");

    // Dodaje obiekt nasłuchujący do przycisku Alfa
    jbtnAlpha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("Naciśnięto przycisk Alfa.");
      }
    });

    // Dodaje obiekt nasłuchujący do przycisku Beta
    jbtnBeta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("Naciśnięto przycisk Beta.");
      }
    });

    // Dodaje oba przyciski do panelu treści
    jfrm.add(jbtnAlpha);
    jfrm.add(jbtnBeta);

    // Tworzy etykietę tekstową
    jlab = new JLabel("Naciśnij przycisk.");

    // Dodaje etykietę do panelu treści
    jfrm.add(jlab);

    // Wyświetla ramkę
    jfrm.setVisible(true);
  }

  public static void main(String args[]) {
    // Tworzy ramkę w wątku rozdzielającym zdarzenia
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new EventDemo();
      }
    });
  }
}
