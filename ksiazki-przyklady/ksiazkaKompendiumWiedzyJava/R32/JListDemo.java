// Przykład użycia klasy JList
import javax.swing.*;  
import javax.swing.event.*; 
import java.awt.*; 
import java.awt.event.*; 
   
public class JListDemo { 

  // Tworzy tablicę z nazwami miast
  String Cities[] = { "Nowy Jork", "Chicago", "Houston",
                      "Denver", "Los Angeles", "Seattle",
                      "Londyn", "Paryż", "Nowe Delhi",
                      "Hongkong", "Tokio", "Sydney" };
 
  public JListDemo() { 
 
    // Przygotowuje okno JFrame
    JFrame jfrm = new JFrame("JListDemo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(200, 200); 
 
    // Tworzy komponent JList
    JList<String> jlst = new JList<String>(Cities); 
 
    // Ustawia w komponencie tryb jednokrotnego wyboru
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
 
    // Dodaje listę do panelu z paskami przewijania
    JScrollPane jscrlp = new JScrollPane(jlst); 
 
    // Ustawia preferowane wymiary panelu
    jscrlp.setPreferredSize(new Dimension(120, 90)); 
 
    // Tworzy etykietę wyświetlającą nazwę wybranego miasta
    JLabel jlab = new JLabel("Wybierz miasto"); 
 
    // Dodaje obiekt nasłuchujący zdarzeń wyboru opcji na liście
    jlst.addListSelectionListener(new ListSelectionListener() {  
      public void valueChanged(ListSelectionEvent le) {  
        // Pobiera indeks wybranego elementu listy
        int idx = jlst.getSelectedIndex(); 
 
        // Wyświetla wybrany element (jeśli został zaznaczony)
        if(idx != -1) 
          jlab.setText("Bieżący wybór: " + Cities[idx]); 
        else // W przeciwnym razie poprosi o wskazanie miasta
          jlab.setText("Wybierz miasto"); 
      }  
    });  
 
    // Dodaje listę i etykietę do panelu treści
    jfrm.add(jscrlp); 
    jfrm.add(jlab); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JListDemo(); 
        } 
      } 
    ); 
  }
}
