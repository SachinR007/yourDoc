package mainPage;
import secondPage.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JTextField;

import AfterLogin.AftLogin;
import javax.swing.JPasswordField;

public class NewProject {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProject window = new NewProject();
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
	
	
	public NewProject() {
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
		
		JButton btnNewButton = new JButton("Forget Password\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(30, 340, 113, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecPage.main(null);
			}
		});
		btnSignup.setBounds(345, 340, 107, 28);
		frame.getContentPane().add(btnSignup);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {

				int flag=1;
			     String query="select name,passWord from customer where name=?";
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1,textField.getText());
			     ResultSet rs=stmt.executeQuery();
			    while(rs.next())
			     {
			      String name=rs.getString(1);
			      String pass=rs.getString(2);
			    
			      if(name.equals(textField.getText()) && pass.equals(passwordField.getText()))
		          {
		        	  textField.setText(null);
		        	  passwordField.setText(null);
						
						flag=0;
		          }
			
			     }
			    if(flag==0)
			      {
			    	  AftLogin.main(null);
			      }
		          else
		          {
		        	  JOptionPane.showMessageDialog(null, "Invalid login");
		          }   
			     
			   }//try
			   //catch(ClassNotFoundException e)
			    //{e.printStackTrace();}
			   catch(SQLException se) 
			     { se.printStackTrace();}


				
			}
		});
		button.setFont(new Font("DialogInput", Font.BOLD, 18));
		button.setActionCommand("Login\r\n");
		button.setBackground(Color.RED);
		button.setBounds(158, 286, 171, 35);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(64, 123, 356, 150);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(43, 37, 67, 25);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 40, 152, 20); 
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(43, 85, 67, 20);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 86, 152, 20);
		panel.add(passwordField);
	}
}
