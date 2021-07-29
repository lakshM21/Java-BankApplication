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

public class card2 extends JFrame {

	private JPanel contentPane;
	private JTextField acn;
	private JTextField cdno;
	private JTextField cv;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public card2(String un,String passv) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		acn = new JTextField();
		acn.setBorder(null);
		acn.setEditable(false);
		acn.setBackground(new Color(0, 255, 153));
		acn.setFont(new Font("Verdana", Font.BOLD, 15));
		acn.setBounds(381, 113, 225, 36);
		contentPane.add(acn);
		acn.setColumns(10);
		
		cdno = new JTextField();
		cdno.setFont(new Font("Verdana", Font.BOLD, 14));
		cdno.setColumns(10);
		cdno.setBounds(381, 181, 225, 36);
		contentPane.add(cdno);
		
		cv = new JTextField();
		cv.setFont(new Font("Verdana", Font.BOLD, 14));
		cv.setColumns(10);
		cv.setBounds(381, 246, 225, 36);
		contentPane.add(cv);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op1 obj2 = new op1(un,passv);
				setVisible(false);
				obj2.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(0, 0, 0));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnBack.setBounds(255, 355, 163, 52);
		contentPane.add(btnBack);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					String crdn;
					String cv2;
					cv2=cv.getText();
					int cv1;
					crdn=cdno.getText();
					cv1=Integer.parseInt(cv.getText());
					if(!(cdno.equals("") && cv2.equals("")))
					{
						String sql=String.format("update customer set Card_no='%s' where Username = '%s' and Password = '%s'",crdn,un,passv);
						stmt.executeUpdate(sql);
						String sql3=String.format("update customer set Cvv='%d' where Username = '%s' and Password = '%s'",cv1,un,passv);
						stmt.executeUpdate(sql3);
						con.close();
						JOptionPane.showMessageDialog(null,"Card Generated Sucessfully!!!!");
						op1 obj2 = new op1(un,passv);
						setVisible(false);
						obj2.setVisible(true);

					}
					else {
						JOptionPane.showMessageDialog(null,"\n'Wrong Input !!!'");		
						
						cdno.setText("");
						cv.setText("");
					}
				}
					catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"\n'ERROR !!!'");
					cdno.setText("");
					cv.setText("");
				}
			}
			
		} );
		btnDone.setBackground(new Color(0, 0, 0));
		btnDone.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnDone.setForeground(new Color(255, 255, 255));
		btnDone.setBounds(472, 355, 163, 52);
		contentPane.add(btnDone);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setBounds(792, 0, 52, 45);
		contentPane.add(btnX);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\card2.PNG"));
		lblNewLabel.setBounds(0, 0, 844, 545);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
			Statement stmt=con.createStatement();		
			String sql=String.format("select * from customer where UserName='%s' and Password='%s'",un,passv);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				acn.setText(rs.getString(3));
			}
			}catch(Exception e)
			{
			  JOptionPane.showMessageDialog(null,e+"\n'Error !!!'");
			}
	
	}

}
