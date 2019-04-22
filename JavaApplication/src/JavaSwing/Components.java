package JavaSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Components extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoten;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Components frame = new Components();
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
	public Components() {
		setTitle("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel PanelFormDangKy = new JPanel();
		PanelFormDangKy.setBounds(10, 11, 362, 149);
		contentPane.add(PanelFormDangKy);
		PanelFormDangKy.setLayout(null);
		
		JLabel lblFormDK = new JLabel("FORM \u0110\u0102NG K\u00DD");
		lblFormDK.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFormDK.setBounds(106, 11, 163, 43);
		PanelFormDangKy.add(lblFormDK);
		
		JLabel lblHoTen = new JLabel("H\u1ECD T\u00EAn");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(10, 67, 48, 14);
		PanelFormDangKy.add(lblHoTen);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmail.setBounds(10, 112, 48, 14);
		PanelFormDangKy.add(lblEmail);
		
		txtHoten = new JTextField();
		txtHoten.setBounds(66, 65, 253, 20);
		PanelFormDangKy.add(txtHoten);
		txtHoten.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(66, 110, 253, 20);
		PanelFormDangKy.add(txtEmail);
		
		JPanel PanelGioiTinh = new JPanel();
		PanelGioiTinh.setToolTipText("");
		PanelGioiTinh.setBounds(370, 11, 147, 149);
		contentPane.add(PanelGioiTinh);
		PanelGioiTinh.setLayout(null);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGioiTinh.setBounds(27, 24, 83, 18);
		PanelGioiTinh.add(lblGioiTinh);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setFont(new Font("Arial", Font.PLAIN, 13));
		rdNam.setBounds(27, 64, 71, 23);
		PanelGioiTinh.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("N\u1EEF");
		rdNu.setFont(new Font("Arial", Font.PLAIN, 13));
		rdNu.setBounds(27, 104, 71, 23);
		PanelGioiTinh.add(rdNu);
		
		ButtonGroup GroupGioiTinh = new ButtonGroup();
		GroupGioiTinh.add(rdNam);
		GroupGioiTinh.add(rdNu);
		
		JPanel PanelSoThich = new JPanel();
		PanelSoThich.setBounds(10, 160, 507, 67);
		contentPane.add(PanelSoThich);
		PanelSoThich.setLayout(null);
		
		JLabel lblSoThich = new JLabel("S\u1EDF Th\u00EDch");
		lblSoThich.setBounds(10, 11, 65, 15);
		lblSoThich.setFont(new Font("Arial", Font.PLAIN, 13));
		PanelSoThich.add(lblSoThich);
		
		JCheckBox ckGame = new JCheckBox("Game");
		ckGame.setBounds(45, 33, 82, 23);
		PanelSoThich.add(ckGame);
		
		JCheckBox ckDocSach = new JCheckBox("\u0110\u1ECDc s\u00E1ch");
		ckDocSach.setBounds(184, 33, 82, 23);
		PanelSoThich.add(ckDocSach);
		
		JCheckBox ckHoc = new JCheckBox("H\u1ECDc ti\u1EBFng Anh");
		ckHoc.setBounds(317, 33, 106, 23);
		PanelSoThich.add(ckHoc);
		
		JPanel PanelTrinhDo = new JPanel();
		PanelTrinhDo.setBounds(10, 226, 507, 119);
		contentPane.add(PanelTrinhDo);
		PanelTrinhDo.setLayout(null);
		
		JLabel lblTrinhDo = new JLabel("Tr\u00ECnh \u0111\u1ED9");
		lblTrinhDo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTrinhDo.setBounds(10, 11, 65, 15);
		PanelTrinhDo.add(lblTrinhDo);
		
		JComboBox cbTrinhDo = new JComboBox();
		cbTrinhDo.setModel(new DefaultComboBoxModel(new String[] {"Chọn bằng cấp...", "THCS", "THPT", "Đại học", "Trung cấp", "Thạc sĩ", "Tiến sĩ"}));
		cbTrinhDo.setBounds(10, 52, 136, 20);
		PanelTrinhDo.add(cbTrinhDo);
		
		JLabel lblYKien = new JLabel("\u00DD ki\u1EBFn th\u00EAm");
		lblYKien.setFont(new Font("Arial", Font.PLAIN, 13));
		lblYKien.setBounds(222, 12, 92, 15);
		PanelTrinhDo.add(lblYKien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 39, 240, 69);
		PanelTrinhDo.add(scrollPane);
		
		JTextArea txtYKien = new JTextArea();
		txtYKien.setRows(5);
		txtYKien.setColumns(20);
		scrollPane.setViewportView(txtYKien);
		
		JPanel PanelThongBao = new JPanel();
		PanelThongBao.setBounds(10, 346, 507, 95);
		contentPane.add(PanelThongBao);
		PanelThongBao.setLayout(null);
		
		JLabel txtKq = new JLabel("M\u1EDDi b\u1EA1n \u0111i\u1EC1n \u0111\u1EA7y \u0111\u1EE7 th\u00F4ng tin");
		txtKq.setFont(new Font("Arial", Font.ITALIC, 15));
		txtKq.setBounds(10, 11, 459, 18);
		PanelThongBao.add(txtKq);
		
		JButton btnDangKy = new JButton(" \u0110\u0103ng k\u00FD");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten = txtHoten.getText();
				if(hoten.equalsIgnoreCase("")) {
					txtKq.setText("Bạn chưa điền họ tên");
					txtHoten.requestFocus();
					return;
				}
				
				String email = txtEmail.getText();
				if(email.equalsIgnoreCase("")) {
					txtKq.setText("Bạn chưa điền email");
					txtEmail.requestFocus();
					return;
				}
				
				String mau = "^[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]{2,4}){1,2}$";
				Pattern p = Pattern.compile(mau);
				Matcher m = p.matcher(email);
				if(!m.matches()) {
					txtKq.setText("Email không đúng chuẩn");
					txtEmail.requestFocus();
					return;
				}
				
				if(!(rdNam.isSelected() || rdNu.isSelected() )) {
					txtKq.setText("Bạn chưa chọn giới tính");
					rdNam.requestFocus();
					return;
				}
				
				if(!(ckDocSach.isSelected() || ckGame.isSelected() || ckHoc.isSelected())) {
					txtKq.setText("Bạn chưa chọn sở thích");
					ckGame.requestFocus();
					return;
				}
				
				int chon=cbTrinhDo.getSelectedIndex();
				if(chon==0) {
					txtKq.setText("Bạn chưa chọn bằng cấp");
					cbTrinhDo.requestFocus();
					return;
				}
				
				Student a = new Student(txtHoten.getText(),txtEmail.getText());
				try {
					FileWriter fr = new FileWriter("E://a.txt");
					BufferedWriter br = new BufferedWriter(fr);
					br.write(a.toString());
					br.close();
				} catch (IOException e1) {					
					System.out.println(e1.getMessage());
				}
				
				txtKq.setText("Đăng ký thành công");
				
				JOptionPane.showMessageDialog(getParent(), "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDangKy.setBounds(109, 61, 89, 23);
		PanelThongBao.add(btnDangKy);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHoten.setText("");
				txtEmail.setText("");
				GroupGioiTinh.clearSelection();
				ckDocSach.setSelected(false);
				ckGame.setSelected(false);
				ckHoc.setSelected(false);
				
				cbTrinhDo.setSelectedIndex(0);
				txtYKien.setText("");
				txtKq.setText("Mời bạn điền đầy đủ thông tin");
			}
		});
		btnReset.setBounds(283, 61, 89, 23);
		PanelThongBao.add(btnReset);
		
	}
}
