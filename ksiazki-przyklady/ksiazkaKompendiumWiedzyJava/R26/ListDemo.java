// Demonstruje użycie list
import java.awt.*; 
import java.awt.event.*; 
 
public class ListDemo extends Frame implements ActionListener { 
  List os, browser; 
  String msg = ""; 
 
  public ListDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy listę wielokrotnego wyboru
    os = new List(4, true); 

    // Tworzy listę jednokrotnego wyboru
    browser = new List(4); 
 
    // Dodaje elementy do listy systemów operacyjnych
    os.add("Windows"); 
    os.add("Android"); 
    os.add("Solaris"); 
    os.add("MacOS"); 
 
    // Dodaje elementy do listy przeglądarek
    browser.add("Internet Explorer"); 
    browser.add("Firefox"); 
    browser.add("Chrome"); 
 
    // Zaznacza początkowo wybrane opcje list
    browser.select(1); 
    os.select(0);
 
    // Dodaje listy do okna
    add(os); 
    add(browser); 
 
    // Rejestruje obiekt nasłuchujący zdarzeń ActionEvent
    os.addActionListener(this); 
    browser.addActionListener(this); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  public void actionPerformed(ActionEvent ae) { 
    repaint(); 
  } 
 
  // Wyświetla aktualnie wybrane opcje
  public void paint(Graphics g) { 
    int idx[]; 
 
    msg = "Wybrany system operacyjny: ";
    idx = os.getSelectedIndexes(); 
    for(int i=0; i<idx.length; i++) 
      msg += os.getItem(idx[i]) + "  "; 
    g.drawString(msg, 6, 120); 
    msg = "Wybrana przeglądarka: ";
    msg += browser.getSelectedItem(); 
    g.drawString(msg, 6, 140); 
  } 

  public static void main(String[] args) {
    ListDemo appwin = new ListDemo();

    appwin.setSize(new Dimension(300, 180));
    appwin.setTitle("ListDemo");
    appwin.setVisible(true);
  } 
}
