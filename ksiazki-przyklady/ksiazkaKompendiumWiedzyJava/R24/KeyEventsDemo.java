// Demonstruje kilka wirtualnych kodów klawiszy
import java.awt.*;
import java.awt.event.*;

public class KeyEventsDemo extends Frame
  implements KeyListener {

  String msg = "";
  String keyState = "";

  public KeyEventsDemo() {
    addKeyListener(this);
    addWindowListener(new MyWindowAdapter());
  }

  // Obsługuje naciśnięcie klawisza
  public void keyPressed(KeyEvent ke) {
    keyState = "Klawisz wciśnięty";

    int key = ke.getKeyCode(); 
    switch(key) {
      case KeyEvent.VK_F1:
        msg += "<F1>";
        break;
      case KeyEvent.VK_F2:
        msg += "<F2>";
        break;
      case KeyEvent.VK_F3:
        msg += "<F3>";
        break;
      case KeyEvent.VK_PAGE_DOWN:
        msg += "<PgDn>";
        break;
      case KeyEvent.VK_PAGE_UP:
        msg += "<PgUp>";
        break;
      case KeyEvent.VK_LEFT:
        msg += "<Strzałka w lewo>";
        break;
      case KeyEvent.VK_RIGHT:
        msg += "<Strzałka w prawo>";
        break;
    }

    repaint();
  }

  // Obsługuje zwolnienie klawisza
  public void keyReleased(KeyEvent ke) {
    keyState = "Klawisz zwolniony";
    repaint();
  }

  // Obsługuje naciśnięcie klawisza
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
    KeyEventsDemo appwin = new KeyEventsDemo();

    appwin.setSize(new Dimension(200, 150));
    appwin.setTitle("KeyEventsDemo");
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
