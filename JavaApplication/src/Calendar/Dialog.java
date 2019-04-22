package Calendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog();
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
	public Dialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlert = new JButton("Alert");
		btnAlert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getParent(), "Hello class","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAlert.setBounds(99, 68, 89, 23);
		contentPane.add(btnAlert);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int chon = JOptionPane.showConfirmDialog(getParent(), "Close form?","Asking",JOptionPane.ERROR_MESSAGE);
				if(chon==JOptionPane.YES_OPTION)
					System.exit(0);
				else
					JOptionPane.showMessageDialog(getParent(), "Hello");
			}
		});
		btnConfirm.setBounds(276, 68, 89, 23);
		contentPane.add(btnConfirm);
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noidung = JOptionPane.showInputDialog(getParent(),"1+1=?");
				if(noidung.equals("2"))
					JOptionPane.showMessageDialog(getParent(), "Kết quả đúng");
				else
					JOptionPane.showMessageDialog(getParent(), "Kết quả sai");
			}
		});
		btnInput.setBounds(454, 68, 89, 23);
		contentPane.add(btnInput);
	}
}