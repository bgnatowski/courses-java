// Demonstruje użycie list rozwijanych

import java.awt.*; 
import java.awt.event.*; 
 
public class ChoiceDemo extends Frame implements ItemListener { 
  Choice os, browser; 
  String msg = ""; 
 
  public ChoiceDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy listę rozwijalną
    os = new Choice(); 
    browser = new Choice(); 
 
    // Dodaje elementy do listy systemów operacyjnych
    os.add("Windows"); 
    os.add("Android"); 
    os.add("Solaris"); 
    os.add("MacOS"); 
 
    // Dodaje elementy do listy przeglądarek
    browser.add("Internet Explorer"); 
    browser.add("Firefox"); 
    browser.add("Chrome"); 
 
    // Dodaje listy rozwijane do okna aplikacji
    add(os); 
    add(browser); 
 
    // Rejestruje obiekt otrzymujący informacje o zdarzeniach typu ItemEvent
    os.addItemListener(this); 
    browser.addItemListener(this); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  public void itemStateChanged(ItemEvent ie) { 
    repaint(); 
  } 
 
  // Wyświetla aktualnie wybrane opcje
  
  public void paint(Graphics g) { 
    msg = "Wybrany system operacyjny: ";
    msg += os.getSelectedItem(); 
    g.drawString(msg, 20, 120); 
    msg = "Wybrana przeglądarka: ";
    msg += browser.getSelectedItem(); 
    g.drawString(msg, 20, 140); 
  } 

  public static void main(String[] args) {
    ChoiceDemo appwin = new ChoiceDemo();

    appwin.setSize(new Dimension(240, 180));
    appwin.setTitle("ChoiceDemo");
    appwin.setVisible(true);
  } 
}
