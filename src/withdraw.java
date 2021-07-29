import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
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

public class withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField usrnm;
	private JTextField acno;
	private JTextField amt;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public withdraw(String un,String passv) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		usrnm = new JTextField();
		usrnm.setBorder(null);
		usrnm.setEditable(false);
		usrnm.setBackground(new Color(0, 102, 204));
		usrnm.setFont(new Font("Verdana", Font.BOLD, 15));
		usrnm.setBounds(414, 154, 160, 28);
		contentPane.add(usrnm);
		usrnm.setColumns(10);
		
		acno = new JTextField();
		acno.setBorder(null);
		acno.setEditable(false);
		acno.setBackground(new Color(0, 102, 255));
		acno.setFont(new Font("Verdana", Font.BOLD, 15));
		acno.setBounds(382, 223, 192, 34);
		contentPane.add(acno);
		acno.setColumns(10);
		
		
		
		amt = new JTextField();
		amt.setColumns(10);
		amt.setBounds(382, 299, 192, 34);
		contentPane.add(amt);
		
		JButton btnwithdraw = new JButton("Withdraw");
		btnwithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					String nam,acn;
					int bala = 0;
					long dpa; 
					nam=usrnm.getText();
					acn=acno.getText();
					dpa=Long.parseLong(amt.getText());
					String sql1=String.format("select * from customer where Account_No='%s'and Username='%s'",acn,nam);
					ResultSet rs=stmt.executeQuery(sql1);
					if(rs.next())
					{
						bala = rs.getInt(4);
					}

					if(bala!=0)
					{	String sql=String.format("update customer set Balance=Balance-%d where Account_No='%s'and Username='%s'",dpa,acn,nam);
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,String.format("Rs %d is debited from your account.",dpa));
						amt.setText("");
					}
					else 
						JOptionPane.showMessageDialog(null,"Insufficient Balance");	

					con.close();
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"\n'Wrong Input !!!'");	
					amt.setText("");
					
				}
			}
		});
		btnwithdraw.setBackground(new Color(0, 0, 0));
		btnwithdraw.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnwithdraw.setForeground(new Color(255, 255, 255));
		btnwithdraw.setBounds(311, 384, 185, 55);
		contentPane.add(btnwithdraw);
		
		JButton btnX = new JButton("X");
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setBounds(790, 0, 49, 44);
		contentPane.add(btnX);
		
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
		btnBack.setBounds(533, 395, 99, 34);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\Addmon.PNG"));
		lblNewLabel.setBounds(0, 0, 839, 540);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				usrnm.setText(rs.getString(10));
				acno.setText(rs.getString(3));
				
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	
	}
}
