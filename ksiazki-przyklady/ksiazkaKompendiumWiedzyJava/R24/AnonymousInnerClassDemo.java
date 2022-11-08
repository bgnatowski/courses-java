// Przykład zastosowania anonimowej klasy wewnętrznej
import java.awt.*;
import java.awt.event.*;
 
public class AnonymousInnerClassDemo extends Frame {
  String msg = "";

  public AnonymousInnerClassDemo() {

    // Anonimowa klasa wewnętrzna służąca do obsługi 
    // zdarzeń naciśnięcia przycisku myszy
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        msg = "Naciśnięto przycisk myszy";
        repaint();
      }
    });


    // Anonimowa klasa wewnętrzna służąca do obsługi zdarzeń zamykania okna
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public void paint(Graphics g) {
    g.drawString(msg, 20, 80);
  }    

  public static void main(String[] args) {
    AnonymousInnerClassDemo appwin =
                  new AnonymousInnerClassDemo();

    appwin.setSize(new Dimension(200, 150));
    appwin.setTitle("AnonymousInnerClassDemo");
    appwin.setVisible(true);
  }
}
