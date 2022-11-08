// Prosta aplikacja na bazie biblioteki Swing
import javax.swing.*;

class SwingDemo {

  SwingDemo() {

    // Tworzy nowy kontener typu JFrame
    JFrame jfrm = new JFrame("Prosta aplikacja na bazie biblioteki Swing");

    // Określa początkowe wymiary ramki
    jfrm.setSize(275, 100);

    // Kończy program w momencie zamknięcia aplikacji przez użytkownika
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Tworzy etykietę tekstową
    JLabel jlab = new JLabel("Swing to rozbudowane interfejsy GUI.");

    // Dodaje etykietę do panelu treści
    jfrm.add(jlab);

    // Wyświetla ramkę
    jfrm.setVisible(true);
  }

  public static void main(String args[]) {
    // Tworzy ramkę w wątku rozdzielającym zdarzenia
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingDemo();
      }
    });
  }
}
