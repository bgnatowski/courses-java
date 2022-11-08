// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Utworzenie menu Plik wraz z mnemonikami i akceleratorami
JMenu jmFile = new JMenu("Plik"); 
jmFile.setMnemonic(KeyEvent.VK_P); 
 
JMenuItem jmiOpen = new JMenuItem("Otwórz", 
                                  KeyEvent.VK_O); 
jmiOpen.setAccelerator( 
          KeyStroke.getKeyStroke(KeyEvent.VK_O, 
                                 InputEvent.CTRL_DOWN_MASK)); 
 
JMenuItem jmiClose = new JMenuItem("Zamknij", 
                                   KeyEvent.VK_M); 
jmiClose.setAccelerator( 
          KeyStroke.getKeyStroke(KeyEvent.VK_M, 
                                 InputEvent.CTRL_DOWN_MASK)); 
 
JMenuItem jmiSave = new JMenuItem("Zapisz", 
                                  KeyEvent.VK_Z); 
jmiSave.setAccelerator( 
          KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
                                 InputEvent.CTRL_DOWN_MASK)); 
 
JMenuItem jmiExit = new JMenuItem("Zakończ", 
                                  KeyEvent.VK_K); 
jmiExit.setAccelerator( 
          KeyStroke.getKeyStroke(KeyEvent.VK_K, 
                                 InputEvent.CTRL_DOWN_MASK));
