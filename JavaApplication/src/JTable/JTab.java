package JTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class JTab extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTab frame = new JTab();
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
	public JTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 623, 368);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String[] s = {"Mai","Lan","Cúc","Trúc"};
		Vector<String> v1 = new Vector<>();
		Vector<String> v2 = new Vector<>();
		
		v1.addAll(Arrays.asList(s));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 623, 368);
		panel.add(tabbedPane);
		
		JPanel JList = new JPanel();
		tabbedPane.addTab("JList", null, JList, null);
		JList.setLayout(null);
		
		JLabel lblList = new JLabel("List 1");
		lblList.setBounds(45, 34, 50, 22);
		JList.add(lblList);
		lblList.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblList_1 = new JLabel("List 2");
		lblList_1.setBounds(382, 34, 50, 22);
		JList.add(lblList_1);
		lblList_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		javax.swing.JList list1 = new javax.swing.JList();
		list1.setBounds(45, 56, 199, 223);
		JList.add(list1);
		list1.setListData(v1);
		
		javax.swing.JList list2 = new javax.swing.JList();
		list2.setBounds(382, 56, 199, 223);
		JList.add(list2);
		
		JButton btn1_2 = new JButton(">");
		btn1_2.setBounds(264, 56, 89, 23);
		JList.add(btn1_2);
		
		JButton btn2_1 = new JButton("<");
		btn2_1.setBounds(264, 115, 89, 23);
		JList.add(btn2_1);
		
		JButton btnAll_1_2 = new JButton(">>");
		btnAll_1_2.setBounds(264, 178, 89, 23);
		JList.add(btnAll_1_2);
		
		JButton btnAll_2_1 = new JButton("<<");
		btnAll_2_1.setBounds(264, 237, 89, 23);
		JList.add(btnAll_2_1);
		
		btnAll_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v1.addAll(v2);
				v2.removeAllElements();
				
				list1.setListData(v1);
				list2.setListData(v2);
			}
		});
		
		btnAll_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v2.addAll(v1);
				v1.removeAllElements();
				
				list1.setListData(v1);
				list2.setListData(v2);
			}
		});
		
		btn2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List l = list2.getSelectedValuesList();
				
				v1.addAll(l);
				v2.removeAll(l);
				
				list1.setListData(v1);
				list2.setListData(v2);
			}
		});
		
		btn1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List l = list1.getSelectedValuesList();
				
				v2.addAll(l);
				v1.removeAll(l);
				
				list1.setListData(v1);
				list2.setListData(v2);
			}
		});
		
		JPanel Register = new JPanel();
		tabbedPane.addTab("Register", null, Register, null);
		Register.setLayout(null);
		
		JButton btnNewButton = new JButton("Tab About");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton.setBounds(248, 57, 97, 23);
		Register.add(btnNewButton);
		
		JPanel Login = new JPanel();
		tabbedPane.addTab("Login", null, Login, null);
		Login.setLayout(null);
		
		JPanel About = new JPanel();
		tabbedPane.addTab("About", null, About, null);
		About.setLayout(null);
		
		JLabel lblAbout = new JLabel("Green Academy VietNam");
		lblAbout.setBounds(207, 53, 153, 14);
		About.add(lblAbout);
	}
}
