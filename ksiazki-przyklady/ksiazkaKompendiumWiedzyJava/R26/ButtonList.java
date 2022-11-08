// Rozpoznaje obiekty klasy Button
import java.awt.*; 
import java.awt.event.*; 
 
public class ButtonList extends Frame implements ActionListener { 
  String msg = ""; 
  Button bList[] = new Button[3]; 
 
  public ButtonList() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy przyciski
    Button yes = new Button("Tak");
    Button no = new Button("Nie");
    Button maybe = new Button("Niezdecydowany");
 
    // Dodaje przyciski do okna
    bList[0] = (Button) add(yes); 
    bList[1] = (Button) add(no); 
    bList[2] = (Button) add(maybe); 
 
    // Rejestruje obiekty nasłuchujące zdarzeń
    for(int i = 0; i < 3; i++) { 
      bList[i].addActionListener(this); 
    } 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  // Obsługuje zdarzenia kliknięć
  public void actionPerformed(ActionEvent ae) { 
    for(int i = 0; i < 3; i++) { 
      if(ae.getSource() == bList[i]) { 
        msg = "Nacisnąłeś przycisk " + bList[i].getLabel(); 
      } 
    } 
    repaint(); 
  } 
 
  public void paint(Graphics g) { 
     g.drawString(msg, 20, 100); 
  } 

  public static void main(String[] args) {
    ButtonList appwin = new ButtonList();

    appwin.setSize(new Dimension(250, 150));
    appwin.setTitle("ButtonList");
    appwin.setVisible(true);
  } 
}
