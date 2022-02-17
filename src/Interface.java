import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interface {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblVnesiNiz;
	private JLabel lblVnesiNiz2;
	public JTextField vnosnoPolje;
	public JTextField vnosnoPolje2;
	private JLabel lblGumbKlik; 
	private JLabel vnesenoBesedilo;
	private JLabel vnesenoBesedilo2;
	private JLabel vnesenoBesedilo3;
	private JLabel vnesenoBesedilo4;
	private JTextArea izracun;
	private JLabel izracun2;
	private Calculation blagajna;

	Interface() {
		this.pripraviUI();
		this.blagajna = new Calculation();
	}

	public void pokazi() {
		frame.setVisible(true);
	}

	private void pripraviUI() { 
		frame = new JFrame("The Rest"); 
		frame.setSize(300, 430);
		frame.setLocation(700, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		this.lblVnesiNiz = new JLabel("Vnesi znesek racuna:"); 
		this.vnosnoPolje = new JTextField(10); 

		this.lblVnesiNiz2 = new JLabel("Vnesi vplacano vsoto:");
		this.vnosnoPolje2 = new JTextField(10);

		this.lblGumbKlik = new JLabel();
		
		izracun = new JTextArea();	
		izracun2 = new JLabel();

		JButton gumb = new JButton("Izracunaj"); 
		gumb.setPreferredSize(new Dimension(230,30));
		
		gumb.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				lblGumbKlik.setText(""); 
				vnesenoBesedilo.setText(vnosnoPolje.getText().toString());
				
				lblGumbKlik.setText("");
				vnesenoBesedilo2.setText(vnosnoPolje2.getText().toString());

				BigDecimal racun = new BigDecimal(vnosnoPolje.getText().toString());
				BigDecimal vroceno = new BigDecimal(vnosnoPolje2.getText().toString());

				String zaVrniti = blagajna.drobiz(racun, vroceno);
				String zaVrniti2 = blagajna.VraDenarja(racun, vroceno);
				
				izracun.setText(zaVrniti);
				izracun2.setText(zaVrniti2);
			}
		});

		panel = new JPanel();
		panel.setLayout(new FlowLayout()); 
		Color myColor = new Color(154, 208, 236);
		panel.setBackground(myColor);
		izracun.setBackground(myColor);

		vnesenoBesedilo4 = new JLabel("     D°Rest     ");
		vnesenoBesedilo4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));	
		panel.add(vnesenoBesedilo4);
		panel.add(lblVnesiNiz); 
		panel.add(vnosnoPolje); 

		panel.add(lblVnesiNiz2);
		panel.add(vnosnoPolje2);

		panel.add(gumb);
		panel.add(lblGumbKlik);
		
		vnesenoBesedilo = new JLabel();
		vnesenoBesedilo2 = new JLabel();
		vnesenoBesedilo3 = new JLabel("Vsota za vracilo : ");
			
		panel.add(vnesenoBesedilo3);
		panel.add(izracun2);
		panel.add(izracun);
		
		izracun.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		izracun.setColumns(20);
		izracun.setRows(15);
		izracun.setLineWrap(true);	
		izracun.setWrapStyleWord(true);
		izracun.setEditable(false);
		
		frame.setResizable(false);
		frame.add(panel); 
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		Interface program = new Interface(); 
		program.pokazi();
	}
}
