// Przykład użycia klasy JCheckbox
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class JCheckBoxDemo implements ItemListener { 
  JLabel jlab; 
 
  public JCheckBoxDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JCheckBoxDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(250, 100); 
 
    // Dodaje pola wyboru do panelu treści
    JCheckBox cb = new JCheckBox("C");  
    cb.addItemListener(this); 
    jfrm.add(cb); 
 
    cb = new JCheckBox("C++"); 
    cb.addItemListener(this); 
    jfrm.add(cb); 
 
    cb = new JCheckBox("Java"); 
    cb.addItemListener(this); 
    jfrm.add(cb); 
 
    cb = new JCheckBox("Perl"); 
    cb.addItemListener(this); 
    jfrm.add(cb); 
 
    // Tworzy etykietę i dodaje ją do panelu treści
    jlab = new JLabel("Wybierz języki"); 
    jfrm.add(jlab); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 
 
  // Obsługuje zdarzenia ItemEvent dla pól wyboru
  public void itemStateChanged(ItemEvent ie) { 
    JCheckBox cb = (JCheckBox)ie.getItem(); 
 
    if(cb.isSelected()) 
      jlab.setText("Pole " + cb.getText() + " jest zaznaczone.");
    else 
      jlab.setText("Pole " + cb.getText() + " nie jest zaznaczone.");
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JCheckBoxDemo(); 
        } 
      } 
    ); 
  }
}
