// Demonstruje użycie pasków przewijania
import java.awt.*; 
import java.awt.event.*; 
 
public class SBDemo extends Frame 
  implements AdjustmentListener { 

  String msg = ""; 
  Scrollbar vertSB, horzSB; 
 
  public SBDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy pasek przewijania i ustawia jego preferowaną wielkość
    vertSB = new Scrollbar(Scrollbar.VERTICAL, 
                          0, 1, 0, 200); 
    vertSB.setPreferredSize(new Dimension(20, 100));

    horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 
                           0, 1, 0, 100); 
    horzSB.setPreferredSize(new Dimension(100, 20));

    // Dodaje pasek przewijania do okna
    add(vertSB); 
    add(horzSB); 
 
    // Rejestruje obiekt nasłuchujący zdarzeń generowany przez pasek przewijania
    vertSB.addAdjustmentListener(this);
    horzSB.addAdjustmentListener(this);

    // Rejestruje obiekt nasłuchujący zdarzeń generowany przez mysz
    addMouseMotionListener(new MouseAdapter() {
      // Aktualizuje pasek w odpowiedzi na przeciąganie wskaźnika myszy
      public void mouseDragged(MouseEvent me) { 
        int x = me.getX(); 
        int y = me.getY(); 
        vertSB.setValue(y); 
        horzSB.setValue(x); 
        repaint(); 
      } 
    }); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 

  public void adjustmentValueChanged(AdjustmentEvent ae) {
    repaint();
  }

  // Wyświetla bieżące wartości pasków przewijania
  public void paint(Graphics g) { 
     msg = "Pionowy: " + vertSB.getValue(); 
     msg += ",  Poziomy: " + horzSB.getValue(); 
     g.drawString(msg, 20, 160); 
 
     // Wyświetla bieżącą pozycję przeciąganego wskaźnika myszy
     g.drawString("*", horzSB.getValue(), 
                  vertSB.getValue()); 
  } 

  public static void main(String[] args) {
    SBDemo appwin = new SBDemo();

    appwin.setSize(new Dimension(300, 180));
    appwin.setTitle("SBDemo");
    appwin.setVisible(true);
  } 
}
