import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class launch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launch frame = new launch();
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
	public launch() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login obj = new login();
				setVisible(false);
				obj.setVisible(true);
			}
		});
		btnLaunch.setBackground(new Color(0, 204, 255));
		btnLaunch.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btnLaunch.setForeground(Color.WHITE);
		btnLaunch.setBounds(328, 428, 121, 43);
		contentPane.add(btnLaunch);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setBounds(745, 0, 46, 34);
		contentPane.add(btnX);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\start.PNG"));
		lblNewLabel.setBounds(0, 0, 791, 512);
		contentPane.add(lblNewLabel);
	}
}
