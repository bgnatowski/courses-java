// Przykład użycia komponentu JTextField
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class JTextFieldDemo { 

  public JTextFieldDemo() { 
 
    // Przygotowanie okna
    JFrame jfrm = new JFrame("JTextFieldDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(260, 120); 
 
    // Dodaje pole tekstowe 
    JTextField jtf = new JTextField(15); 
    jfrm.add(jtf); 

    // Dodaje etykietę
    JLabel jlab = new JLabel();
    jfrm.add(jlab);

    // Obsługa zdarzeń
    jtf.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        // Wyświetla tekst po naciśnięciu klawisza ENTER
        jlab.setText(jtf.getText()); 
      } 
    }); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługującym zdarzenia
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JTextFieldDemo(); 
        } 
      } 
    ); 
  }
}
