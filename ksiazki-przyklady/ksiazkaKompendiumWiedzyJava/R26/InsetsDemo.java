// Demonstruje użycie menedżera układu BorderLayout z obramowaniem
import java.awt.*; 
import java.awt.event.*; 
 
public class InsetsDemo extends Frame { 

  public InsetsDemo() { 
    // W oknach Frame menedżer BorderLayout jest używany domyślnie

    // Ustawia kolor tła tak, aby było widoczne obramowanie
    setBackground(Color.cyan); 
 
    setLayout(new BorderLayout()); 
 
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

  // Przesłania getInsets, by ustawić wielkość obramowania
  public Insets getInsets() { 
    return new Insets(40, 20, 10, 20); 
  } 

  public static void main(String[] args) {
    InsetsDemo appwin = new InsetsDemo();

    appwin.setSize(new Dimension(300, 220));
    appwin.setTitle("InsetsDemo");
    appwin.setVisible(true);
  } 
}
