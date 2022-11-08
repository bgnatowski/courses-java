import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimTest{
    JFrame ramka;
    int x = 70;
    int y = 70;
    
    public static void main(String[] args){
        AnimTest anim = new AnimTest();
        anim.doDziela();
    }
    
    public void doDziela(){
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MojPanelRysunkowyAnim panelAnim = new MojPanelRysunkowyAnim();
        ramka.getContentPane().add(panelAnim);
        
        ramka.setSize(300, 300);
        ramka.setVisible(true);
        
        for (int i = 0; i< 130; i++){
            x++;
            y++;
            
            panelAnim.repaint();
            
            try{
                Thread.sleep(50);
            } catch (Exception ex) { }
        }
    }
    
    class MojPanelRysunkowyAnim extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(), this.getHeight());
            
            g.setColor(Color.orange);
            g.fillOval(x,y,40,40);
        }
    }

}