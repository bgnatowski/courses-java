import javax.swing.*;
import java.awt.*;

class MojPanelRysunkowy extends JPanel{
    public void paintComponent(Graphics g){
         Graphics2D g2a = (Graphics2D) g;
        
        int czerwony = (int) (Math.random()*256);
        int zielony = (int) (Math.random()*256);
        int niebieski = (int) (Math.random()*256);
        Color kolorPoczatku = new Color(czerwony, zielony, niebieski);
        
        czerwony = (int) (Math.random()*256);
        zielony = (int) (Math.random()*256);
        niebieski = (int) (Math.random()*256);
        Color kolorKonca = new Color(czerwony, zielony, niebieski);
        
        GradientPaint gradient = new GradientPaint(70,70, kolorPoczatku, 100,150, kolorKonca);
        g2a.setPaint(gradient);
        g2a.fillOval(70,70,100,100);
    }
}