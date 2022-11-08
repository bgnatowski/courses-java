// Przykład użycia klasy JRadioButton
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class JRadioButtonDemo implements ActionListener { 
  JLabel jlab; 
 
  public JRadioButtonDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JRadioButtonDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(250, 100); 
 
    // Tworzy przyciski opcji i dodaje je do panelu treści
    JRadioButton b1 = new JRadioButton("A"); 
    b1.addActionListener(this); 
    jfrm.add(b1); 
 
    JRadioButton b2 = new JRadioButton("B"); 
    b2.addActionListener(this); 
    jfrm.add(b2); 
 
    JRadioButton b3 = new JRadioButton("C"); 
    b3.addActionListener(this); 
    jfrm.add(b3); 
       
    // Definiuje grupę przycisków
    ButtonGroup bg = new ButtonGroup(); 
    bg.add(b1); 
    bg.add(b2); 
    bg.add(b3); 
 
    // Tworzy etykietę i dodaje ją do panelu treści
    jlab = new JLabel("Wybierz opcję"); 
    jfrm.add(jlab); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 
 
  // Obsługuje wybór przycisku opcji
  public void actionPerformed(ActionEvent ae) { 
    jlab.setText("Wybrałeś opcję " + ae.getActionCommand()); 
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JRadioButtonDemo(); 
        } 
      } 
    ); 
  }
}
