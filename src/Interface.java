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
	private JLabel lblString;
	private JLabel lblString2;
	public JTextField textField;
	public JTextField textFiled2;
	private JLabel lblButtonClick; 
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextArea result;
	private JLabel result2;
	private Calculation calculation;

	Interface() {
		this.view();
		this.calculation = new Calculation();
	}

	public void see() {
		frame.setVisible(true);
	}

	private void view() { 
		frame = new JFrame("The Rest"); 
		frame.setSize(300, 430);
		frame.setLocation(700, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		this.lblString = new JLabel("Enter how much is Bill:"); 
		this.textField = new JTextField(10); 

		this.lblString2 = new JLabel("Enter how much is Cash:");
		this.textFiled2 = new JTextField(10);

		this.lblButtonClick = new JLabel();
		
		result = new JTextArea();	
		result2 = new JLabel();

		JButton button = new JButton("Enter"); 
		button.setPreferredSize(new Dimension(230,30));
		
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				lblButtonClick.setText(""); 
				label.setText(textField.getText().toString());
				
				lblButtonClick.setText("");
				label2.setText(textFiled2.getText().toString());

				BigDecimal bill = new BigDecimal(textField.getText().toString());
				BigDecimal client = new BigDecimal(textFiled2.getText().toString());

				String cashBack = calculation.return1(bill, client);
				String cashBack2 = calculation.return2(bill, client);
				
				result.setText(cashBack);
				result2.setText(cashBack2);
			}
		});

		panel = new JPanel();
		panel.setLayout(new FlowLayout()); 
		Color myColor = new Color(154, 208, 236);
		panel.setBackground(myColor);
		result.setBackground(myColor);

		label4 = new JLabel("     D°Rest     ");
		label4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));	
		panel.add(label4);
		panel.add(lblString); 
		 
		panel.add(textFiled2);
		panel.add(lblString2);
		panel.add(textField);

		panel.add(button);
		panel.add(lblButtonClick);
		
		label = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel("Vsota za vracilo : ");
			
		panel.add(label3);
		panel.add(result2);
		panel.add(result);
		
		result.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		result.setColumns(20);
		result.setRows(15);
		result.setLineWrap(true);	
		result.setWrapStyleWord(true);
		result.setEditable(false);
		
		frame.setResizable(false);
		frame.add(panel); 
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		Interface program = new Interface(); 
		program.see();
	}
}
