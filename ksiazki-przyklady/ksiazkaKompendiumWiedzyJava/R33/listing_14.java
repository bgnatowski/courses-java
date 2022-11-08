// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Tworzy przyciski paska narzędzi na podstawie akcji
JButton jbtnSet = new JButton(setAct); 
JButton jbtnClear = new JButton(clearAct); 
JButton jbtnResume = new JButton(resumeAct); 
  
// Tworzy pasek narzędzi Uruchamianie
JToolBar jtb = new JToolBar("Uruchamianie");  
 
// Dodaje przyciski do paska narzędzi
jtb.add(jbtnSet);  
jtb.add(jbtnClear);  
jtb.add(jbtnResume);  
 
// Dodaje pasek narzędzi u góry obszaru zawartości
// (w pozycji określonej jako BorderLayout.NORTH)
jfrm.add(jtb, BorderLayout.NORTH);
