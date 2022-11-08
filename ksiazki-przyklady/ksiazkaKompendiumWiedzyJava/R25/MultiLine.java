// Demonstruje wielowierszowe dane wyjściowe
import java.awt.event.*;
import java.awt.*;

public class MultiLine extends Frame {
  int curX=20, curY=40; // Bieżące współrzędne

  public MultiLine() {
    Font f = new Font("SansSerif", Font.PLAIN, 12);
    setFont(f);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public void paint(Graphics g) {
    FontMetrics fm = g.getFontMetrics();

    nextLine("To jest pierwszy wiersz.", g);
    nextLine("To jest drugi wiersz.", g);
    sameLine(" Ten tekst jest w tym samym wierszu.", g);
    sameLine(" Ten także.", g);
    nextLine("To jest trzeci wiersz.", g);

    curX = 20; curY = 40; // Zeruje współrzędne w każdej operacji rysowania
  }

  // Przechodzi do następnego wiersza
  void nextLine(String s, Graphics g) {
    FontMetrics fm = g.getFontMetrics();

    curY += fm.getHeight(); // Przejście do następnego wiersza
    curX = 20;
    g.drawString(s, curX, curY);
    curX += fm.stringWidth(s); // Przejście na koniec wiersza
  }

  // Wyświetla tekst w tym samym wierszu
  void sameLine(String s, Graphics g) {
    FontMetrics fm = g.getFontMetrics();

    g.drawString(s, curX, curY);
    curX += fm.stringWidth(s); // Przejście na koniec wiersza
  }

  public static void main(String[] args) {
    MultiLine appwin = new MultiLine();

    appwin.setSize(new Dimension(450, 120));
    appwin.setTitle("MultiLine");
    appwin.setVisible(true);
  }
} 
