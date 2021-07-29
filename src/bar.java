import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

public class bar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		bar frame = new bar();
		login nframe = new login();
		frame.setVisible(true);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(0, 255, 51));
		progressBar.setBounds(0, 485, 791, 27);
		frame.getContentPane().add(progressBar);
		
		try {
			
			
			
			for(int i=0;i<=100;i++)
			{
				Thread.sleep(42);
				progressBar.setValue(i);
				if(i==100) 
				{
					frame.setVisible(false);
					nframe.setVisible(true);
				}
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public bar() {
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
		

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vinay\\eclipse-workspace\\VLbank\\src\\start.PNG"));
		lblNewLabel.setBounds(0, 0, 791, 512);
		contentPane.add(lblNewLabel);
	}
}
