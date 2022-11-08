// Demonstruje technikę obsługi zdarzeń związanych z myszą
import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame
  implements MouseListener, MouseMotionListener {

  String msg = "";
  int mouseX = 0, mouseY = 0; // Współrzędne wskaźnika myszy

  public MouseEventsDemo() {
     addMouseListener(this);
     addMouseMotionListener(this);
     addWindowListener(new MyWindowAdapter());
  }

  // Obsługuje kliknięcie myszy
  public void mouseClicked(MouseEvent me) {
    // Zapisuje współrzędne
    msg = msg + " -- kliknięto przycisk myszy";
    repaint();
  }

  // Obsługuje wejście kursora myszy w obszar komponentu
  public void mouseEntered(MouseEvent me) {
    mouseX = 100;
    mouseY = 100;
    msg = "Wskaźnik myszy w obszarze programu.";
    repaint();
  }

  // Obsługuje wyjście kursora myszy poza obszar komponentu
  public void mouseExited(MouseEvent me) {
    mouseX = 100;
    mouseY = 100;
    msg = "Wskaźnik myszy poza obszarem programu.";
    repaint();
  }

  // Obsługuje naciśnięcie przycisku myszy
  public void mousePressed(MouseEvent me) {
    // Zapisuje współrzędne
    mouseX = me.getX();
    mouseY = me.getY();
    msg = "Wciśnięty";
    repaint();
  }

  // Obsługuje zwolnienie przycisku myszy
  public void mouseReleased(MouseEvent me) {
    // Zapisuje współrzędne
    mouseX = me.getX();
    mouseY = me.getY();
    msg = "Zwolniony";
    repaint();
  }

  // Obsługuje przeciąganie wskaźnika myszy
  public void mouseDragged(MouseEvent me) {
    // Zapisuje współrzędne
    mouseX = me.getX();
    mouseY = me.getY();
    msg = "*" + " współrzędne myszy: " + mouseX + ", " + mouseY;
    repaint();
  }

  // Obsługuje przemieszczanie się wskaźnika myszy
  public void mouseMoved(MouseEvent me) {
    msg = "Przesuwanie wskaźnika myszy w punkcie " + me.getX() + ", " + me.getY();
  }

  // Wyświetla łańcuch msg w punkcie (x, y) okna apletu
  public void paint(Graphics g) {
    g.drawString(msg, mouseX, mouseY);
  }    

  public static void main(String[] args) {
    MouseEventsDemo appwin = new MouseEventsDemo();

    appwin.setSize(new Dimension(300, 300));
    appwin.setTitle("MouseEventsDemo");
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
