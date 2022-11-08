// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Tworzy akcje
setAct = 
  new DebugAction("Ustaw punkt wstrzymania", 
                  setIcon, 
                  KeyEvent.VK_U, 
                  KeyEvent.VK_U, 
                  "Ustawia punkt wstrzymania."); 
 
clearAct = 
  new DebugAction("Usuń punkt wstrzymania", 
                  clearIcon, 
                  KeyEvent.VK_S, 
                  KeyEvent.VK_S, 
                  "Usuwa punkt wstrzymania."); 
 
resumeAct = 
  new DebugAction("Wznów", 
                  resumeIcon, 
                  KeyEvent.VK_W, 
                  KeyEvent.VK_W, 
                  "Wznawia wykonywanie programu."); 
 
// Początkowo wyłącza opcję Usuń punkt wstrzymania
clearAct.setEnabled(false);
