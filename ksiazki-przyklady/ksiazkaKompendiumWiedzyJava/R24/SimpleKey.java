// Demonstruje technikę obsługi zdarzeń związanych z klawiaturą
import java.awt.*;
import java.awt.event.*;

public class SimpleKey extends Frame
  implements KeyListener {

  String msg = "";
  String keyState = "";

  public SimpleKey() {
    addKeyListener(this);
    addWindowListener(new MyWindowAdapter());
  }

  // Obsługuje wciśnięcie klawisza
  public void keyPressed(KeyEvent ke) {
    keyState = "Klawisz wciśnięty";
    repaint();
  }

  // Obsługuje zwolnienie klawisza
  public void keyReleased(KeyEvent ke) {
    keyState = "Klawisz zwolniony";
    repaint();
  }

  // Obsługuje naciśnięcie (wciśnięcie i zwolnienie) klawisza
  public void keyTyped(KeyEvent ke) {
    msg += ke.getKeyChar();
    repaint();
  }

  // Wyświetla naciśnięte klawisze
  public void paint(Graphics g) {
    g.drawString(msg, 20, 100);
    g.drawString(keyState, 20, 50);
  }
  
  public static void main(String[] args) {
    SimpleKey appwin = new SimpleKey();
    appwin.setSize(new Dimension(200, 150));
    appwin.setTitle("SimpleKey");
    appwin.setVisible(true);
  }  
}

// Po kliknięciu przycisku zamykania na ramce okna
// okno zostanie zamknięte, a program — zakończony
class MyWindowAdapter extends WindowAdapter {
  public void windowClosing(WindowEvent we) {
    System.exit(0);
  }
}
