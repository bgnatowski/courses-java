// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować

// Tworzy pasek narzędzi Uruchamianie
JToolBar jtb = new JToolBar("Uruchamianie"); 
 
// Wczytuje obrazki
ImageIcon set = new ImageIcon("setBP.gif"); 
ImageIcon clear = new ImageIcon("clearBP.gif"); 
ImageIcon resume = new ImageIcon("resume.gif"); 
 
// Tworzy przyciski paska narzędzi
JButton jbtnSet = new JButton(set); 
jbtnSet.setActionCommand("Ustaw punkt wstrzymania"); 
jbtnSet.setToolTipText("Ustaw punkt wstrzymania"); 
 
JButton jbtnClear = new JButton(clear);  
jbtnClear.setActionCommand("Usuń punkt wstrzymania"); 
jbtnClear.setToolTipText("Usuń punkt wstrzymania"); 
 
JButton jbtnResume = new JButton(resume); 
jbtnResume.setActionCommand("Wznów"); 
jbtnResume.setToolTipText("Wznów"); 
 
// Dodaje przyciski do paska narzędzi
jtb.add(jbtnSet); 
jtb.add(jbtnClear); 
jtb.add(jbtnResume); 
 
// Dodaje pasek narzędzi u góry obszaru zawartości
// (w pozycji określonej jako BorderLayout.NORTH)
jfrm.add(jtb, BorderLayout.NORTH);
