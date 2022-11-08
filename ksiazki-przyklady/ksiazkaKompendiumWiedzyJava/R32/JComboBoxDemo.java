// Przykład użycia klasy JComboBox
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
   
public class JComboBoxDemo { 
  
  String timepieces[] = { "Klepsydra", "Zegarek analogowy", "Zegarek cyfrowy", "Stoper" };
  Hashtable<String,String> images = new Hashtable<String,String>();
 
  public JComboBoxDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JCombBoxDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(400, 250); 
 
    // Tworzy obiekt listy kombinowanej i dodaje ten komponent do panelu treści
    JComboBox<String> jcb = new JComboBox<String>(timepieces); 
    jfrm.add(jcb); 
 
    // Tworzy etykietę i dodaje ją do panelu treści
    JLabel jlab = new JLabel(new ImageIcon("hourglass.png")); 
    jfrm.add(jlab); 

    // Obsługuje wybór elementu listy
    jcb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        String s = (String) jcb.getSelectedItem();
        jlab.setIcon(new ImageIcon(images.get(s) + ".png"));
      } 
    }); 

    // Wyświetla okno
    jfrm.setVisible(true);

    // Kojarzy nazwy opcji listy z nazwami plików z obrazkami
    images.put("Klepsydra", "hourglass");
    images.put("Zegarek analogowy", "analog");
    images.put("Zegarek cyfrowy", "digital");
    images.put("Stoper","stopwatch");
    
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JComboBoxDemo(); 
        } 
      } 
    ); 
  }
}
