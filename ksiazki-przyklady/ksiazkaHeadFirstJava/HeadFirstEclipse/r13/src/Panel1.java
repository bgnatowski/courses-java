import javax.swing.*;
import java.awt.*;

public class Panel1 {
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.doRoboty();
	}
	
	public void doRoboty() {
		JFrame ramka = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JTextField pole = new JTextField(20);
		JTextField pole2 = new JTextField("Podaj nazwisko");
		
		panel.add(pole);
		panel.add(pole2);
		
		JTextArea tekst = new JTextArea(10,20);
		
		JScrollPane przewijanie = new JScrollPane(tekst);
		tekst.setLineWrap(true); //wlaczamy przenoszenie wyrazow do kolejnego wiersza
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(przewijanie);
		
		tekst.setText("Nie wszyscy zgubieni błądzą");
		tekst.setText("nowy tekst");
		tekst.append(" dodany tekst");
		tekst.selectAll();
		tekst.requestFocus();
		
		/*
		 * JButton przycisk = new JButton("To szok!"); JButton przycisk2 = new
		 * JButton("Trach!"); JButton przycisk3 = new JButton("Och?!"); JButton
		 * przycisk4 = new JButton("czwarty"); JButton przycisk5 = new
		 * JButton("piaty!"); JButton przycisk6 = new JButton("szosty");
		 * 
		 * panel.add(przycisk); panel.add(przycisk2); panel.add(przycisk3);
		 * panel.add(przycisk4); panel.add(przycisk5); panel.add(przycisk6);
		 */
		ramka.getContentPane().add(BorderLayout.EAST, panel);
		ramka.setSize(500,500);
		ramka.setResizable(true);
		ramka.setVisible(true);
		
		
	}
}
