/*
	 *  Program demonstrujacy dzialanie kolekcji
	 *  HashSet, TreeSet, Vector, ArrayList, LinkedList.
	 *
	 *  Autor: Miko³aj Brukiewicz
	 *   Data: 10 grudzieñ 2016 r.
	 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PorownajKolekcje extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Vector<String> vectors = new Vector<String>();
	ArrayList<String> array = new ArrayList<String>();
	LinkedList<String> llist = new LinkedList<String>();
	HashSet<String> hash = new HashSet<String>();
	TreeSet<String> tree = new TreeSet<String>();
	
	WidokKolekcji widokVector;
	WidokKolekcji widokArray;
	WidokKolekcji widokLinked;
	WidokKolekcji widokHash;
	WidokKolekcji widokTree;
	
	JLabel etykieta_wartosc  = new JLabel("Wartosc:");
	JTextField pole_wartosc  = new JTextField(10);
	JButton przycisk_dodaj   = new JButton("Dodaj");
	JButton przycisk_usun    = new JButton("Usun");
	JButton przycisk_wyczysc = new JButton("Wyczysc");
	JButton przycisk_autor   = new JButton("Autor");
	
	public PorownajKolekcje(){
		super("Kolekcje");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,500);
		
		JPanel panel = new JPanel();
		panel.add(etykieta_wartosc);
		panel.add(pole_wartosc);
		przycisk_dodaj.addActionListener(this);
		panel.add(przycisk_dodaj);
		
		przycisk_wyczysc.addActionListener(this);
		panel.add(przycisk_wyczysc);
		
		przycisk_usun.addActionListener(this);
		panel.add(przycisk_usun);
		
		przycisk_autor.addActionListener(this);
		panel.add(przycisk_autor);
		
		widokVector = new WidokKolekcji(vectors, 150, 200, "Vector");
		panel.add(widokVector);
		widokArray = new WidokKolekcji(array, 150, 200, "ArreyList");
		panel.add(widokArray);
		widokLinked = new WidokKolekcji(llist, 150, 200, "LinkedList");
		panel.add(widokLinked);
		widokHash = new WidokKolekcji(hash, 150, 200, "HashSet");
		panel.add(widokHash);
		widokTree = new WidokKolekcji(tree, 150, 200, "TreeSet");
		panel.add(widokTree);
		
		setContentPane(panel);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String wartosc;
		Object zrodlo = e.getSource();
		
		if (zrodlo == przycisk_dodaj) {
			wartosc = pole_wartosc.getText();
			vectors.add( wartosc);
			array.add( wartosc);
			llist.add( wartosc);
			hash.add( wartosc);
			tree.add( wartosc);
			
		} else

		if (zrodlo == przycisk_wyczysc) {
			vectors.clear();
			array.clear();
			llist.clear();
			hash.clear();
			tree.clear();
		} else

		if (zrodlo == przycisk_usun) {
			wartosc = pole_wartosc.getText();
			vectors.remove(wartosc);
			array.remove(wartosc);
			llist.remove(wartosc);
			hash.remove(wartosc);
			tree.remove(wartosc);
		} else

		if (zrodlo == przycisk_autor) {
			JOptionPane.showMessageDialog(this,
					"Autor: Miko³aj Brukiewicz\nData: 10 grudzien 2016 r.");
		}

		widokVector.refresh();
		widokArray.refresh();
		widokLinked.refresh();
		widokHash.refresh();
		widokTree.refresh();
	}

	
	
	class WidokKolekcji extends JScrollPane{
		private static final long serialVersionUID = 1L;
		
		private JTable tabela;
		private DefaultTableModel model;
		private Collection<String> kolekcja;
		
		WidokKolekcji(Collection<String> kolekcja, int szerokosc, int wysokosc, String nazwa){
			String[] kolumny = {"Tekst"};
			model = new DefaultTableModel(kolumny, 0);
			tabela = new JTable(model);
			tabela.setRowSelectionAllowed(false);
			this.kolekcja = kolekcja;
			setViewportView(tabela);
			setPreferredSize(new Dimension(szerokosc, wysokosc));
			setBorder(BorderFactory.createTitledBorder(nazwa));
			}
		
			void refresh(){
		    	model.setRowCount(0);
				String[] wartosc = kolekcja.toArray(new String[0]);
				for(int x=0; x<kolekcja.size(); x++){
					String[] wiersz = {wartosc[x]};
					model.addRow(wiersz);
		    	}
			}
		
	}
	
	public static void main(String [] args){
		new PorownajKolekcje();
	}
	
	
}
