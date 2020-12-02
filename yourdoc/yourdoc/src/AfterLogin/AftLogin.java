package AfterLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import mainPage.ConnectionYourdoc;
import searching.Search;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AftLogin<E> {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AftLogin window = new AftLogin();
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
	public AftLogin() {
		con=ConnectionYourdoc.conn();//connection created.
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
		
		JLabel Label1 = new JLabel("YourDoc");
		Label1.setForeground(new Color(128, 0, 0));
		Label1.setFont(new Font("Forte", Font.BOLD, 52));
		Label1.setBackground(new Color(205, 133, 63));
		Label1.setBounds(113, 11, 255, 150);
		frame.getContentPane().add(Label1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(27, 134, 427, 237);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Specialization");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 55, 123, 39);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(184, 62, 166, 28);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Locality");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(52, 108, 123, 39);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 115, 166, 28);
		panel.add(textField_1);
		
		Button button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter anything");
				}
				else
				{
				Search.main(null);
				try {

					
				     String query="select  *from doctor d,hospital h where d.hospital_id=h.hospital_id and hospital_address=? and specialization=? ";
						PreparedStatement stmt=con.prepareStatement(query);
						stmt.setString(2,textField.getText());
						stmt.setString(1,textField_1.getText());
				     ResultSet rs=stmt.executeQuery();
				     ResultSetMetaData rm=rs.getMetaData();
				     int cc=rm.getColumnCount();
				     Vector cols=new Vector();
				     for(int j=1;j<=cc;j++)
				     {
				    	 cols.addElement(rm.getColumnName(j));
				    	 
				     }
				     DefaultTableModel dm=new DefaultTableModel();
				     dm.setColumnIdentifiers(cols);
				     
				     while(rs.next())
				     {
				    	 Vector row=new Vector();
				    	 for(int i=1;i<=cc;i++)
				    	 {
				    		 row.addElement(rs.getString(i));
				    	 }
				      dm.addRow(row);
				       Search sc=new Search();
				       sc.table.setModel(dm);
				     }
				   }//try
				   //catch(ClassNotFoundException e)
				    //{e.printStackTrace();}
				   catch(SQLException se) 
				     { se.printStackTrace();}

			}
		}});
		button.setFont(new Font("DialogInput", Font.BOLD, 18));
		button.setBackground(new Color(124, 252, 0));
		button.setBounds(121, 172, 171, 35);
		panel.add(button);
	}

}
