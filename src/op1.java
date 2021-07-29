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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class op1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public op1(String un,String passv) {
		transfer obj5 = new transfer(un,passv);

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setBackground(Color.BLACK);
		btnX.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(791, 0, 49, 56);
		contentPane.add(btnX);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login obj = new login();
				setVisible(false);
				obj.setVisible(true);
			}
		});
		btnLogout.setBounds(230, 456, 139, 38);
		contentPane.add(btnLogout);
		
		JButton btnNewButton = new JButton("ADD Money");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addmon obj1 = new addmon(un,passv);
				setVisible(false);
				obj1.setVisible(true);
			}
		});
		btnNewButton.setBounds(44, 76, 202, 56);
		contentPane.add(btnNewButton);
		
		JButton btnWithdrawMoney = new JButton("Withdraw Money");
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				withdraw obj2 = new withdraw(un,passv);
				setVisible(false);
				obj2.setVisible(true);
			}
		});
		btnWithdrawMoney.setBackground(new Color(255, 0, 51));
		btnWithdrawMoney.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnWithdrawMoney.setForeground(new Color(255, 255, 255));
		btnWithdrawMoney.setBounds(349, 76, 202, 56);
		contentPane.add(btnWithdrawMoney);
		
		JButton btnVirtualAtmCard = new JButton("VIRTUAL ATM card");
		btnVirtualAtmCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					
					String sql=String.format("Select * from Customer where Username='%s' and Password='%s'",un,passv);
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						if(rs.getInt(9)!=2)
						{
							card3 obj = new card3(un,passv);
							setVisible(false);
							obj.setVisible(true);
						}
						else {
							card2 obj1 = new card2(un,passv);
							setVisible(false);
							obj1.setVisible(true);
						}
					}
					
					
					con.close();
					}
				catch(Exception le)
				{
					JOptionPane.showMessageDialog(null,le+" Error");
					
				}
				
			}
		});
		btnVirtualAtmCard.setBackground(new Color(255, 0, 51));
		btnVirtualAtmCard.setForeground(new Color(255, 255, 255));
		btnVirtualAtmCard.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnVirtualAtmCard.setBounds(55, 205, 202, 56);
		contentPane.add(btnVirtualAtmCard);
		
		JButton btnInfo = new JButton("INFO");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				info obj4 = new info(un,passv);
				obj4.setVisible(true);
			}
		});
		btnInfo.setBackground(new Color(255, 0, 51));
		btnInfo.setForeground(new Color(255, 255, 255));
		btnInfo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnInfo.setBounds(349, 205, 202, 56);
		contentPane.add(btnInfo);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				obj5.setVisible(true);
			}
		});
		btnTransferMoney.setBackground(new Color(255, 0, 51));
		btnTransferMoney.setForeground(new Color(255, 255, 255));
		btnTransferMoney.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnTransferMoney.setBounds(55, 333, 202, 56);
		contentPane.add(btnTransferMoney);
		
		JButton btnUpiId = new JButton("UPI ID");
		btnUpiId.setForeground(new Color(255, 255, 255));
		btnUpiId.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnUpiId.setBackground(new Color(255, 0, 51));
		btnUpiId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					String sql=String.format("Select * from Customer where Username='%s' and Password='%s'",un,passv);
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						if(rs.getInt(12)==3)
						{
							upi obj = new upi(un,passv);
							setVisible(false);
							obj.setVisible(true);
						}
						else {
							c=rs.getInt(12);
							JOptionPane.showMessageDialog(null,String.format("YOUR UPI_ID is %d",c));

							
						}
					}
					
					
					con.close();
					}
				catch(Exception le)
				{
					JOptionPane.showMessageDialog(null,le+" Error");
					
				}
				
				
			}
		});
		btnUpiId.setBounds(349, 333, 202, 56);
		contentPane.add(btnUpiId);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\operations.PNG"));
		lblNewLabel.setBounds(0, 0, 840, 541);
		contentPane.add(lblNewLabel);
	}
}
