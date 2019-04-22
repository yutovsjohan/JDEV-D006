package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ManHinh2 extends JFrame {

	private JPanel contentPane;
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ManHinh2 frame = new ManHinh2();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManHinh2(String userlogin) {
		this.username = userlogin;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHello.setBounds(10, 11, 299, 35);
		contentPane.add(lblHello);
		
		lblHello.setText(lblHello.getText() + " " + username);
	}

}
