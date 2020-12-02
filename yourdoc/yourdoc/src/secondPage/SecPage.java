package secondPage;
import java.sql.*; 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainPage.ConnectionYourdoc;
import mainPage.NewProject;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SecPage {

	PreparedStatement stmt=null;
	String query=null;
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecPage window = new SecPage();
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
	
	Connection con=null;
	public SecPage() {
		initialize();
		con=ConnectionYourdoc.conn();//connection created.
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
		
		JLabel Label1 = new JLabel("YourDoc");
		Label1.setBackground(new Color(205, 133, 63));
		Label1.setFont(new Font("Forte", Font.BOLD, 52));
		Label1.setForeground(new Color(128, 0, 0));
		Label1.setBounds(118, 11, 255, 150);
		frame.getContentPane().add(Label1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(10, 132, 464, 268);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserName\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(93, 40, 67, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(93, 96, 67, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ContactNo");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(93, 159, 67, 25);
		panel.add(lblNewLabel_1_2);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(184, 42, 152, 25);
		panel.add(textField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(184, 157, 152, 25);
		panel.add(textField_3);
		Button button = new Button("SignUp");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
				   {
				   Class.forName("oracle.jdbc.driver.OracleDriver");
				   con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","lenovo","1234");    
				   query="insert into customer values(?,?,?)";
				   stmt=con.prepareStatement(query);
				   stmt.setString(1,textField.getText() );
				   stmt.setString(2,passwordField.getText());
				   stmt.setString(3, textField_3.getText());
				   stmt.executeUpdate();
				   
				   }//try
				   catch(ClassNotFoundException ce)
				    {ce.printStackTrace();}
				   catch(SQLException se) 
				     { se.printStackTrace();}
				   finally
				    {
				      try
				       {
				        if(stmt!=null)
				          stmt.close();
				        if(con!=null)
				          con.close();
				       }
				      catch(SQLException se){se.printStackTrace();}
				    }

				NewProject.main(null);
			}
		});
		button.setFont(new Font("DialogInput", Font.BOLD, 18));
		button.setBackground(new Color(0, 191, 255));
		button.setBounds(148, 211, 171, 35);
		panel.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 101, 152, 25);
		panel.add(passwordField);
		
	}

}
