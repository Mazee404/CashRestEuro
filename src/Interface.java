import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
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

	private JLabel lblTitle;
	private JLabel lblString;
	private JLabel lblString2;

	public JTextField textField;
	public JTextField textField2;
	private JLabel lblButtonClick; 

	private JLabel label;
	private JLabel label2;
	private JLabel lblResult;
	
	private JTextArea result2;
	private JLabel result;
	private Calculation calculation;

	Interface() {
		this.view();
		this.calculation = new Calculation();
	}

	public void open() {
		frame.setVisible(true);
	}

	private void view() { 
		frame = new JFrame("The Rest"); 
		frame.setSize(300, 440);
		frame.setLocation(700, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		Color myColor = new Color(154, 208, 236);

		lblTitle = new JLabel("         D°Rest         ");
		lblTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));	

		lblString = new JLabel("Bill amount:"); 
		lblString.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		
		textField = new JTextField(7); 
		label = new JLabel();

		lblString2 = new JLabel("Cash amount:");
		lblString2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		
		textField2 = new JTextField(7);
		label2 = new JLabel();

		lblButtonClick = new JLabel();

		lblResult = new JLabel("Cash to return : ");
		result = new JLabel();

		result2 = new JTextArea();	
		
		JButton button = new JButton("Enter"); 
		button.setPreferredSize(new Dimension(230,30));
		
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				lblButtonClick.setText(""); 
				label.setText(textField.getText().toString());
				
				lblButtonClick.setText("");
				label2.setText(textField2.getText().toString());

				BigDecimal bill = new BigDecimal(textField.getText().toString());
				BigDecimal client = new BigDecimal(textField2.getText().toString());

				String cashBack2 = calculation.return1(bill, client);
				String cashBack = calculation.return2();
				
				result.setText(cashBack);
				result2.setText(cashBack2);
			}
		});

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(myColor);

		panel.add(lblTitle);

		panel.add(lblString); 		 
		panel.add(textField);
		
		panel.add(lblString2);
		panel.add(textField2);	

		panel.add(button);
		panel.add(lblButtonClick);
					
		panel.add(lblResult);
		panel.add(result);

		result2.setBackground(myColor);
		result2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		result2.setColumns(20);
		result2.setRows(15);
		result2.setLineWrap(true);	
		result2.setWrapStyleWord(true);
		result2.setEditable(false);		
		panel.add(result2);

		textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			  char c = e.getKeyChar();
			  if (!(Character.isDigit(c) ||
				 (c == KeyEvent.VK_BACK_SPACE) ||
				 (c == KeyEvent.VK_DELETE)||
				 (c == KeyEvent.VK_PERIOD))) {
				   e.consume();
				 }
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});

		textField2.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			  char c = e.getKeyChar();
			  if (!(Character.isDigit(c) ||
				 (c == KeyEvent.VK_BACK_SPACE) ||
				 (c == KeyEvent.VK_DELETE)||
				 (c == KeyEvent.VK_PERIOD))) {
				   e.consume();
				 }
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});

		frame.add(panel); 
		frame.setResizable(false);	
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		Interface program = new Interface(); 
		program.open();
	}
}
