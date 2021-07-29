import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField usernm;
	private JPasswordField passvd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		usernm = new JTextField();
		usernm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		usernm.setBounds(644, 253, 165, 31);
		contentPane.add(usernm);
		usernm.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					String un,pas;
					un=usernm.getText();
					pas=passvd.getText().toString();
					String sql=String.format("Select * from Customer where Username='%s' and Password='%s'",un,pas);
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						op1 obj= new op1(un,pas);
						setVisible(false);					
						obj.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
						usernm.setText("");
						passvd.setText("");
					}
					con.close();
					}
				catch(Exception le)
				{
					JOptionPane.showMessageDialog(null,le+"Error");
					usernm.setText("");
					passvd.setText("");
				}
			}
		});
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(677, 400, 80, 41);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register obj = new register();
				setVisible(false);
				obj.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(0, 0, 0));
		btnRegister.setBounds(644, 457, 146, 39);
		contentPane.add(btnRegister);
		
		passvd = new JPasswordField();
		passvd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passvd.setBounds(644, 335, 165, 31);
		contentPane.add(passvd);
		
		JButton btnX = new JButton("X");
		btnX.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnX.setBounds(873, 0, 50, 41);
		contentPane.add(btnX);
		
		JButton btnGuestLogin = new JButton("Guest Login");
		btnGuestLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGuestLogin.setForeground(Color.WHITE);
		btnGuestLogin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnGuestLogin.setBackground(Color.BLACK);
		btnGuestLogin.setBounds(664, 516, 103, 31);
		contentPane.add(btnGuestLogin);
		
		JLabel label1 = new JLabel("New label");
		label1.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\Login page.PNG"));
		label1.setBounds(0, 0, 923, 593);
		contentPane.add(label1);
	}
}
