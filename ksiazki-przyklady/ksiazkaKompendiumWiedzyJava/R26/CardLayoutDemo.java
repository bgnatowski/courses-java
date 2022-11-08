// Demonstruje użycie menedżera układu CardLayout
import java.awt.*; 
import java.awt.event.*; 
 
public class CardLayoutDemo extends Frame { 
 
  Checkbox windows10, windows7, windows8, android, solaris, mac; 
  Panel osCards; 
  CardLayout cardLO; 
  Button Win, Other; 
 
  public CardLayoutDemo() { 

    // W głównym oknie zostanie użyty menedżer FlowLayout
    setLayout(new FlowLayout());

    Win = new Button("Windows"); 
    Other = new Button("Inne"); 
    add(Win); 
    add(Other); 
 
    // W panelu osCarsds zostanie użyty menedżer CardLayout
    cardLO = new CardLayout(); 
    osCards = new Panel(); 
    osCards.setLayout(cardLO);  
 
    windows7 = new Checkbox("Windows 7",true); 
    windows8 = new Checkbox("Windows 8"); 
    windows10 = new Checkbox("Windows 10"); 
    android = new Checkbox("Android"); 
    solaris = new Checkbox("Solaris"); 
    mac = new Checkbox("MacOS"); 
 
    // Dodaje do panelu pola wyboru z systemami Windows
    Panel winPan = new Panel(); 
    winPan.add(windows7); 
    winPan.add(windows8); 
    winPan.add(windows10); 
 
    // Dodaje do panelu pola wyboru z innymi systemami
    Panel otherPan = new Panel(); 
    otherPan.add(android); 
    otherPan.add(solaris); 
    otherPan.add(mac); 
 
    // Dodaje panele do macierzystego panelu kartoteki
    osCards.add(winPan, "Windows"); 
    osCards.add(otherPan, "Inne"); 
 
    // Dodaje karty do panelu głównego okna programu
    add(osCards); 
 
    // Używa wyrażeń lambda do obsługi kliknięć przycisków
    Win.addActionListener((ae) -> cardLO.show(osCards, "Windows")); 
    Other.addActionListener((ae) -> cardLO.show(osCards, "Inne")); 
 
    // Rejestruje obiekty nasłuchujące zdarzeń ActionEvent
    addMouseListener(new MouseAdapter() {
      // Przegląda panele
      public void mousePressed(MouseEvent me) { 
        cardLO.next(osCards); 
      }
    });

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    }); 
  } 

  public static void main(String[] args) {
    CardLayoutDemo appwin = new CardLayoutDemo();

    appwin.setSize(new Dimension(300, 220));
    appwin.setTitle("CardLayoutDemo");
    appwin.setVisible(true);
  } 
}
