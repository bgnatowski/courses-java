// Przykład użycia przycisków typu JButton z ikonami
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class JButtonDemo implements ActionListener { 
  JLabel jlab; 
 
  public JButtonDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JButtonDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(500, 450); 
 
    // Dodaje przyciski do panelu treści
    ImageIcon hourglass = new ImageIcon("hourglass.png"); 
    JButton jb = new JButton(hourglass); 
    jb.setActionCommand("klepsydra"); 
    jb.addActionListener(this); 
    jfrm.add(jb); 
 
    ImageIcon analog = new ImageIcon("analog.png"); 
    jb = new JButton(analog); 
    jb.setActionCommand("zegar analogowy"); 
    jb.addActionListener(this); 
    jfrm.add(jb); 
 
    ImageIcon digital = new ImageIcon("digital.png"); 
    jb = new JButton(digital); 
    jb.setActionCommand("zegar cyfrowy"); 
    jb.addActionListener(this); 
    jfrm.add(jb); 
 
    ImageIcon stopwatch = new ImageIcon("stopwatch.png"); 
    jb = new JButton(stopwatch); 
    jb.setActionCommand("stoper"); 
    jb.addActionListener(this); 
    jfrm.add(jb); 
 
    // Tworzy etykietę i dodaje ją do panelu treści
    jlab = new JLabel("Wybierz urządzenie do pomiaru czasu"); 
    jfrm.add(jlab); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 
 
  // Obsługuje zdarzenia związane z przyciskami
  public void actionPerformed(ActionEvent ae) { 
    jlab.setText("Wybrałeś " + ae.getActionCommand()); 
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługującym zdarzenia
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JButtonDemo(); 
        } 
      } 
    ); 
  }
}
