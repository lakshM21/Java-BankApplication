import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class upi extends JFrame {

	private JPanel contentPane;
	private JTextField mobv;
	private JTextField upi1;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public upi(String un,String passv) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBounds(788, 0, 51, 47);
		contentPane.add(btnX);
		
		mobv = new JTextField();
		mobv.setEditable(false);
		mobv.setInheritsPopupMenu(true);
		mobv.setBackground(new Color(0, 255, 153));
		mobv.setBounds(400, 181, 214, 31);
		contentPane.add(mobv);
		mobv.setColumns(10);
		
		upi1 = new JTextField();
		upi1.setColumns(10);
		upi1.setBounds(400, 240, 214, 31);
		contentPane.add(upi1);
		
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(new Color(255, 255, 255));
		btnDone.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnDone.setBackground(new Color(0, 0, 0));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					int cv1;
					String cv2 = upi1.getText();
					cv1=Integer.parseInt(upi1.getText());
					
					if(!(upi1.equals("")))
					{
						String sql=String.format("update customer set UPI_id='%d' where Username = '%s' and Password = '%s'",cv1,un,passv);
						stmt.executeUpdate(sql);
						con.close();
						JOptionPane.showMessageDialog(null,String.format("UPI Generated Sucessfully!!!!"));
						op1 obj2 = new op1(un,passv);
						setVisible(false);
						obj2.setVisible(true);

					}
					else {
						JOptionPane.showMessageDialog(null,"\n'Wrong Input !!!'");		
						upi1.setText("");
					}
				}
					catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"\n'ERROR !!!'");
					upi1.setText("");
				}
				
			}
		});
		btnDone.setBounds(345, 337, 165, 47);
		contentPane.add(btnDone);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\upi.PNG"));
		lblNewLabel.setBounds(0, 0, 839, 543);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				mobv.setText(rs.getString(3));
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	
	}

}
