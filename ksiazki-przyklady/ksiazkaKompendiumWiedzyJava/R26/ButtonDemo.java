// Demonstruje użycie przycisków
import java.awt.*; 
import java.awt.event.*; 
 
public class ButtonDemo extends Frame implements ActionListener { 
  String msg = ""; 
  Button yes, no, maybe; 
 
  public ButtonDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy przyciski
    yes = new Button("Tak");
    no = new Button("Nie");
    maybe = new Button("Niezdecydowany");
 
    // Dodaje przyciski do okna
    add(yes); 
    add(no); 
    add(maybe); 
 
    // Dodaje obiekty nasłuchujące zdarzeń
    yes.addActionListener(this); 
    no.addActionListener(this); 
    maybe.addActionListener(this); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 

  // Obsługuje kliknięcia przycisków
  public void actionPerformed(ActionEvent ae) { 
    String str = ae.getActionCommand(); 
    if(str.equals("Tak")) {
      msg = "Nacisnąłeś przycisk Tak.";
    }
    else if(str.equals("Nie")) {
      msg = "Nacisnąłeś przycisk Nie.";
    }
    else {
      msg = "Nacisnąłeś przycisk Niezdecydowany.";
    }
 
    repaint(); 
  } 
 
  public void paint(Graphics g) { 
     g.drawString(msg, 20, 100); 
  } 

  public static void main(String[] args) {
    ButtonDemo appwin = new ButtonDemo();

    appwin.setSize(new Dimension(250, 150));
    appwin.setTitle("ButtonDemo");
    appwin.setVisible(true);
  } 
}
