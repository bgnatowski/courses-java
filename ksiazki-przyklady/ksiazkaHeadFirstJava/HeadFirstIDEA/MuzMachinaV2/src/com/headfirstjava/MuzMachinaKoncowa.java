package com.headfirstjava;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.event.*;


public class MuzMachinaKoncowa implements MetaEventListener {

  JFrame ramkaGlowna;
  JPanel panelGlowny;
  JList listaOtrzymanych;
  JTextField komunikatUzytkownika;
  ArrayList<JCheckBox> listaPolWyboru;
  int nastepnyNum;
  Vector<String> wektorLista = new Vector<String>();
  String uzytkownik;
  ObjectOutputStream wyj;
  ObjectInputStream wej;
  HashMap<String, boolean[]> mapaOdebranychKompozycji = new HashMap<String, boolean[]>();
  
  
  Sequencer sekwenser;
  Sequence sekwencja;
  Sequence mojaSekwencja = null;

  Track sciezka;
  
  String[] nazwyInstrumentow = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
  int[] instrumenty = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

  public static void main (String[] args) {
    if (args.length == 1) {
      new MuzMachinaKoncowa().konfigurujAplk(args[0]);
    } else if (args.length == 0){
      System.out.println("Nie podano nazwy użytkownika. Ustawiono nazwę default");
      new MuzMachinaKoncowa().konfigurujAplk("Player");
    } else {
      System.out.println("Nazwa uzytkownika musi być jendym wyrazem! Ustawiono nazwę default");
      new MuzMachinaKoncowa().konfigurujAplk("Player");
    }
  }

  public void konfigurujAplk(String nazwa) {
    uzytkownik = nazwa;
    // nawiązujemy połączenie z serwerem
    try {
      Socket sock = new Socket("127.0.0.1", 4242);
      wyj = new ObjectOutputStream(sock.getOutputStream());
      wej = new ObjectInputStream(sock.getInputStream());
      Thread watekZd = new Thread(new ZdalnyCzytelnik());
      watekZd.start();
    } catch(Exception ex) {
      System.out.println("brak połączenia - będziesz musiał grać samemu.");
    }
   
    konigurujMidi();
    tworzGUI();
  }

