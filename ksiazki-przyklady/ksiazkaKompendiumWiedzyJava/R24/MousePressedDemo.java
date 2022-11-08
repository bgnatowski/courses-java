// Ten program NIE używa klasy wewnętrznej
import java.awt.*;
import java.awt.event.*;
 
public class MousePressedDemo extends Frame {
  String msg = "";

  public MousePressedDemo() {
    addMouseListener(new MyMouseAdapter(this));
    addWindowListener(new MyWindowAdapter());
  }

  public void paint(Graphics g) {
    g.drawString(msg, 20, 100);
  }    

  public static void main(String[] args) {
    MousePressedDemo appwin = new MousePressedDemo();

    appwin.setSize(new Dimension(200, 150));
    appwin.setTitle("MousePressedDemo");
    appwin.setVisible(true);
  }
}

class MyMouseAdapter extends MouseAdapter {
  MousePressedDemo mousePressedDemo;

  public MyMouseAdapter(MousePressedDemo mousePressedDemo) {
    this.mousePressedDemo = mousePressedDemo;
  }

  // Obsługuje naciśnięcie klawisza myszy
  public void mousePressed(MouseEvent me) {
    mousePressedDemo.msg = "Naciśnięto klawisz myszy";
    mousePressedDemo.repaint();
  }
}

// Po kliknięciu przycisku zamykania na ramce okna
// okno zostanie zamknięte, a program — zakończony
class MyWindowAdapter extends WindowAdapter {
  public void windowClosing(WindowEvent we) {
    System.exit(0);
  }
}