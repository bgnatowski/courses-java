// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Klasa używana do utworzenia akcji obsługujących
// przyciski paska narzędzi i elementy menu Uruchamianie
class DebugAction extends AbstractAction { 
  public DebugAction(String name, Icon image, int mnem, 
                    int accel, String tTip) { 
    super(name, image); 
    putValue(ACCELERATOR_KEY, 
             KeyStroke.getKeyStroke(accel,  
                                    InputEvent.CTRL_DOWN_MASK));  
    putValue(MNEMONIC_KEY, mnem); 
    putValue(SHORT_DESCRIPTION, tTip); 
  } 
 
  // Obsługuje zdarzenia generowane przez przyciski paska 
  // narzędzi i elementy menu Uruchamianie
  public void actionPerformed(ActionEvent ae) {     
    String comStr = ae.getActionCommand();  
 
    jlab.setText("Wybrano " + comStr); 
 
    // Przełącza status opcji Ustaw punkt wstrzymania 
    // i Usuń punkt wstrzymania
    if(comStr.equals("Ustaw punkt wstrzymania")) { 
      clearAct.setEnabled(true); 
      setAct.setEnabled(false); 
    } else if(comStr.equals("Usuń punkt wstrzymania")) { 
      clearAct.setEnabled(false); 
      setAct.setEnabled(true); 
    } 
  } 
}
