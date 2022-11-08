// Demonstruje użycie grupy pól wyboru
import java.awt.*; 
import java.awt.event.*; 
 
public class CBGroup extends Frame implements ItemListener { 
  String msg = ""; 
  Checkbox windows, android, solaris, mac; 
  CheckboxGroup cbg; 
 
  public CBGroup() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy grupę pól wyboru
    cbg = new CheckboxGroup(); 

    // Tworzy pola wyboru i dodaje je do grupy
    windows = new Checkbox("Windows", cbg, true); 
    android = new Checkbox("Android", cbg, false); 
    solaris = new Checkbox("Solaris", cbg, false); 
    mac = new Checkbox("MacOS", cbg, false); 
 
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
    msg = "Aktualnie wybrana opcja: ";
    msg += cbg.getSelectedCheckbox().getLabel(); 
    g.drawString(msg, 20, 120); 
  } 

  public static void main(String[] args) {
    CBGroup appwin = new CBGroup();

    appwin.setSize(new Dimension(240, 180));
    appwin.setTitle("CBGroup");
    appwin.setVisible(true);
  } 
}
