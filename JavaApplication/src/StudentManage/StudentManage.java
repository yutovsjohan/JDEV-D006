package StudentManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StudentManage extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtParentName;
	private JTextField txtPhone;
	private JComboBox cbStandard = new JComboBox();;
	private JComboBox cbFee = new JComboBox();
	private JLabel lblThongBao = new JLabel("");
	private JTable table;
	private String id;

	DefaultTableModel model = new DefaultTableModel();
	Connection cn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManage frame = new StudentManage();
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

	public StudentManage() {
		cn = new MyConnect().getcn();
		if (cn == null) {
			JOptionPane.showMessageDialog(getParent(), "Kết nối database thất bại");
			return;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(0, 0, 593, 218);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(47, 12, 108, 14);
		panelInfo.add(lblName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(47, 57, 108, 14);
		panelInfo.add(lblAddress);

		JLabel lblParentsName = new JLabel("Parent's name");
		lblParentsName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParentsName.setBounds(47, 102, 108, 14);
		panelInfo.add(lblParentsName);

		JLabel lblContactno = new JLabel("ContactNo");
		lblContactno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContactno.setBounds(47, 145, 108, 14);
		panelInfo.add(lblContactno);

		JLabel lblStandard = new JLabel("Standard");
		lblStandard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStandard.setBounds(47, 191, 71, 14);
		panelInfo.add(lblStandard);

		JLabel lblFee = new JLabel("Fee");
		lblFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFee.setBounds(332, 191, 50, 14);
		panelInfo.add(lblFee);

		txtName = new JTextField();
		txtName.setBounds(158, 11, 350, 20);
		panelInfo.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(158, 56, 350, 20);
		panelInfo.add(txtAddress);

		txtParentName = new JTextField();
		txtParentName.setColumns(10);
		txtParentName.setBounds(158, 101, 350, 20);
		panelInfo.add(txtParentName);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(158, 144, 350, 20);
		panelInfo.add(txtPhone);
		

		cbStandard.setBounds(158, 190, 130, 20);
		panelInfo.add(cbStandard);
		cbFee.setEnabled(false);

		cbFee.setBounds(378, 190, 130, 20);
		panelInfo.add(cbFee);

		JPanel panelButton = new JPanel();
		panelButton.setBounds(0, 223, 593, 71);
		contentPane.add(panelButton);
		panelButton.setLayout(null);

		JButton btnSave = new JButton("Save");

		btnSave.setBounds(43, 11, 89, 23);
		panelButton.add(btnSave);

		JButton btnUpdate = new JButton("Update");

		btnUpdate.setBounds(166, 11, 89, 23);
		panelButton.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");

		btnDelete.setBounds(302, 11, 89, 23);
		panelButton.add(btnDelete);

		JButton btnReset = new JButton("Reset");

		btnReset.setBounds(422, 11, 89, 23);
		panelButton.add(btnReset);

		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongBao.setBounds(156, 45, 252, 26);
		panelButton.add(lblThongBao);

		JPanel panelTable = new JPanel();
		panelTable.setBounds(0, 295, 593, 357);
		contentPane.add(panelTable);
		panelTable.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 573, 335);
		panelTable.add(scrollPane);

		table = new JTable();
		
		scrollPane.setViewportView(table);

		Object[] columns = { "RedID", "Name", "Address", "Parent", "Contact", "Standard", "RegDate" };
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.removeColumn(table.getColumnModel().getColumn(0));

		cbStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbStandard.setSelectedItem(cbStandard.getSelectedIndex());
			}
		});

		cbFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbFee.setSelectedItem(cbFee.getSelectedIndex());
			}
		});

		loadComboBox();
		loadTable();
		
		cbStandard.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String standard = cbStandard.getSelectedItem().toString();
				showFee(standard);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				id = model.getValueAt(i, 0).toString();
				
				txtName.setText(model.getValueAt(i, 1).toString());
				txtAddress.setText(model.getValueAt(i, 2).toString());
				txtParentName.setText(model.getValueAt(i, 3).toString());
				txtPhone.setText(model.getValueAt(i, 4).toString());
				
				String standard = model.getValueAt(i, 5).toString();
				cbStandard.setSelectedItem(standard);
				
				showFee(standard);
			}
		});
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				int i = table.getSelectedRow();
//				id = model.getValueAt(i, 0).toString();
//				
//				txtName.setText(model.getValueAt(i, 1).toString());
//				txtAddress.setText(model.getValueAt(i, 2).toString());
//				txtParentName.setText(model.getValueAt(i, 3).toString());
//				txtPhone.setText(model.getValueAt(i, 4).toString());
//				
//				String standard = model.getValueAt(i, 5).toString();
//				cbStandard.setSelectedItem(standard);
//				
//				showFee(standard);
				
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student a = new Student();
				a.name = txtName.getText();
				a.address = txtAddress.getText();
				a.parentName = txtParentName.getText();
				a.phone = txtPhone.getText();
				a.standard = (String) cbStandard.getSelectedItem();
				Calendar c = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				a.regDate = sdf.format(c.getTime());

				if (valid(a) == 0) {
					lblThongBao.setText("");
					cn = new MyConnect().getcn();
					String sql = "INSERT INTO student(name, address, parentName, phone, standard, regDate) VALUES (?,?,?,?,?,?)";
					try {
						PreparedStatement ps = cn.prepareStatement(sql);
						ps.setString(1, a.name);
						ps.setString(2, a.address);
						ps.setString(3, a.parentName);
						ps.setString(4, a.phone);
						ps.setString(5, a.standard);
						ps.setString(6, a.regDate);
						
						int kq = ps.executeUpdate();
						
						if(kq==0) {
							JOptionPane.showMessageDialog(getParent(), "Insert thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(getParent(), "Insert thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
				}

			}
		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cn = new MyConnect().getcn();
				txtAddress.setText("");
				txtName.setText("");
				txtParentName.setText("");
				txtPhone.setText("");
				cbStandard.setSelectedIndex(0);
				cbFee.setSelectedIndex(0);
				lblThongBao.setText("");
				loadTable();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student a = new Student();
				a.name = txtName.getText();
				a.address = txtAddress.getText();
				a.parentName = txtParentName.getText();
				a.phone = txtPhone.getText();
				a.standard = cbStandard.getSelectedItem().toString();

				if (valid(a) == 0) {
					lblThongBao.setText("");
					cn = new MyConnect().getcn();
					String sql = "UPDATE student SET name = ?, address = ?, parentName = ?, phone = ?, standard = ? WHERE id = ?";
					try {
						PreparedStatement ps = cn.prepareStatement(sql);
						ps.setString(1, a.name);
						ps.setString(2, a.address);
						ps.setString(3, a.parentName);
						ps.setString(4, a.phone);
						ps.setString(5, a.standard);
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
					}
					
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				lblThongBao.setText("");
				cn = new MyConnect().getcn();
				String sql = "DELETE FROM student WHERE id = ?";
				try {
					PreparedStatement ps = cn.prepareStatement(sql);
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
	}

	Vector v1 = new Vector<>();
	Vector v2 = new Vector<>();

	public void loadComboBox() {
		try {
			cn = new MyConnect().getcn();
			String sql = "select * from standards";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v1.addElement(rs.getString(1));
				v2.addElement(rs.getString(2));
			}
			cbStandard.setModel(new DefaultComboBoxModel<>(v1));
			cbFee.setModel(new DefaultComboBoxModel<>(v2));

			rs.close();
			ps.close();
			cn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadTable() {
		cn = new MyConnect().getcn();
		Object[] row = new Object[7];
		try {
			String sql = "select * from student";

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
				row[6] = rs.getString(7);
				model.addRow(row);
			}

			rs.close();
			ps.close();
			cn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private int valid(Student a) {

		if (a.name.matches("^\\s*$")) {
			txtName.requestFocus();
			lblThongBao.setText("Bạn chưa nhập tên");
			return 1;
		}

		if (a.address.matches("^\\s*$")) {
			txtAddress.requestFocus();
			lblThongBao.setText("Bạn chưa nhập địa chỉ");
			return 2;
		}

		if (!a.phone.matches("^[0-9]{7,12}$")) {
			txtPhone.requestFocus();
			lblThongBao.setText("Bạn chưa nhập điện thoại");
			return 3;
		}

		return 0;
	}
	
	public void showFee(String standard) {
		cn = new MyConnect().getcn();
		String sql = "select * from standards where standard = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, standard);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cbFee.setSelectedItem(rs.getString("fee"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}