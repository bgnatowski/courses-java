import java.awt.*;
import javax.swing.*;

class MojPanelGraficznyTester{
    public static void main(String[] args){
        MojPanelGraficznyTester gui = new MojPanelGraficznyTester();
        gui.doRoboty();
    }
    
    public void doRoboty(){
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MojPanelGraficzny panel = new MojPanelGraficzny();
        
        ramka.getContentPane().add(panel);
        ramka.setSize(300,300);
        ramka.setVisible(true);
    }
}

class MojPanelGraficzny extends JPanel{
    public void paintComponent(Graphics g){
//        g.setColor(Color.orange);
//        g.fillRect(20, 50, 100, 100);
//        Image obrazek = new ImageIcon("ROCZEK.jpg").getImage();
//        g.drawImage(obrazek, 3,4,this);
        
//        g.fillRect(0,0,this.getWidth(),this.getHeight());
//        
//        int czerwony = (int) (Math.random()*256);
//        int zielony = (int) (Math.random()*256);
//        int niebieski = (int) (Math.random()*256);
//        Color kolorLosowy = new Color(czerwony, zielony, niebieski);
        
//        g.setColor(kolorLosowy);
//        g.drawLine(4,4,150, 90);
        
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