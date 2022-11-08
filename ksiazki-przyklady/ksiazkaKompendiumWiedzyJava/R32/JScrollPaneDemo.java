// Przykład użycia klasy JScrollPane
import java.awt.*; 
import javax.swing.*; 
   
public class JScrollPaneDemo { 
 
  public JScrollPaneDemo() { 

    // Przygotowuje okno JFrame; używa domyślnego menedżera układu BorderLayot
    JFrame jfrm = new JFrame("JScrollPaneDemo");
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(400, 400);  

    // Tworzy panel i dodaje do niego 400 przycisków
    JPanel jp = new JPanel(); 
    jp.setLayout(new GridLayout(20, 20)); 

    int b = 0; 
    for(int i = 0; i < 20; i++) { 
      for(int j = 0; j < 20; j++) { 
        jp.add(new JButton("Przycisk " + b)); 
        ++b; 
      } 
    } 
 
    // Tworzy panel z paskami przewijania
    JScrollPane jsp = new JScrollPane(jp); 
 
    // Dodaje panel z paskami przewijania do panelu zawartości
    // Ponieważ zastosowano domyślny menedżer układu BorderLayout,
    // panel zostanie dodany do centralnego obszaru okna
    jfrm.add(jsp, BorderLayout.CENTER); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JScrollPaneDemo(); 
        } 
      } 
    ); 
  } 
}
