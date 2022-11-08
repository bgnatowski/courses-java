// Przykład użycia klasy JTree
import java.awt.*; 
import javax.swing.event.*; 
import javax.swing.*; 
import javax.swing.tree.*; 
 
public class JTreeDemo { 
 
  public JTreeDemo() { 
 
    // Przygotowuje okno JFrame, używa domyślnego menedżera układu BorderLayout
    JFrame jfrm = new JFrame("JTreeDemo");
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(200, 250); 

    // Tworzy węzeł główny drzewa 
    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Opcje"); 
 
    // Tworzy poddrzewo A
    DefaultMutableTreeNode a = new DefaultMutableTreeNode("A"); 
    top.add(a); 
    DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1"); 
    a.add(a1); 
    DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2"); 
    a.add(a2); 
 
    // Tworzy poddrzewo B
    DefaultMutableTreeNode b = new DefaultMutableTreeNode("B"); 
    top.add(b); 
    DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1"); 
    b.add(b1); 
    DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2"); 
    b.add(b2); 
    DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3"); 
    b.add(b3); 
 
    // Tworzy drzewo 
    JTree tree = new JTree(top); 
 
    // Dodaje drzewo do panelu z paskami przewijania
    JScrollPane jsp = new JScrollPane(tree); 
 
    // Dodaje panel z paskami przewijania do panelu treści 
    jfrm.add(jsp); 
 
    // Dodaje etykietę do panelu treści
    JLabel jlab = new JLabel(); 
    jfrm.add(jlab, BorderLayout.SOUTH); 
 
    // Dodaje obsługę wyboru węzłów drzewa 
    tree.addTreeSelectionListener(new TreeSelectionListener() { 
      public void valueChanged(TreeSelectionEvent tse) { 
        jlab.setText("Wybrano " + tse.getPath()); 
      } 
    }); 

    // Wyświetla okno
    jfrm.setVisible(true);
  } 

  public static void main(String[] args) { 

    // Tworzy okno w wątku obsługi zdarzeń
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new JTreeDemo(); 
        } 
      } 
    ); 
  }
}