  public void tworzGUI() {
    ramkaGlowna = new JFrame("MuzMachina");
    BorderLayout uklad = new BorderLayout();
    JPanel panelTla = new JPanel(uklad);
    JPanel panelWiadomosci = new JPanel();
    panelTla.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    JMenuBar menuBar = new JMenuBar();
    JMenu menuPlik = new JMenu("Plik");
    JMenu menuKompozycja = new JMenu("Kompozycja");
    JMenuItem zapiszPlik = new JMenuItem("Zapisz kompozycje");
    JMenuItem odtworzPlik = new JMenuItem("Odtwórz kompozycje");
    JMenuItem wyczyśćPlik = new JMenuItem("Wyczyść planszę");
    JMenuItem randomizePlik = new JMenuItem("Utwórz losową kompozycję");
    JMenuItem mojaSekwencjaPlik = new JMenuItem("Przywróć początkową kompozycję");

    zapiszPlik.addActionListener(new MojZapiszListener());
    odtworzPlik.addActionListener(new MojOdtworzListener());
    wyczyśćPlik.addActionListener(new MojWyczyscListener());
    randomizePlik.addActionListener(new MojLosujListener());
    mojaSekwencjaPlik.addActionListener(new OdtworzMojeListener());

    menuPlik.add(zapiszPlik);
    menuPlik.add(odtworzPlik);
    menuKompozycja.add(wyczyśćPlik);
    menuKompozycja.add(randomizePlik);
    menuKompozycja.add(mojaSekwencjaPlik);
    menuBar.add(menuPlik);
    menuBar.add(menuKompozycja);

    ramkaGlowna.setJMenuBar(menuBar);

    listaPolWyboru = new ArrayList<JCheckBox>();

    Box obszarPrzyciskow = new Box(BoxLayout.X_AXIS);
    obszarPrzyciskow.setBorder(BorderFactory.createEmptyBorder(0,100,10,10));
    JButton start = new JButton("Start");
    start.addActionListener(new MojStartListener());
    obszarPrzyciskow.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(new MojStopListener());
    obszarPrzyciskow.add(stop);

    JButton tempoG = new JButton("Szybciej");
    tempoG.addActionListener(new MojTempoGListener());
    obszarPrzyciskow.add(tempoG);

    JButton tempoD = new JButton("Wolniej");
    tempoD.addActionListener(new MojTempoDListener());
    obszarPrzyciskow.add(tempoD);

    Box obszarWiadomosci = new Box(BoxLayout.Y_AXIS);

    JLabel wiadomoscLabel = new JLabel("Wiadomość: ");
    wiadomoscLabel.setFont(new Font("sansserif", Font.BOLD, 15));
    obszarWiadomosci.add(wiadomoscLabel);

    JButton wyslij = new JButton("Wyślij");
    wyslij.addActionListener(new MojWyslijListener());

    komunikatUzytkownika = new JTextField(20);
    obszarWiadomosci.add(komunikatUzytkownika);
    obszarWiadomosci.add(wyslij);

    JLabel odebraneLabel = new JLabel("Odebrane: ");
    odebraneLabel.setFont(new Font("sansserif", Font.BOLD, 15));
    obszarWiadomosci.add(odebraneLabel);

    listaOtrzymanych = new JList();
    listaOtrzymanych.addListSelectionListener(new WyborZListyListener());
    listaOtrzymanych.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane lista = new JScrollPane(listaOtrzymanych);
    lista.setPreferredSize(new Dimension(50, 300));
    obszarWiadomosci.add(lista);
   
    listaOtrzymanych.setListData(wektorLista); // na początku brak danych

    Box obszarNazw = new Box(BoxLayout.Y_AXIS);
    for (int i = 0; i < 16; i++) {
      obszarNazw.add(new Label(nazwyInstrumentow[i]));
    }

    panelWiadomosci.add(BorderLayout.EAST, obszarWiadomosci);
    panelTla.add(BorderLayout.SOUTH, obszarPrzyciskow);
    panelTla.add(BorderLayout.WEST, obszarNazw);

    ramkaGlowna.getContentPane().add(BorderLayout.WEST, panelTla);
    ramkaGlowna.getContentPane().add(BorderLayout.EAST, panelWiadomosci);

    GridLayout siatkaPolWyboru = new GridLayout(16,16);
    siatkaPolWyboru.setVgap(1);
    siatkaPolWyboru.setHgap(2);
    panelGlowny = new JPanel(siatkaPolWyboru);
    panelTla.add(BorderLayout.CENTER, panelGlowny);

    for (int i = 0; i < 256; i++) {                    
      JCheckBox c = new JCheckBox();
    
      c.setSelected(false);
      listaPolWyboru.add(c);
      panelGlowny.add(c);            
    } // koniec pętli

    ramkaGlowna.setBounds(50,50,1200,800);
    ramkaGlowna.pack();
    ramkaGlowna.setVisible(true);
  } // koniec metody


  public void konigurujMidi() {
    try {
      sekwenser = MidiSystem.getSequencer();
      sekwenser.open();
      sekwenser.addMetaEventListener(this);
      sekwencja = new Sequence(Sequence.PPQ,4);
      sciezka = sekwencja.createTrack();
      sekwenser.setTempoInBPM(120);
    } catch(Exception e) {e.printStackTrace();}
  } // koniec metody

