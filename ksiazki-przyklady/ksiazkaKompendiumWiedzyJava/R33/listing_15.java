// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Tworzy podmenu Uruchamianie, umieszczane w menu Opcje
// Elementy tego menu są tworzone na podstawie akcji
JMenu jmDebug = new JMenu("Uruchamianie"); 
JMenuItem jmiSetBP = new JMenuItem(setAct); 
JMenuItem jmiClearBP = new JMenuItem(clearAct); 
JMenuItem jmiResume = new JMenuItem(resumeAct); 
jmDebug.add(jmiSetBP); 
jmDebug.add(jmiClearBP); 
jmDebug.add(jmiResume); 
jmOptions.add(jmDebug);
