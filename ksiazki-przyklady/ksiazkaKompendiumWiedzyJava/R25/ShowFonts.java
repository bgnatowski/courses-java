// Wyświetlanie czcionek
import java.awt.event.*;
import java.awt.*;

public class ShowFonts extends Frame {
  String msg = "Pięć pierwszych czcionek: ";
  GraphicsEnvironment ge;

  public ShowFonts() {
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });

    // Pobranie środowiska graficznego
    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    // Pobranie listy czcionek
    String[] fontList = ge.getAvailableFontFamilyNames();

    // Utworzenie łańcucha z pierwszymi pięcioma czcionkami
    for(int i=0; (i < 5) && (i < fontList.length); i++)
      msg += fontList[i] + " ";
  }

  // Wyświetlenie czcionek
  public void paint(Graphics g) {
    g.drawString(msg, 10, 60);
  }

  public static void main(String[] args) {
    ShowFonts appwin = new ShowFonts();

    appwin.setSize(new Dimension(500, 100));
    appwin.setTitle("ShowFonts");
    appwin.setVisible(true);
  }
}
