// Przykład użycia klasy JTable
import java.awt.*; 
import javax.swing.*; 
 
public class JTableDemo { 
 
  // Inicjalizuje nagłówki kolumn 
  String[] colHeads = { "Imię", "Nr wewnętrzny", "Identyfikator" }; 
 
  // Inicjalizuje dane
  Object[][] data = {
    { "Grzegorz", "4567", "865" },
    { "Krzysztof", "7566", "555" },
    { "Wanda", "5634", "587" },
    { "Melania", "7345", "922" },
    { "Anna", "1237", "333" },
    { "Jan", "5656", "314" },
    { "Mateusz", "5672", "217" },
    { "Celina", "6741", "444" },
    { "Edward", "9023", "519" },
    { "Elżbieta", "1134", "532" },
    { "Janina", "5689", "112" },
    { "Eryk", "9030", "133" },
    { "Hanna", "6751", "145" }
  };

  public JTableDemo() { 

    // Przygotowuje obiekt JFrame, używa domyślnego menedżera układu BorderLayout
    JFrame jfrm = new JFrame("JTableDemo");
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(300, 300); 

    // Tworzy tabelę
    JTable table = new JTable(data, colHeads); 
 
    // Dodaje tabelę do panelu z paskami przewijania
    JScrollPane jsp = new JScrollPane(table); 
 
    // Dodaje panel z paskami przewijania do panelu treści
    jfrm.add(jsp); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdrzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JTableDemo(); 
        } 
      } 
    ); 
  }
}


