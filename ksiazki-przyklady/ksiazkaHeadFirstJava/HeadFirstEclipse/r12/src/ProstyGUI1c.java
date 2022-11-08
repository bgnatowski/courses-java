import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProstyGUI1c implements ActionListener{
    JFrame ramka;
    
    public static void main(String[] args){
        ProstyGUI1c apGUI = new ProstyGUI1c();
        apGUI.doDziela();
    }
    
    public void doDziela(){
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton przycisk = new JButton("Zmiana koloru");
        przycisk.addActionListener(this);
        
        MojPanelRysunkowy panelR = new MojPanelRysunkowy();
        
        ramka.getContentPane().add(BorderLayout.SOUTH, przycisk);
        ramka.getContentPane().add(BorderLayout.CENTER, panelR);
        ramka.setSize(300, 300);
        ramka.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent zdarzenie){
        ramka.repaint();
    }
}