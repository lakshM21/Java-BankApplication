import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField nme;
	private JTextField Dob;
	private JTextField brname;
	private JTextField bname;
	private JTextField mob_no;
	private JTextField Acc_no;
	private JTextField usrnm;
	private JButton btnRegister;
	private JPasswordField passvd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\register.PNG"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnX.setBackground(Color.BLACK);
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(809, 0, 53, 33);
		contentPane.add(btnX);
		
		nme = new JTextField();
		nme.setBounds(594, 48, 207, 33);
		contentPane.add(nme);
		nme.setColumns(10);
		
		Dob = new JTextField();
		Dob.setColumns(10);
		Dob.setBounds(594, 94, 207, 33);
		contentPane.add(Dob);
		
		brname = new JTextField();
		brname.setColumns(10);
		brname.setBounds(615, 236, 197, 33);
		contentPane.add(brname);
		
		bname = new JTextField();
		bname.setColumns(10);
		bname.setBounds(615, 190, 197, 33);
		contentPane.add(bname);
		
		mob_no = new JTextField();
		mob_no.setColumns(10);
		mob_no.setBounds(615, 328, 197, 33);
		contentPane.add(mob_no);
		
		Acc_no = new JTextField();
		Acc_no.setBounds(615, 282, 197, 33);
		contentPane.add(Acc_no);
		Acc_no.setColumns(10);
		
		usrnm = new JTextField();
		usrnm.setBounds(501, 421, 223, 33);
		contentPane.add(usrnm);
		usrnm.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vny","root","");
					Statement stmt=con.createStatement();
					//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String nam,db,brnam,bnam,mob,acno,unam,passv;
					db=Dob.getText();
					nam=nme.getText();
					bnam=bname.getText();
					mob=mob_no.getText();
					Double.parseDouble(mob);
					unam=usrnm.getText();
					passv=passvd.getText();
					acno=Acc_no.getText();
					Double.parseDouble(acno);
					brnam=brname.getText();
					
					if(!(nam.equals("") && bnam.equals("") && mob.equals("") && unam.equals("") && passv.equals("") && acno.equals("") && brnam.equals("") && db.equals("")))
					{
					String sql=String.format("insert into customer values('%s','%s','%s',0,'%s','%s','%s',01,02,'%s','%s',03)",nam,mob,acno,db,bnam,brnam,unam,passv );
					stmt.executeUpdate(sql);
					
					login obj = new login();
					setVisible(false);
					obj.setVisible(true);
					con.close();
					}
					else {
						JOptionPane.showMessageDialog(null,"\n'Wrong Input !!!'");		
						nme.setText("");
						bname.setText("");
						Dob.setText("");
						mob_no.setText("");
						usrnm.setText("");
						passvd.setText("");
						Acc_no.setText("");
						brname.setText("");
						
					}
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"\n'Wrong Input !!!'");		
					nme.setText("");
					bname.setText("");
					Dob.setText("");
					mob_no.setText("");
					usrnm.setText("");
					passvd.setText("");
					Acc_no.setText("");
					brname.setText("");
			
				}
				
			}
		});
		btnRegister.setBackground(new Color(0, 0, 0));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnRegister.setBounds(495, 513, 114, 31);
		contentPane.add(btnRegister);
		
		passvd = new JPasswordField();
		passvd.setBounds(501, 467, 223, 33);
		contentPane.add(passvd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				login obj = new login();
				obj.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(631, 513, 114, 31);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\register.PNG"));
		lblNewLabel.setBounds(24, 0, 862, 557);
		contentPane.add(lblNewLabel);
	}
}
