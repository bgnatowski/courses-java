// Prezentacja zastosowania klas JLabel i ImageIcon
import java.awt.*; 
import javax.swing.*; 
 
public class JLabelDemo { 
 
  public JLabelDemo() { 

    // Tworzy obiekt JFrame
    JFrame jfrm = new JFrame("JLabelDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(260, 210);

    // Tworzy ikonę
    ImageIcon ii = new ImageIcon("hourglass.png"); 
 
    // Tworzy etykietę
    JLabel jl = new JLabel("Klepsydra", ii, JLabel.CENTER); 
 
    // Dodaje etykietę do panelu treści
    jfrm.add(jl); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługującym zdarzenia
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JLabelDemo(); 
        } 
      } 
    ); 
  } 
}
  