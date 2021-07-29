import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class info extends JFrame {

	private JPanel contentPane;
	private JTextField nm;
	private JTextField mob;
	private JTextField acno;
	private JTextField bal;
	private JTextField dob;
	private JTextField bname;
	private JTextField brnm;
	private JButton btnBackToHome;
	private JButton btnX;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public info(String un,String passv) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		nm = new JTextField();
		nm.setFont(new Font("Verdana", Font.BOLD, 14));
		nm.setBorder(null);
		nm.setEditable(false);
		nm.setBackground(new Color(102, 255, 153));
		nm.setBounds(311, 135, 291, 28);
		contentPane.add(nm);
		nm.setColumns(10);
		
		mob = new JTextField();
		mob.setFont(new Font("Verdana", Font.BOLD, 14));
		mob.setBorder(null);
		mob.setEditable(false);
		mob.setBackground(new Color(102, 255, 153));
		mob.setColumns(10);
		mob.setBounds(311, 177, 291, 28);
		contentPane.add(mob);
		
		acno = new JTextField();
		acno.setBorder(null);
		acno.setFont(new Font("Verdana", Font.BOLD, 14));
		acno.setEditable(false);
		acno.setBackground(new Color(102, 255, 153));
		acno.setColumns(10);
		acno.setBounds(311, 227, 291, 28);
		contentPane.add(acno);
		
		bal = new JTextField();
		bal.setFont(new Font("Verdana", Font.BOLD, 14));
		bal.setBorder(null);
		bal.setEditable(false);
		bal.setBackground(new Color(102, 255, 153));
		bal.setColumns(10);
		bal.setBounds(311, 268, 291, 28);
		contentPane.add(bal);
		
		dob = new JTextField();
		dob.setFont(new Font("Verdana", Font.BOLD, 14));
		dob.setBorder(null);
		dob.setEditable(false);
		dob.setBackground(new Color(102, 255, 153));
		dob.setColumns(10);
		dob.setBounds(311, 309, 291, 28);
		contentPane.add(dob);
		
		bname = new JTextField();
		bname.setFont(new Font("Verdana", Font.BOLD, 14));
		bname.setBorder(null);
		bname.setEditable(false);
		bname.setBackground(new Color(102, 255, 153));
		bname.setColumns(10);
		bname.setBounds(311, 360, 291, 28);
		contentPane.add(bname);
		
		brnm = new JTextField();
		brnm.setBorder(null);
		brnm.setFont(new Font("Verdana", Font.BOLD, 14));
		brnm.setEditable(false);
		brnm.setBackground(new Color(102, 255, 153));
		brnm.setColumns(10);
		brnm.setBounds(311, 401, 291, 28);
		contentPane.add(brnm);
		
		btnBackToHome = new JButton("Back to Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op1 obj1 = new op1(un,passv);
				setVisible(false);
				obj1.setVisible(true);
			}
		});
		btnBackToHome.setBackground(new Color(0, 0, 0));
		btnBackToHome.setForeground(new Color(255, 255, 255));
		btnBackToHome.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnBackToHome.setBounds(311, 452, 184, 52);
		contentPane.add(btnBackToHome);
		
		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setBounds(783, 0, 56, 52);
		contentPane.add(btnX);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\info.PNG"));
		lblNewLabel.setBounds(0, 0, 839, 538);
		contentPane.add(lblNewLabel);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				nm.setText(rs.getString(1));
				mob.setText(rs.getString(2));
				acno.setText(rs.getString(3));
				bal.setText("Rs "+String.valueOf(rs.getInt(4)));
				dob.setText(rs.getString(5));
				bname.setText(rs.getString(6));
				brnm.setText(rs.getString(7));
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	}
}
