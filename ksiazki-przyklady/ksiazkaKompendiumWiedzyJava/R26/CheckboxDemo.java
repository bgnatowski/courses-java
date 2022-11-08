// Demonstruje użycie pól wyboru
import java.awt.*; 
import java.awt.event.*; 
 
public class CheckboxDemo extends Frame implements ItemListener { 
  String msg = ""; 
  Checkbox windows, android, solaris, mac; 
 
  public CheckboxDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy pola wyboru
    windows = new Checkbox("Windows", true); 
    android = new Checkbox("Android"); 
    solaris = new Checkbox("Solaris"); 
    mac = new Checkbox("MacOS"); 

    // Dodaje pola wyboru do okna
    add(windows); 
    add(android); 
    add(solaris); 
    add(mac); 
 
    // Dodaje obiekty nasłuchujące zdarzeń
    windows.addItemListener(this); 
    android.addItemListener(this); 
    solaris.addItemListener(this); 
    mac.addItemListener(this); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  public void itemStateChanged(ItemEvent ie) { 
    repaint(); 
  } 
 
  // Wyświetla bieżący stan pól wyboru
  public void paint(Graphics g) { 
    msg = "Bieżący stan: ";
    g.drawString(msg, 20, 120); 
    msg = "  Windows: " + windows.getState();
    g.drawString(msg, 20, 140); 
    msg = "  Android: " + android.getState();
    g.drawString(msg, 20, 160); 
    msg = "  Solaris: " + solaris.getState();
    g.drawString(msg, 20, 180); 
    msg = "  MacOS: " + mac.getState();
    g.drawString(msg, 20, 200); 
  } 

  public static void main(String[] args) {
    CheckboxDemo appwin = new CheckboxDemo();

    appwin.setSize(new Dimension(240, 220));
    appwin.setTitle("CheckboxDemo");
    appwin.setVisible(true);
  } 
}
