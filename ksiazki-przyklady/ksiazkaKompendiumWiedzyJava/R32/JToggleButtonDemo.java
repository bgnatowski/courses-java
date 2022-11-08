// Przykład użycia klasy JToggleButton
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
 
public class JToggleButtonDemo { 
 
  public JToggleButtonDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JToggleButtonDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(200, 100); 
 
    // Tworzy etykietę
    JLabel jlab = new JLabel("Przycisk jest wyłączony");  
 
    // Tworzy przycisk JToggleButton
    JToggleButton jtbn =  new JToggleButton("Włączony/wyłączony"); 
 
    // Dodaje obiekt nasłuchujący zdarzeń typu ItemEvent do przycisku przełącznika
    jtbn.addItemListener(new ItemListener() { 
      public void itemStateChanged(ItemEvent ie) { 
        if(jtbn.isSelected()) 
          jlab.setText("Przycisk jest włączony.");
        else 
          jlab.setText("Przycisk jest wyłączony.");
      } 
    }); 
  
    // Dodaje przycisk przełącznika i etykietę do panelu treści
    jfrm.add(jtbn);   
    jfrm.add(jlab);  

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługującym zdarzenia
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JToggleButtonDemo(); 
        } 
      } 
    ); 
  }
}
