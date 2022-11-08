// Demonstruje stosowanie okien dialogowych
import java.awt.*; 
import java.awt.event.*; 
 
class DialogDemo extends Frame { 
  String msg = ""; 
  CheckboxMenuItem debug, test; 
  SampleDialog myDialog;
 
  public DialogDemo() { 

    // Tworzy okno dialogowe
    myDialog  = new SampleDialog(this, "Nowe okno dialogowe");  

    // Tworzy pasek menu i dodaje go do okna
    MenuBar mbar = new MenuBar(); 
    setMenuBar(mbar); 
 
    // Dodaje opcje menu
    Menu file = new Menu("Plik"); 
    MenuItem item1, item2, item3, item4, item5; 
    file.add(item1 = new MenuItem("Nowy..."));
    file.add(item2 = new MenuItem("Otwórz..."));
    file.add(item3 = new MenuItem("Zamknij"));
    file.add(item4 = new MenuItem("-")); 
    file.add(item5 = new MenuItem("Zakończ..."));
    mbar.add(file); 
 
    Menu edit = new Menu("Edycja");
    MenuItem item6, item7, item8, item9;
    edit.add(item6 = new MenuItem("Wytnij"));
    edit.add(item7 = new MenuItem("Kopiuj"));
    edit.add(item8 = new MenuItem("Wklej"));
    edit.add(item9 = new MenuItem("-"));

    Menu sub = new Menu("Specjalne", true);
    MenuItem item10, item11, item12;
    sub.add(item10 = new MenuItem("Pierwszy"));
    sub.add(item11 = new MenuItem("Drugi"));
    sub.add(item12 = new MenuItem("Trzeci"));
    edit.add(sub);
 
    // Tworzy elementy menu z możliwością zaznaczania
    debug = new CheckboxMenuItem("Tryb usuwania błędów");
    edit.add(debug);
    test = new CheckboxMenuItem("Tryb testowania");
    edit.add(test); 
 
    mbar.add(edit); 
 
    // Tworzy obiekt obsługujący zdarzenia typu ActionEvent i ItemEvent
    MyMenuHandler handler = new MyMenuHandler(); 

    // Rejestruje obiekt obsługujący zdarzenia
    item1.addActionListener(handler); 
    item2.addActionListener(handler); 
    item3.addActionListener(handler); 
    item4.addActionListener(handler); 
    item6.addActionListener(handler); 
    item7.addActionListener(handler); 
    item8.addActionListener(handler); 
    item9.addActionListener(handler); 
    item10.addActionListener(handler); 
    item11.addActionListener(handler); 
    item12.addActionListener(handler); 
    debug.addItemListener(handler); 
    test.addItemListener(handler); 
 
    // Używa wyrażenia lambda do obsługi opcji Zakończ
    item5.addActionListener((ae) -> System.exit(0));

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  } 
 
  public void paint(Graphics g) { 
    g.drawString(msg, 10, 220); 

   if(debug.getState()) 
      g.drawString("Usuwanie błędów jest włączone.", 10, 240); 
    else 
      g.drawString("Usuwanie błędów jest wyłączone.", 10, 240); 
 
    if(test.getState()) 
      g.drawString("Testowanie jest włączone.", 10, 260); 
    else 
      g.drawString("Testowanie jest wyłączone.", 10, 260); 
  } 

  public static void main(String[] args) {   
    DialogDemo appwin = new DialogDemo();

    appwin.setSize(new Dimension(250, 300));
    appwin.setTitle("DialogDemo");
    appwin.setVisible(true);
  } 

  // Klasa wewnętrzna do obsługi zdarzeń generowanych przez menu
  class MyMenuHandler implements ActionListener, ItemListener { 

    // Obsługuje zdarzenia ActionEvent
    public void actionPerformed(ActionEvent ae) { 
      msg = "Wybrałeś opcję ";
      String arg = ae.getActionCommand(); 

     if(arg.equals("Nowy...")) {
        msg += "Nowy";
        myDialog.setVisible(true); 
      } 
      else if(arg.equals("Otwórz..."))
        msg += "Otwórz";
      else if(arg.equals("Zamknij"))
        msg += "Zamknij";
      else if(arg.equals("Edycja"))
        msg += "Edycja";
      else if(arg.equals("Wytnij"))
        msg += "Wytnij";
      else if(arg.equals("Kopiuj"))
        msg += "Kopiuj";
      else if(arg.equals("Wklej"))
        msg += "Wklej";
      else if(arg.equals("Pierwszy"))
        msg += "Pierwszy";
      else if(arg.equals("Drugi"))
        msg += "Drugi";
      else if(arg.equals("Trzeci"))
        msg += "Trzeci";
      else if(arg.equals("Tryb usuwania błędów"))
        msg += "Tryb usuwania błędów";
      else if(arg.equals("Tryb testowania"))
        msg += "Tryb testowania";

      repaint(); 
    } 

    // Obsługuje zdarzenia typu ItemEvent
    public void itemStateChanged(ItemEvent ie) { 
      repaint(); 
    } 
  } 
} 
 
// Tworzy klasę pochodną klasy Dialog. 
class SampleDialog extends Dialog { 
  SampleDialog(Frame parent, String title) { 
    super(parent, title, false); 
    setLayout(new FlowLayout()); 
    setSize(300, 200); 
 
    add(new Label("Naciśnij ten przycisk:")); 

    Button b; 
    add(b = new Button("Anuluj")); 
    b.addActionListener((ae) -> dispose());

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        dispose();
      }
    });
  } 

  public void paint(Graphics g) { 
    g.drawString("W oknie dialogowym...", 20, 80); 
  } 
} 

