// Demonstruje użycie menedżera układu BorderLayout
import java.awt.*; 
import java.awt.event.*;
 
public class BorderLayoutDemo extends Frame { 
  public BorderLayoutDemo() { 

   // W oknach Frame menedżer BorderLayout jest używany domyślnie
 
    add(new Button("Ten przycisk znajdzie się na górze."),
        BorderLayout.NORTH); 
    add(new Label("Tutaj można umieścić komunikat stopki."),
        BorderLayout.SOUTH); 
    add(new Button("Prawy"), BorderLayout.EAST);
    add(new Button("Lewy"), BorderLayout.WEST);
 
    String msg = "Człowiek rozsądny stara się " +
      "dostosować do świata, w którym żyje;\n" +
      "człowiek nierozsądny nieustannie próbuje " +
      "przystosować ten świat do swoich potrzeb.\n" +
      "Rozwój świata jest więc całkowicie " +
      "uzależniony od poczynań ludzi nierozsądnych.\n\n" +
      "        - George Bernard Shaw\n\n";
 
    add(new TextArea(msg), BorderLayout.CENTER); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 

  public static void main(String[] args) {
    BorderLayoutDemo appwin = new BorderLayoutDemo();

    appwin.setSize(new Dimension(300, 220));
    appwin.setTitle("BorderLayoutDemo");
    appwin.setVisible(true);
  } 
}