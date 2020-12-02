package searching;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Search {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblTime;
	private JTextField textField_2;
	private Button button;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setBounds(500, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("For appointment enter details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 190, 250, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Doctor ID");
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(38, 257, 143, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(38, 291, 191, 27);
		frame.getContentPane().add(textField);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(10, 251, 464, 149);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		lblNewLabel.setBounds(258, 31, 62, 25);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 32, 144, 25);
		panel.add(textField_1);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		lblTime.setBounds(258, 67, 62, 25);
		panel.add(lblTime);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(296, 67, 144, 25);
		panel.add(textField_2);
		
		button = new Button("Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("DialogInput", Font.BOLD, 18));
		button.setBackground(new Color(127, 255, 212));
		button.setBounds(161, 108, 106, 25);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 464, -155);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
