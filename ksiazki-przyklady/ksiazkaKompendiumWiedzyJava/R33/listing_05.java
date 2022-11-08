// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować

// Utworzenie menu Opcje
JMenu jmOptions = new JMenu("Opcje"); 
 
// Utworzenie podmenu Kolory
JMenu jmColors = new JMenu("Kolory"); 
 
// Tworzy elementy menu z polami wyboru i dodaje je do podmenu Kolory, dzięki
// czemu użytkownik będzie mógł wybrać więcej niż jeden kolor
JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Czerwony"); 
JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Zielony"); 
JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Niebieski"); 
 
jmColors.add(jmiRed); 
jmColors.add(jmiGreen); 
jmColors.add(jmiBlue); 
jmOptions.add(jmColors); 
 
// Utworzenie podmenu Priorytet
JMenu jmPriority = new JMenu("Priorytet"); 
 
// Tworzy elementy menu z przyciskami opcji i dodaje je do menu Priorytet;
// w ten sposób możemy pokazać aktualnie wybrany priorytet,
// a jednocześnie mamy pewność, że w dowolnej chwili będzie wybrany
// tylko jeden priorytet; warto zwrócić uwagę, że początkowo zostanie
// zaznaczona opcja „Wysoki”
JRadioButtonMenuItem jmiHigh = 
  new JRadioButtonMenuItem("Wysoki", true); 
JRadioButtonMenuItem jmiLow = 
  new JRadioButtonMenuItem("Niski"); 
 
jmPriority.add(jmiHigh); 
jmPriority.add(jmiLow); 
jmOptions.add(jmPriority); 
 
// Tworzy grupę przycisków dla elementów menu zawierających przyciski opcji
ButtonGroup bg = new ButtonGroup(); 
bg.add(jmiHigh); 
bg.add(jmiLow); 
 
// Utworzenie opcji Resetuj
JMenuItem jmiReset = new JMenuItem("Resetuj"); 
jmOptions.addSeparator(); 
jmOptions.add(jmiReset); 
 
// I na koniec dodaje całe menu Opcje do paska menu
jmb.add(jmOptions);
