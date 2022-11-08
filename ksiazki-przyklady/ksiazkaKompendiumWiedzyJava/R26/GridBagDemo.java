// Demonstruje użycie menedżera układu GridBagLayout
import java.awt.*; 
import java.awt.event.*; 
 
public class GridBagDemo extends Frame 
  implements ItemListener { 
 
  String msg = ""; 
  Checkbox windows, android, solaris, mac; 
 
  public GridBagDemo() { 

    // Wybiera menedżer układu GridBagLayout
    GridBagLayout gbag = new GridBagLayout(); 
    GridBagConstraints gbc = new GridBagConstraints(); 
    setLayout(gbag); 
 
    // Definiuje pola wyboru
    windows = new Checkbox("Windows ", true); 
    android = new Checkbox("Android"); 
    solaris = new Checkbox("Solaris"); 
    mac = new Checkbox("MacOS"); 
 
    // Definiuje zestaw siatek
 
    // Używa domyślnej wagi wiersza, 0, dla pierwszego wiersza siatki
    gbc.weightx = 1.0;  // Stosuje wagę kolumny równą 1
    gbc.ipadx = 200; // Dopełnia kolumnę, stosując 200 jednostek
    gbc.insets = new Insets(0, 6, 0, 0); // Odsuwa zawartość od lewej krawędzi
 
    gbc.anchor = GridBagConstraints.NORTHEAST; 
 
    gbc.gridwidth = GridBagConstraints.RELATIVE; 
    gbag.setConstraints(windows, gbc); 
 
    gbc.gridwidth = GridBagConstraints.REMAINDER; 
    gbag.setConstraints(android, gbc); 
 
    // Nadaje drugiemu wierszowi wagę równą 1
    gbc.weighty = 1.0; 
 
    gbc.gridwidth = GridBagConstraints.RELATIVE; 
    gbag.setConstraints(solaris, gbc); 
 
    gbc.gridwidth = GridBagConstraints.REMAINDER; 
    gbag.setConstraints(mac, gbc); 
 
    // Dodaje komponenty
    add(windows); 
    add(android); 
    add(solaris); 
    add(mac); 
 
    // Rejestruje obiekty nasłuchujące zdarzeń
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
 
  // W przypadku zmiany stanu pola tekstowego ponownie rysuje okno
  public void itemStateChanged(ItemEvent ie) { 
    repaint(); 
  } 
 
  // Wyświetla bieżący stan pól wyboru
  public void paint(Graphics g) { 
    msg = "Bieżący stan: "; 
    g.drawString(msg, 20, 100); 
    msg = "  Windows: " + windows.getState(); 
    g.drawString(msg, 30, 120); 
    msg = "  Android: " + android.getState(); 
    g.drawString(msg, 30, 140); 
    msg = "  Solaris: " + solaris.getState(); 
    g.drawString(msg, 30, 160); 
    msg = "  Mac: " + mac.getState(); 
    g.drawString(msg, 30, 180); 
  } 

  public static void main(String[] args) {
    GridBagDemo appwin = new GridBagDemo();

    appwin.setSize(new Dimension(250, 200));
    appwin.setTitle("GridBagDemo");
    appwin.setVisible(true);
  } 
}
