// Demonstruje etykiety
import java.awt.*; 
import java.awt.event.*;
 
public class LabelDemo extends Frame { 
  public LabelDemo() { 

    // Używa menedżera układu FlowLayout
    setLayout(new FlowLayout());

    Label one = new Label("Jeden");
    Label two = new Label("Dwa");
    Label three = new Label("Trzy");
 
    // Dodaje etykiety do okna
    add(one); 
    add(two); 
    add(three); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 

  public static void main(String[] args) {
    LabelDemo appwin = new LabelDemo();

    appwin.setSize(new Dimension(300, 100));
    appwin.setTitle("LabelDemo");
    appwin.setVisible(true);
  } 
}