  public void utworzSciezkeIOdtworz() {
    ArrayList<Integer> listaSciezki = null;  // ta tablica będzie zawierać instrumenty zaznaczone
    // w kolumnie -- innymi słowy w jednym takcie (może ich być kilkanaście)
 
    sekwencja.deleteTrack(sciezka);
    sciezka = sekwencja.createTrack();

    // teraz w pętli sprawdzimy wszystkie pola wyboru i stworzymy zdarzenie "ON" i "OFF"
    // dla wszystkich zaznaczonych pól
    for (int i = 0; i < 16; i++) {
    
      listaSciezki = new ArrayList<Integer>();

      for (int j = 0; j < 16; j++) {
        JCheckBox jc = (JCheckBox) listaPolWyboru.get(j + (16*i));
        if (jc.isSelected()) { 
          int key = instrumenty[i];  
          listaSciezki.add(new Integer(key));
        } else {
          listaSciezki.add(null);  // gdyż ten wpis ścieżki powinien być pusty
        }
      } // koniec wewnętrznej pętli for

      utworzSciezke(listaSciezki);
    } // koniec zewnętrznej pętli for

    sciezka.add(tworzZdarzenie(192,9,1,0,15)); // - zawsze mamy pełne 16 taktów 
                       
    try {
      sekwenser.setSequence(sekwencja);   
      sekwenser.setLoopCount(sekwenser.LOOP_CONTINUOUSLY);                 
      sekwenser.start();
      sekwenser.setTempoInBPM(120);
    } catch (Exception e) {e.printStackTrace();}
  } // koniec metody
            
 
  public class MojStartListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      utworzSciezkeIOdtworz();
    } // koniec metody actionPerformed
  } // koniec klasy wewnętrznej

  public class MojStopListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      sekwenser.stop();
    } // koniec metody actionPerformed
  } // koniec klasy wewnętrznej

  public class MojTempoGListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      float wspTempa = sekwenser.getTempoFactor();
      sekwenser.setTempoFactor((float)(wspTempa * 1.03)); 
    } // koniec metody actionPerformed
  } // koniec klasy wewnętrznej

  public class MojTempoDListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      float wspTempa = sekwenser.getTempoFactor();
      sekwenser.setTempoFactor((float)(wspTempa * 0.97)); 
    } // koniec metody actionPerformed
  } // koniec klasy wewnętrznej


  public class MojWyslijListener implements ActionListener {

    public void actionPerformed(ActionEvent a) {
      // tworzymy tablicę ze stanami pól wyboru
      boolean[] stanPolaWyboru = new boolean[256];
  
      for (int i = 0; i < 256; i++) {
        JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
        if (pole.isSelected()) {
          stanPolaWyboru[i] = true;
        }
      } // koniec pętli for
       
      String komunikatDoWyslania = null;         
  
      try {
        wyj.writeObject(uzytkownik + nastepnyNum++ + ": " + komunikatUzytkownika.getText());
        wyj.writeObject(stanPolaWyboru);
      } catch(Exception ex) {
        System.out.println("Przykro mi bracie. Nie mog�em wys�a� kompozycji na serwer.");
      }
      komunikatUzytkownika.setText("");         
    } // koniec metody
  } // koniec klasy wewnętrznej


  public class WyborZListyListener implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent le) {
      if (!le.getValueIsAdjusting()) {
        wyswietlUwage();
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        wyswietlOknoZapisujace();

        String wybranaOpcja = (String) listaOtrzymanych.getSelectedValue();  
        if (wybranaOpcja != null) {    
        
          // teraz odwołujemy się do mapy i zmieniamy sekwencję
          boolean[] stanZaznaczonego = (boolean[]) mapaOdebranychKompozycji.get(wybranaOpcja);
    
          zmienSekwencje(stanZaznaczonego);                                     
    
          sekwenser.stop(); 
          //utworzSciezkeIOdtworz();
        }
      }
    } // koniec metody
    private void wyswietlUwage(){
      JDialog uwaga = new JDialog();
      JLabel textUwaga = new JLabel("Uwaga! Zapisz kompozycje przed wczytaniem!");
      textUwaga.setHorizontalAlignment(SwingConstants.CENTER);
      uwaga.add(textUwaga);
      uwaga.setSize(450,100);
      uwaga.setVisible(true);
      uwaga.repaint();
    }

    private void wyswietlOknoZapisujace(){
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.showSaveDialog(ramkaGlowna);
      zapiszPlik(fileChooser.getSelectedFile());
    }
    private void zapiszPlik(File plik){
      boolean[] stanyPol = new boolean[256];

      for(int i = 0; i<256;i++){
        JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
        if(pole.isSelected()){
          stanyPol[i] = true;
        }
      }

      try {
        FileOutputStream strumienPlk = new FileOutputStream(plik);
        ObjectOutputStream os = new ObjectOutputStream(strumienPlk);
        os.writeObject(stanyPol);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  } // koniec klasy wewnętrznej


  public class ZdalnyCzytelnik implements Runnable {
    boolean[] stanPolaWyboru = null;
    String prezentowanaNazwa = null;
    Object obj = null;
    public void run() {
      try {
        while((obj=wej.readObject()) != null) {
          System.out.println("pobraliśmy obiekt z serwera");
          System.out.println(obj.getClass());
        
          String nazwaDoWyswietlenia = (String) obj;
          stanPolaWyboru = (boolean[]) wej.readObject();
          mapaOdebranychKompozycji.put(nazwaDoWyswietlenia, stanPolaWyboru);
  
          wektorLista.add(nazwaDoWyswietlenia);
          listaOtrzymanych.setListData(wektorLista);
          // teraz aktualizujemy sekwencję
        } // konie while 
      } catch(Exception ex) {ex.printStackTrace();}  
    } // konie metody run
  } // koniec klasy wewnętrznej

  public class OdtworzMojeListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      if (mojaSekwencja != null) {
        sekwencja = mojaSekwencja;     // przywracamy mój oryginał
      }
    }
  }                                                            

  public void zmienSekwencje(boolean[] stanPolaWyboru) {
    for (int i = 0; i < 256; i++) {
      JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
      if (stanPolaWyboru[i]) {
        pole.setSelected(true);
      } else {
        pole.setSelected(false);
      }
    } // koniec for  
  } // koniec metody
    

  public void utworzSciezke(ArrayList list) {
    Iterator iter = list.iterator();
    // który klawisz został naciśnięty?
     
    for (int i = 0; i < 16; i++) {
      Integer num = (Integer) iter.next();
      if (num != null) {
        int numKlaw = num.intValue();            
        sciezka.add(tworzZdarzenie(144,9,numKlaw, 100, i));
        sciezka.add(tworzZdarzenie(128,9,numKlaw,100, i + 1));
      }
    }
  }
 
  public  MidiEvent tworzZdarzenie(int plc, int kanal, int jeden, int dwa, int takt) {
    MidiEvent zdarzenie = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(plc, kanal, jeden, dwa);
      zdarzenie = new MidiEvent(a, takt);
    } catch(Exception e) { }
    
    return zdarzenie;
  }

  public void meta(MetaMessage komunikat) {
    if (komunikat.getType() == 47) {
      sekwenser.start();
    }
  }

  private class MojWyczyscListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      for(int i = 0; i<256; i++){
        JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
        pole.setSelected(false);
      }
      sekwenser.stop();
    }
  }

  private class MojZapiszListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      //tworzymy tablice ze stanami pol wyboru
      JFileChooser zapiszChooser = new JFileChooser();
      zapiszChooser.showSaveDialog(ramkaGlowna);
      zapiszPlik(zapiszChooser.getSelectedFile());
    }

    private void zapiszPlik(File plik){
      boolean[] stanyPol = new boolean[256];

      for(int i = 0; i<256;i++){
        JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
        if(pole.isSelected()){
          stanyPol[i] = true;
        }
      }

      try {
        FileOutputStream strumienPlk = new FileOutputStream(plik);
        ObjectOutputStream os = new ObjectOutputStream(strumienPlk);
        os.writeObject(stanyPol);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  private class MojOdtworzListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JFileChooser odtworzChooser = new JFileChooser();
      odtworzChooser.showOpenDialog(ramkaGlowna);
      odtworzPlik(odtworzChooser.getSelectedFile());
    }

    private void odtworzPlik(File plik){
      boolean[] stanyPol = new boolean[256];
      try{
        FileInputStream plikDanych = new FileInputStream(plik);
        ObjectInputStream is = new ObjectInputStream(plikDanych);
        stanyPol = (boolean[]) is.readObject();
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      for(int i = 0; i<256; i++){
        JCheckBox pole = (JCheckBox) listaPolWyboru.get(i);
        if(stanyPol[i]) {
          pole.setSelected(true);
        } else {
          pole.setSelected(false);
        }
      }
      sekwenser.stop();
      //utworzSciezkeIOdtworz();
    }
  }
  private class MojLosujListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      for(int i = 0; i<256; i++){
        Random rd = new Random();
        JCheckBox jc = listaPolWyboru.get(i);
        jc.setSelected(rd.nextBoolean());
      }
      sekwenser.stop();
    }
  }
} // koniec klasy
