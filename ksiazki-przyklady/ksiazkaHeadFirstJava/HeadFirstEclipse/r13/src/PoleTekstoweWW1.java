import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class PoleTekstoweWW1 {
	
	JTextArea tekst;
	
	public static void main(String[] args) {
		PoleTekstoweWW1 gui = new PoleTekstoweWW1();
		gui.tworzGUI();
	}
	
	public void tworzGUI() {
		JFrame ramka = new JFrame();
		JPanel panel = new JPanel();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JButton przycisk = new JButton("Po prostu kliknij");
		//przycisk.addActionListener(this);
		//tekst = new JTextArea(20,10);
		//tekst.setLineWrap(true);
		
		//JScrollPane przewijanie = new JScrollPane(tekst);
		//przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//panel.add(przewijanie);
		
		//ramka.getContentPane().add(BorderLayout.CENTER,panel);
		//ramka.getContentPane().add(BorderLayout.SOUTH,przycisk);	
		
		String[] listaOpcji = {"alfa", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "teta"};
		
		JList<String> lista = new JList<String>(listaOpcji);
		
		JScrollPane przewijanie2 = new JScrollPane(lista);
		przewijanie2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		przewijanie2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(przewijanie2);
		
		ramka.getContentPane().add(BorderLayout.CENTER,panel);
		
		lista.setVisibleRowCount(6);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.addListSelectionListener(new ListaListener(lista));
		
		ramka.setSize(350, 300);
		ramka.setVisible(true);
		
		}
	
	class ListaListener implements ListSelectionListener{
		JList<String> lista_wewnetrzna;
		
		ListaListener(JList<String> listakopia){
			lista_wewnetrzna = listakopia;
		}
		
		public void valueChanged(ListSelectionEvent zdarzenie) {
			if(!zdarzenie.getValueIsAdjusting()) {
				System.out.println(lista_wewnetrzna.getSelectedValue());
			}
		}
	}	
}
