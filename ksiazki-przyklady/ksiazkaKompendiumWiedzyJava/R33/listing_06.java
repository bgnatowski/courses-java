// Uwaga - to jedynie fragment, który należy dodać do programu MenuDemo.java
// W takiej postaci fragmentu nie uda się poprawnie skompilować.

// Tworzenie menu podręcznego Edycja
jpu = new JPopupMenu(); 
 
// Tworzy elementy menu
JMenuItem jmiCut = new JMenuItem("Wytnij"); 
JMenuItem jmiCopy = new JMenuItem("Kopiuj"); 
JMenuItem jmiPaste = new JMenuItem("Wklej"); 
 
// Dodaje elementy do menu
jpu.add(jmiCut); 
jpu.add(jmiCopy); 
jpu.add(jmiPaste); 
 
// Dodaje obiekt nasłuchujący, który sprawdza wystąpienie warunku wyświetlenia menu 
jfrm.addMouseListener(new MouseAdapter() {  
  public void mousePressed(MouseEvent me) { 
    if(me.isPopupTrigger())  
      jpu.show(me.getComponent(), me.getX(), me.getY()); 
  }  
  public void mouseReleased(MouseEvent me) { 
    if(me.isPopupTrigger())  
      jpu.show(me.getComponent(), me.getX(), me.getY()); 
  }  
});
