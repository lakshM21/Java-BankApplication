import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class transfer extends JFrame {

	private JPanel contentPane;
	private JTextField umob;
	private JTextField rmob;
	private JTextField amt;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public transfer(String un,String passv) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		umob = new JTextField();
		umob.setBorder(null);
		umob.setEditable(false);
		umob.setBackground(new Color(0, 102, 255));
		umob.setFont(new Font("Verdana", Font.BOLD, 15));
		umob.setBounds(396, 137, 178, 28);
		contentPane.add(umob);
		umob.setColumns(10);
		
		rmob = new JTextField();
		rmob.setFont(new Font("Verdana", Font.BOLD, 15));
		rmob.setColumns(10);
		rmob.setBounds(396, 211, 178, 28);
		contentPane.add(rmob);
		
		amt = new JTextField();
		amt.setFont(new Font("Verdana", Font.BOLD, 15));
		amt.setColumns(10);
		amt.setBounds(396, 280, 178, 28);
		contentPane.add(amt);
		
		pass = new JPasswordField();
		pass.setBorder(null);
		pass.setEditable(false);
		pass.setBackground(new Color(0, 102, 204));
		pass.setFont(new Font("Verdana", Font.BOLD, 15));
		pass.setBounds(396, 344, 178, 28);
		contentPane.add(pass);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBounds(783, 0, 55, 42);
		contentPane.add(btnX);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					String mob1,mob2;				
					long amt1; 
					int bala=0;
					mob2=rmob.getText();
					mob1=umob.getText();
					amt1=Long.parseLong(amt.getText());				
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
						Statement stmt=con.createStatement();
						String sql3=String.format("select * from customer where Mobile_no = '%s'",mob2);
						ResultSet rs1=stmt.executeQuery(sql3);
						if(rs1.next())
						{	
							String nm=rs1.getString(1);
							String sql2=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
							ResultSet rs=stmt.executeQuery(sql2);
							if(rs.next())
							{
								bala = rs.getInt(4);
							}
							
							if(bala>=amt1)
							{
								String sql1=String.format("update customer set Balance=Balance+%d where Mobile_no ='%s'",amt1,mob2);
								stmt.executeUpdate(sql1);
								sql1=String.format("update customer set Balance=Balance-%d where Mobile_no ='%s'",amt1,mob1);
								stmt.executeUpdate(sql1);
								JOptionPane.showMessageDialog(null,String.format("Rs%d is transfered to %s ",amt1,nm));	
								rmob.setText("");
								amt.setText("");

							}
								else
									JOptionPane.showMessageDialog(null,"UNSUFFICIENT BALANCE!!!");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"\n'INVALID RECEIVER'S NUMBER'");	
							rmob.setText("");
						}
						
	
						con.close();
				}
							
				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e+"Invalid Details.");
						
						amt.setText("");
					}
				
			}
		});
		btnTransfer.setBackground(new Color(0, 0, 0));
		btnTransfer.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnTransfer.setForeground(new Color(255, 255, 255));
		btnTransfer.setBounds(308, 416, 183, 53);
		contentPane.add(btnTransfer);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op1 obj = new op1(un,passv);
				setVisible(false);
				obj.setVisible(true);
			}
		});
		btnBack.setBounds(535, 425, 99, 34);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\transfer.PNG"));
		lblNewLabel.setBounds(0, 0, 838, 545);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				umob.setText(rs.getString(2));
				pass.setText(rs.getString(11));
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	}
}
