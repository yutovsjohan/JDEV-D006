package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	Connection cn;
	private JPasswordField pwdPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 486, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsername.setBounds(51, 35, 94, 26);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(51, 105, 94, 26);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(169, 40, 242, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblThongbao = new JLabel("");
		lblThongbao.setForeground(Color.RED);
		lblThongbao.setFont(new Font("Arial", Font.PLAIN, 16));
		lblThongbao.setBounds(169, 177, 242, 26);
		panel.add(lblThongbao);
		
		JButton btnRegister = new JButton("Register");
		
		btnRegister.setBounds(51, 235, 121, 34);
		panel.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBounds(290, 235, 121, 34);
		panel.add(btnLogin);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(169, 110, 242, 21);
		panel.add(pwdPassword);
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String user = txtUsername.getText();
				String sql = "select * from admin where username like ?";
				PreparedStatement ps;
				try {
					ps = cn.prepareStatement(sql);
					ps.setString(1, user);
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(getParent(), "Username đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					String pass = new String(pwdPassword.getPassword());
					
					MessageDigest md = MessageDigest.getInstance("SHA-1");
					byte []bytepass = md.digest(pass.getBytes());
					
					sql = "insert into admin values(?,?)";
					ps = cn.prepareStatement(sql);
					ps.setString(1, user);
					ps.setString(2, new String(bytepass));
					
					int kq=ps.executeUpdate();
					if(kq==0) {
						JOptionPane.showMessageDialog(getParent(), "Đăng ký thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					
					ps.close();
					cn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}				
				
				MessageDigest md;
				try {
					String user = txtUsername.getText();
					String strpass = new String(pwdPassword.getPassword());
					
					md = MessageDigest.getInstance("SHA-1");
					byte []bytepass = md.digest(strpass.getBytes());
					
										
					String pass = new String(bytepass);
					
					String sql="select * from admin where username like ? and password like ?";
					PreparedStatement ps = cn.prepareStatement(sql);
					
					ps.setString(1, user);
					ps.setString(2, pass);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(getParent(), "Login thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						
						ManHinh2 mh2 = new ManHinh2(user);
						mh2.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Login thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
}
