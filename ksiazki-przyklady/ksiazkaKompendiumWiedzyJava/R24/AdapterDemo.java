// Program przedstawia zastosowanie klas adapterów
import java.awt.*;
import java.awt.event.*;

public class AdapterDemo extends Frame {
  String msg = "";

  public AdapterDemo() {
     addMouseListener(new MyMouseAdapter(this));
     addMouseMotionListener(new MyMouseAdapter(this));
     addWindowListener(new MyWindowAdapter());
  }

  // Wyświetla informacje o myszy
  public void paint(Graphics g) {
    g.drawString(msg, 20, 80);
  }    

  public static void main(String[] args) {
    AdapterDemo appwin = new AdapterDemo();

    appwin.setSize(new Dimension(250, 150));
    appwin.setTitle("AdapterDemo");
    appwin.setVisible(true);
  }
}

// Obsługuje jedynie kliknięcia przycisków myszy i przeciąganie jej wskaźnika
class MyMouseAdapter extends MouseAdapter {
  AdapterDemo adapterDemo;

  public MyMouseAdapter(AdapterDemo adapterDemo) {
    this.adapterDemo = adapterDemo;
  }

  // Obsługuje kliknięcia myszy
  public void mouseClicked(MouseEvent me) {
    adapterDemo.msg = "Kliknięto przycisk myszy";
    adapterDemo.repaint();
  }

  // Obsługuje przeciągnięcia wskaźnika myszy
  public void mouseDragged(MouseEvent me) {
    adapterDemo.msg = "Przeciągnięto wskaźnik myszy";
    adapterDemo.repaint();
  } 
}

// Po kliknięciu przycisku zamykania na ramce okna
// okno zostanie zamknięte, a program — zakończony
class MyWindowAdapter extends WindowAdapter {
  public void windowClosing(WindowEvent we) {
    System.exit(0);
  }
}
