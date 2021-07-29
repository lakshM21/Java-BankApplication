import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
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

public class card3 extends JFrame {

	private JPanel contentPane;
	private JTextField crdno;
	private JTextField crnm;
	private JTextField cv;

	
	


	public card3(String un, String passv) {
		// TODO Auto-generated constructor stub
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		crdno = new JTextField();
		crdno.setFont(new Font("Verdana", Font.BOLD, 14));
		crdno.setEditable(false);
		crdno.setBorder(null);
		crdno.setBackground(new Color(255, 153, 102));
		crdno.setBounds(225, 216, 225, 31);
		contentPane.add(crdno);
		crdno.setColumns(10);
		
		crnm = new JTextField();
		crnm.setFont(new Font("Verdana", Font.BOLD, 14));
		crnm.setBorder(null);
		crnm.setEditable(false);
		crnm.setColumns(10);
		crnm.setBackground(new Color(255, 153, 102));
		crnm.setBounds(225, 274, 214, 31);
		contentPane.add(crnm);
		
		cv = new JTextField();
		cv.setFont(new Font("Verdana", Font.BOLD, 14));
		cv.setEditable(false);
		cv.setBorder(null);
		cv.setBackground(new Color(255, 153, 102));
		cv.setBounds(535, 360, 59, 22);
		contentPane.add(cv);
		cv.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 obj = new op1(un,passv);
				setVisible(false);
				obj.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setBounds(341, 424, 161, 51);
		contentPane.add(btnNewButton);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnX.setBounds(767, 0, 59, 38);
		contentPane.add(btnX);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\card3.PNG"));
		lblNewLabel.setBounds(0, 0, 826, 539);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				crdno.setText(rs.getString(8));
				crnm.setText(rs.getString(1));
				cv.setText(rs.getString(9));
				
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	
		
	}
}
