import javax.swing.*;
import java.awt.*;

public class Animacja {
	int x = 1; 
	int y = 1;
	
	public static void main(String[] args) {
		Animacja gui = new Animacja();
		gui.doRoboty();
	}
	
	private void doRoboty() {
		JFrame ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MojPanelAnim panelA = new MojPanelAnim();
		ramka.getContentPane().add(panelA);
		ramka.setSize(500, 270);
		ramka.setVisible(true);
		
		for (int i = 0; i<124; i++,x++, y++) {
			x++;
			panelA.repaint();
			
			try { 
				Thread.sleep(50);
			} catch (Exception ex) { }
		}
	}
	
	@SuppressWarnings("serial")
	public class MojPanelAnim extends JPanel{
		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 250);
			g.setColor(Color.blue);
			g.fillRect(x,y,500-x*2,250-y*2);
		}
	}
}
