// Demonstruje użycie pól tekstowych
import java.awt.*; 
import java.awt.event.*; 
 
public class TextFieldDemo extends Frame 
  implements ActionListener { 
 
  TextField name, pass; 
 
  public TextFieldDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    // Tworzy kontrolki
    Label namep = new Label("Nazwisko: ", Label.RIGHT);
    Label passp = new Label("Hasło: ", Label.RIGHT);
    name = new TextField(12); 
    pass = new TextField(8); 
    pass.setEchoChar('?'); 
 
    // Dodaje kontrolki do okna
    add(namep); 
    add(name); 
    add(passp); 
    add(pass); 
 
    // Dodaje obiekty nasłuchujące zdarzeń ActionEvent
    name.addActionListener(this); 
    pass.addActionListener(this); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  // Użytkownik nacisnął klawisz Enter.
  public void actionPerformed(ActionEvent ae) { 
    repaint(); 
  } 
 
  public void paint(Graphics g) { 
     g.drawString("Nazwisko: " + name.getText(), 20, 100); 
     g.drawString("Zaznaczony tekst w polu nazwiska: " 
                  + name.getSelectedText(), 20, 120); 
     g.drawString("Hasło: " + pass.getText(), 20, 140); 
  } 
  
  public static void main(String[] args) {
    TextFieldDemo appwin = new TextFieldDemo();

    appwin.setSize(new Dimension(380, 180));
    appwin.setTitle("TextFieldDemo");
    appwin.setVisible(true);
  } 
}
