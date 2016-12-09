import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class PorownajKolekcje extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Vector<String> vectors = new Vector<String>();
	ArrayList<String> array = new ArrayList<String>();
	
	public PorownajKolekcje(){
		super("Bla bla");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		
		JPanel panel = new JPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}

	class WidokKolekcji extends JScrollPane{
		private static final long serialVersionUID = 1L;
		
		private JTable tabela;
		
		
	}
}
