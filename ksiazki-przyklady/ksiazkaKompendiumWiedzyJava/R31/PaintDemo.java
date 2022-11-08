// Rysuje odcinki na panelu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Ta klasa rozszerza klasę JPanel; przesłania ona
// metodę paintComponent() wersją rysującą
// losowe odcinki na powierzchni panelu
class PaintPanel extends JPanel {
  Insets ins; // Zawiera obramowanie panelu

  Random rand; // Służy do generowania liczb losowych

  // Konstruuje panel
  PaintPanel() {

    // Umieszcza obramowanie wokół panelu
    setBorder(
      BorderFactory.createLineBorder(Color.RED, 5));
      rand = new Random();
    }

    // Przykrywa metodę paintComponent()
    protected void paintComponent(Graphics g) {
      // Zawsze należy najpierw wywołać metodę nadklasy
      super.paintComponent(g);

      int x, y, x2, y2;

      // Uzyskuje wysokość i szerokość komponentu
      int height = getHeight();
      int width = getWidth();

      // Uzyskuje wymiary obramowania
      ins = getInsets();

      // Rysuje 10 odcinków łączących losowo wygenerowane punkty końcowe
      for(int i=0; i < 10; i++) {
        // Uzyskuje losowe współrzędne wyznaczające
        // punkty końcowe poszczególnych odcinków
        x = rand.nextInt(width-ins.left);
        y = rand.nextInt(height-ins.bottom);
        x2 = rand.nextInt(width-ins.left);
        y2 = rand.nextInt(height-ins.bottom);

        // Rysuje odcinek
        g.drawLine(x, y, x2, y2);
      }
    }
  }

  // Demonstruje rysowanie bezpośrednio na panelu
  class PaintDemo {

    JLabel jlab;
    PaintPanel pp;

    PaintDemo() {

    // Tworzy nowy kontener typu JFrame
    JFrame jfrm = new JFrame("Przykład rysowania");

    // Określa początkowe wymiary ramki
    jfrm.setSize(200, 150);

    // Kończy program w momencie zamknięcia aplikacji przez użytkownika
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Tworzy panel, na którym będą rysowane odcinki
    pp = new PaintPanel();

    // Dodaje panel do panelu treści; ponieważ zastosowano domyślny
    // menedżer układu BorderLayout, wymiary panelu zostaną
    // automatycznie dostosowane do wymiarów środkowego obszaru
    jfrm.add(pp);

    // Wyświetla ramkę
    jfrm.setVisible(true);
  }

  public static void main(String args[]) {

    // Tworzy ramkę w wątku rozdzielającym zdarzenia
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new PaintDemo();
      }
    });
  }
}
