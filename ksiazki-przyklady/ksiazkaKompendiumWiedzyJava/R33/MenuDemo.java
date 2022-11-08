// Demonstruje proste menu główne
   
import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
    
class MenuDemo implements ActionListener { 
   
  JLabel jlab; 
  
  MenuDemo() {   
    // Tworzy kontener JFrame
    JFrame jfrm = new JFrame("Prezentacja Menu"); 
   
    // Zastosowanie menedżera układu FlowLayout
    jfrm.setLayout(new FlowLayout());   
   
    // Określenie początkowych wymiarów ramki
    jfrm.setSize(220, 200);   
   
    // Zamknięcie okna aplikacji ma kończyć działanie programu
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   
    // Tworzy etykietę, w której będą wyświetlane nazwy
    // wybieranych opcji menu
    jlab = new JLabel(); 
 
    // Tworzy pasek menu
    JMenuBar jmb = new JMenuBar(); 
 
    // Utworzenie menu Plik menu
    JMenu jmFile = new JMenu("Plik"); 
    JMenuItem jmiOpen = new JMenuItem("Otwórz"); 
    JMenuItem jmiClose = new JMenuItem("Zamknij"); 
    JMenuItem jmiSave = new JMenuItem("Zapisz"); 
    JMenuItem jmiExit = new JMenuItem("Zakończ"); 
    jmFile.add(jmiOpen); 
    jmFile.add(jmiClose); 
    jmFile.add(jmiSave); 
    jmFile.addSeparator(); 
    jmFile.add(jmiExit); 
    jmb.add(jmFile); 
 
    // Utworzenie menu Opcje
    JMenu jmOptions = new JMenu("Opcje"); 
 
    // Utworzenie podmenu Kolory
    JMenu jmColors = new JMenu("Kolory"); 
    JMenuItem jmiRed = new JMenuItem("Czerwony"); 
    JMenuItem jmiGreen = new JMenuItem("Zielony"); 
    JMenuItem jmiBlue = new JMenuItem("Niebieski"); 
    jmColors.add(jmiRed); 
    jmColors.add(jmiGreen); 
    jmColors.add(jmiBlue); 
    jmOptions.add(jmColors); 
 
    // Utworzenie podmenu Priorytet
    JMenu jmPriority = new JMenu("Priorytet"); 
    JMenuItem jmiHigh = new JMenuItem("Wysoki"); 
    JMenuItem jmiLow = new JMenuItem("Niski"); 
    jmPriority.add(jmiHigh); 
    jmPriority.add(jmiLow); 
    jmOptions.add(jmPriority); 
 
    // Utworzenie opcji Resetuj
    JMenuItem jmiReset = new JMenuItem("Resetuj"); 
    jmOptions.addSeparator(); 
    jmOptions.add(jmiReset); 
 
    // Dodaje całe menu Opcje do paska menu
    jmb.add(jmOptions);  
 
    // Tworzy menu Pomoc
    JMenu jmHelp = new JMenu("Pomoc"); 
    JMenuItem jmiAbout = new JMenuItem("O programie"); 
    jmHelp.add(jmiAbout); 
    jmb.add(jmHelp);  
 
    // Dodaje wszystkie obiekty nasłuchujące
    jmiOpen.addActionListener(this); 
    jmiClose.addActionListener(this); 
    jmiSave.addActionListener(this); 
    jmiExit.addActionListener(this); 
    jmiRed.addActionListener(this); 
    jmiGreen.addActionListener(this); 
    jmiBlue.addActionListener(this); 
    jmiHigh.addActionListener(this); 
    jmiLow.addActionListener(this); 
    jmiReset.addActionListener(this); 
    jmiAbout.addActionListener(this); 
 
    // Dodaje etykietę do panelu zawartości
    jfrm.add(jlab);    
 
    // Dodaje pasek menu do ramki
    jfrm.setJMenuBar(jmb);    
   
    // Wyświetla ramkę
    jfrm.setVisible(true);   
  }   
 
  // Obsługa zdarzeń generowanych przez wybierane opcje menu
  public void actionPerformed(ActionEvent ae) {  
    // Pobranie łańcucha polecenia wybranej opcji menu
    String comStr = ae.getActionCommand(); 
 
    // W przypadku wybrania opcji Zakończ należy zakończyć 
    // działanie programu
    if(comStr.equals("Zakończ")) System.exit(0); 
 
    // W pozostałych przypadkach wyświetlana jest nazwa opcji
    jlab.setText("Wybrano " + comStr); 
  }  
    
  public static void main(String args[]) {   
    // Tworzy ramkę w wątku obsługi zdarzeń
    SwingUtilities.invokeLater(new Runnable() {   
      public void run() {   
        new MenuDemo();   
      }   
    });   
  }   
}
