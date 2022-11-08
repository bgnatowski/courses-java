// Prezentacja zastosowania filtrów obrazów
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.lang.reflect.*;

public class ImageFilterDemo extends Frame implements ActionListener {
  Image img;
  PlugInFilter pif;
  Image fimg;
  Image curImg;
  LoadedImage lim;
  Label lab;
  Button reset;

  // Nazwy filtrów
  String[] filters = { "Grayscale", "Invert", "Contrast",
                       "Blur", "Sharpen" };

  public ImageFilterDemo() {
    Panel p = new Panel();
    add(p, BorderLayout.SOUTH);

    // Tworzy przycisk Przywróć
    reset = new Button("Przywróć");
    reset.addActionListener(this);
    p.add(reset);

    // Dodaje przyciski filtrów
    for(String fstr: filters) {
      Button b = new Button(fstr);
      b.addActionListener(this);
      p.add(b);
    }

    // Tworzy górną etykietę
    lab = new Label("");
    add(lab, BorderLayout.NORTH);

    // Wczytuje obraz
    try {
      File imageFile = new File("Lilies.jpg");

      // Wczytuje obraz
      img = ImageIO.read(imageFile); 
    } catch (IOException exc) {
      System.out.println("Nie udało się wczytać pliku obrazu.");
      System.exit(0);
    }

    // Pobiera obiekt LoadedImage i wyświetla go na środku okna programu
    lim = new LoadedImage(img);
    add(lim, BorderLayout.CENTER);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public void actionPerformed(ActionEvent ae) {
    String a = "";

    try {
      a = ae.getActionCommand();
      if (a.equals("Przywróć")) {
        lim.set(img);
        lab.setText("Normal");
      }
      else {
        // Pobiera wybrany filtr
        pif = (PlugInFilter)
                (Class.forName(a)).getConstructor().newInstance();
        fimg = pif.filter(this, img);
        lim.set(fimg);
        lab.setText("Obraz przefiltrowany: " + a);
      }
      repaint();
    } catch (ClassNotFoundException e) {
      lab.setText("Nie znaleziono klasy " + a);
      lim.set(img);
      repaint();
    } catch (InstantiationException e) {
      lab.setText("Nie powiodło się tworzenie egzemplarza klasy " + a);
    } catch (IllegalAccessException e) {
      lab.setText("Brak dostępu do klasy " + a);
    } catch (NoSuchMethodException | InvocationTargetException e) {
      lab.setText("Błąd podczas tworzenia filtra " + e);
    } 
  } 

  public static void main(String[] args) {
    ImageFilterDemo appwin = new ImageFilterDemo();

    appwin.setSize(new Dimension(420, 420));
    appwin.setTitle("ImageFilterDemo");
    appwin.setVisible(true);
  } 
}