package AccountManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import StudentManage.MyConnect;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JPasswordField;

public class AccountManager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtFullname;
	private JTextField txtContact;
	private JTextField txtUsername;
	JRadioButton rdbtnEmployeeCall;
	JRadioButton rdbtnEmployeeSale;
	JRadioButton rdbtnAdmin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	DefaultTableModel model = new DefaultTableModel();
	Connection cn;
	private String id;
	
	private JPasswordField pwdPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManager frame = new AccountManager();
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
	public AccountManager() {
		cn = new MyConnect().getcn();
		if (cn == null) {
			JOptionPane.showMessageDialog(getParent(), "Kết nối database thất bại");
			return;
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(0, 255, 127));
		panelTable.setBounds(0, 0, 488, 269);
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 469, 247);
		panelTable.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(127, 255, 212));
		panelInfo.setBorder(new CompoundBorder());
		panelInfo.setLayout(null);
		panelInfo.setBounds(487, 0, 311, 212);
		contentPane.add(panelInfo);
		
		JLabel lblAccountDetails = new JLabel("ACCOUNT DETAILS");
		lblAccountDetails.setForeground(Color.RED);
		lblAccountDetails.setFont(lblAccountDetails.getFont().deriveFont(lblAccountDetails.getFont().getSize() + 9f));
		lblAccountDetails.setBounds(51, 11, 200, 29);
		panelInfo.add(lblAccountDetails);
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setFont(new Font("Arial", Font.PLAIN, 13));
		lblFullname.setBounds(10, 73, 75, 15);
		panelInfo.add(lblFullname);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Arial", Font.PLAIN, 13));
		lblContact.setBounds(10, 110, 75, 15);
		panelInfo.add(lblContact);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsername.setBounds(10, 148, 75, 15);
		panelInfo.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPassword.setBounds(10, 186, 75, 15);
		panelInfo.add(lblPassword);
		
		txtFullname = new JTextField();
		txtContact = new JTextField();
		txtUsername = new JTextField();
		pwdPassword = new JPasswordField();
		
		txtFullname.setBounds(95, 71, 206, 20);
		panelInfo.add(txtFullname);
		txtFullname.setColumns(10);
		
		
		txtContact.setColumns(10);
		txtContact.setBounds(95, 108, 206, 20);
		panelInfo.add(txtContact);
		
		
		txtUsername.setColumns(10);
		txtUsername.setBounds(95, 146, 206, 20);
		panelInfo.add(txtUsername);
		
		
		pwdPassword.setBounds(95, 184, 206, 17);
		panelInfo.add(pwdPassword);
		
		JPanel panelRole = new JPanel();
		panelRole.setBackground(new Color(224, 255, 255));
		panelRole.setLayout(null);
		panelRole.setBounds(488, 212, 166, 127);
		contentPane.add(panelRole);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(new Color(220, 20, 60));
		lblRole.setFont(new Font("Arial", Font.PLAIN, 15));
		lblRole.setBounds(10, 11, 75, 15);
		panelRole.add(lblRole);		
		
		rdbtnEmployeeCall = new JRadioButton("Employee Call");
		rdbtnEmployeeCall.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnEmployeeCall.setBackground(new Color(224, 255, 255));
		buttonGroup.add(rdbtnEmployeeCall);
		rdbtnEmployeeCall.setBounds(20, 45, 140, 23);
		panelRole.add(rdbtnEmployeeCall);
		
		rdbtnEmployeeSale = new JRadioButton("Employee Sale");
		rdbtnEmployeeSale.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnEmployeeSale.setBackground(new Color(224, 255, 255));
		buttonGroup.add(rdbtnEmployeeSale);
		rdbtnEmployeeSale.setBounds(20, 71, 140, 23);
		panelRole.add(rdbtnEmployeeSale);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnAdmin.setBackground(new Color(224, 255, 255));
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(20, 97, 140, 23);
		panelRole.add(rdbtnAdmin);
		
		JPanel panelBtn2 = new JPanel();
		panelBtn2.setBackground(new Color(0, 255, 127));
		panelBtn2.setLayout(null);
		panelBtn2.setBounds(0, 266, 488, 73);
		contentPane.add(panelBtn2);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setBounds(10, 27, 93, 23);
		panelBtn2.add(btnUpdate);
		
		JButton btnLock = new JButton("Lock");
		
		btnLock.setBounds(386, 27, 93, 23);
		panelBtn2.add(btnLock);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.setBounds(197, 27, 93, 23);
		panelBtn2.add(btnDelete);
		
		JPanel panelBtn1 = new JPanel();
		panelBtn1.setBackground(new Color(124, 252, 0));
		panelBtn1.setLayout(null);
		panelBtn1.setBounds(651, 212, 147, 127);
		contentPane.add(panelBtn1);
		
		JButton btnCreate = new JButton("Create");
		
		btnCreate.setBounds(21, 25, 104, 23);
		panelBtn1.add(btnCreate);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.setBounds(21, 59, 104, 23);
		panelBtn1.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(21, 93, 104, 23);
		panelBtn1.add(btnClose);
		
		
		Object[] columns = { "ID", "Username", "Fullname", "Contact", "Role", "Lock" };
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		loadTable();
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
				id = model.getValueAt(i, 0).toString();
				
				txtUsername.setText(model.getValueAt(i, 1).toString());
				txtFullname.setText(model.getValueAt(i, 2).toString());
				txtContact.setText(model.getValueAt(i, 3).toString());
				
				String role = model.getValueAt(i, 4).toString();
				
				if(rdbtnAdmin.getText().equalsIgnoreCase(role)){
					rdbtnAdmin.setSelected(true);
				}
				else if(rdbtnEmployeeCall.getText().equalsIgnoreCase(role)){
					rdbtnEmployeeCall.setSelected(true);
				}
				else {
					rdbtnEmployeeSale.setSelected(true);
				}
				
				if(model.getValueAt(i, 5).toString().equals("0")){
					btnLock.setText("Lock");
				}
				else{
					btnLock.setText("Unlock");
				}
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtContact.setText("");
				txtFullname.setText("");
				pwdPassword.setText("");
				txtUsername.setText("");
				buttonGroup.clearSelection();
				btnLock.setText("Lock");
				loadTable();
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if (valid() == 0) {
					String username = txtUsername.getText();
					
					String sql = "select * from account.account where username like ?";
					PreparedStatement ps;
					
					try {
						ps = cn.prepareStatement(sql);
						ps.setString(1, username);
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(getParent(), "Username đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						String fullname = txtFullname.getText();
						String contact = txtContact.getText();
						String roleID = "1";
						
						String role;
						if(rdbtnAdmin.isSelected()){
							role = rdbtnAdmin.getText();
						}
						else if(rdbtnEmployeeCall.isSelected()){
							role = rdbtnEmployeeCall.getText();
						}
						else {
							role = rdbtnEmployeeSale.getText();
						}
						
						sql = "select id from account.role where rolename like ?";
						ps = cn.prepareStatement(sql);
						ps.setString(1, role);
						rs = ps.executeQuery();
						if(rs.next()){
							roleID = rs.getString(1);
						}
						
						String pass = new String(pwdPassword.getPassword());
						
						
						sql = "INSERT INTO account.account(username, password, fullname, contact, role) VALUES (?,?,?,?,?)";
						try {
							MessageDigest md = MessageDigest.getInstance("SHA-1");
							byte []bytepass = md.digest(pass.getBytes());

							ps = cn.prepareStatement(sql);
							ps.setString(1, username);
							ps.setString(2, new String(bytepass));
							ps.setString(3, fullname);
							ps.setString(4, contact);
							ps.setString(5, roleID);
							
							int kq = ps.executeUpdate();
							
							if(kq==0) {
								JOptionPane.showMessageDialog(getParent(), "Insert thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(getParent(), "Insert thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
					
					
				}
			}

			
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if (valid() == 0) {					
					try {						
						String username = txtUsername.getText();
						
						String sql;
						PreparedStatement ps;
						ResultSet rs;
						
						String fullname = txtFullname.getText();
						String contact = txtContact.getText();
						String roleID = "1";
						
						String role;
						if(rdbtnAdmin.isSelected()){
							role = rdbtnAdmin.getText();
						}
						else if(rdbtnEmployeeCall.isSelected()){
							role = rdbtnEmployeeCall.getText();
						}
						else {
							role = rdbtnEmployeeSale.getText();
						}
						
						sql = "select id from account.role where rolename like ?";
						ps = cn.prepareStatement(sql);
						ps.setString(1, role);
						rs = ps.executeQuery();
						if(rs.next()){
							roleID = rs.getString(1);
						}
						
						String pass = new String(pwdPassword.getPassword());
						
						
						sql = "UPDATE account.account SET username = ?, password = ?, fullname = ?, contact = ?, role = ? WHERE id = ?";
						try {
							MessageDigest md = MessageDigest.getInstance("SHA-1");
							byte []bytepass = md.digest(pass.getBytes());

							ps = cn.prepareStatement(sql);
							ps.setString(1, username);
							ps.setString(2, new String(bytepass));
							ps.setString(3, fullname);
							ps.setString(4, contact);
							ps.setString(5, roleID);
							ps.setString(6, id);
							
							int kq = ps.executeUpdate();
							
							if(kq==0) {
								JOptionPane.showMessageDialog(getParent(), "Update thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(getParent(), "Update thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							System.out.println(e1.getMessage());
						} catch (NoSuchAlgorithmException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
								
				String sql = "DELETE FROM account.account WHERE id = ?";
				PreparedStatement ps;
				try {
					ps = cn.prepareStatement(sql);
					ps.setString(1, id);						
					int kq = ps.executeUpdate();
					
					if(kq==0) {
						JOptionPane.showMessageDialog(getParent(), "Delete thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Delete thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn = new MyConnect().getcn();
				if(cn==null) {
					JOptionPane.showMessageDialog(getParent(), "Kết nối thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
								
				String sql = "Select status from account.account where id = ?";
				PreparedStatement ps;
				try {
					ps = cn.prepareStatement(sql);
					ps.setString(1, id);	
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()){
						String status = rs.getString(1);
						if(status.equals("0")){
							status = "1";
						}
						else{
							status = "0";
						}
						sql = "UPDATE account.account SET status = ? WHERE id = ?";
						ps = cn.prepareStatement(sql);
						ps.setString(1, status);
						ps.setString(2, id);
						
						int kq = ps.executeUpdate();
						
						if(kq==0){
							JOptionPane.showMessageDialog(getParent(), "Thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(getParent(), "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
	}
	
	public void loadTable() {
		cn = new MyConnect().getcn();
		Object[] row = new Object[6];
		try {
			String sql = "select acc.id, username, fullname, contact, rolename, status from account.account acc join account.role role on acc.role = role.id";

			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				model.addRow(row);
			}

			rs.close();
			ps.close();
			cn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private int valid() {
		if (txtUsername.getText().matches("^\\s*$")) {
			txtUsername.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Bạn chưa nhập Username", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return -1;
		}
		
		if (pwdPassword.getPassword().toString().matches("^\\s*$")) {
			pwdPassword.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Bạn chưa nhập Password", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return -1;
		}

		if (txtFullname.getText().matches("^\\s*$")) {
			txtFullname.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Bạn chưa nhập Fullname", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return -1;
		}

		if (!txtContact.getText().matches("^[0-9]{7,12}$")) {
			txtContact.setText("");
			txtContact.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Contact không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return -1;
		}
		
		if(!(rdbtnAdmin.isSelected() || rdbtnEmployeeCall.isSelected() || rdbtnEmployeeSale.isSelected() )) {
			JOptionPane.showMessageDialog(getParent(), "Bạn chưa chọn Role", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			rdbtnAdmin.requestFocus();
			return -1;
		}

		return 0;
	}
}