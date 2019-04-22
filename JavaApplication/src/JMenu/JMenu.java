package JMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JMenu extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu();
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
	int flag;
	public JMenu() {
		flag = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		javax.swing.JMenu mnNewMenu = new javax.swing.JMenu("Color");
		menuBar.add(mnNewMenu);
		
		JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		
		buttonGroup.add(rdbtnmntmRed);
		mnNewMenu.add(rdbtnmntmRed);
		
		JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		
		buttonGroup.add(rdbtnmntmBlue);
		mnNewMenu.add(rdbtnmntmBlue);
		
		JRadioButtonMenuItem rdbtnmntmYellow = new JRadioButtonMenuItem("Yellow");
		
		buttonGroup.add(rdbtnmntmYellow);
		mnNewMenu.add(rdbtnmntmYellow);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JCheckBoxMenuItem chckbxmntmClear = new JCheckBoxMenuItem("Clear");
		
		mnNewMenu.add(chckbxmntmClear);
		
		JCheckBoxMenuItem chckbxmntmExit = new JCheckBoxMenuItem("Exit");
		
		mnNewMenu.add(chckbxmntmExit);
		
		javax.swing.JMenu mnEdit = new javax.swing.JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		
		mnEdit.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		
		mnEdit.add(mntmSave);
		
		javax.swing.JMenu mnAbout = new javax.swing.JMenu("About");
		
		menuBar.add(mnAbout);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "Thông tin tác giả: yuto \r\n Version: 1.0","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuBar.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panelToolBar = new Panel();
		panelToolBar.setBounds(0, 0, 434, 24);
		contentPane.add(panelToolBar);
		panelToolBar.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 24);
		panelToolBar.add(toolBar);
		
		JButton btnChange = new JButton("Change Foreground");
		
		toolBar.add(btnChange);
		
		Panel panelText = new Panel();
		panelText.setBounds(0, 30, 434, 211);
		contentPane.add(panelText);
		panelText.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 189);
		panelText.add(scrollPane);
		
		txtArea = new JTextField();
		scrollPane.setViewportView(txtArea);
		txtArea.setColumns(10);
		
		
		//------------------------------------------------------------------------------
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag==0){
					flag = 1;
					btnChange.setText("Change Background");
				}
				else{
					flag = 0;
					btnChange.setText("Change Foreground");
				}
				buttonGroup.clearSelection();
			}
		});
		
		rdbtnmntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0){
					txtArea.setForeground(Color.red);
				}
				else{
					txtArea.setBackground(Color.red);
				}
			}
		});
		
		rdbtnmntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0){
					txtArea.setForeground(Color.blue);
				}
				else{
					txtArea.setBackground(Color.blue);
				}
			}
		});
		
		rdbtnmntmYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0){
					txtArea.setForeground(Color.yellow);
				}
				else{
					txtArea.setBackground(Color.yellow);
				}
			}
		});
		//------------------------------------------------------------------------------
		
		
		
		//------------------------------------------------------------------------------
		/* Mine
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnChange.getText().equalsIgnoreCase("Change Foreground")){
					btnChange.setText("Change Background");
					if(rdbtnmntmRed.isSelected()){
						btnChange.setBackground(Color.red);
					}
					else if(rdbtnmntmBlue.isSelected()){
						btnChange.setBackground(Color.blue);
					}
					else if(rdbtnmntmYellow.isSelected()){
						btnChange.setBackground(Color.yellow);
					}
					btnChange.setForeground(getForeground());
				}
				else{
					btnChange.setText("Change Foreground");
					if(rdbtnmntmRed.isSelected()){
						btnChange.setForeground(Color.red);
					}
					else if(rdbtnmntmBlue.isSelected()){
						btnChange.setForeground(Color.blue);
					}
					else if(rdbtnmntmYellow.isSelected()){
						btnChange.setForeground(Color.yellow);
					}
					btnChange.setBackground(getBackground());
				}
			}
		});
		
		rdbtnmntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChange.getText().equalsIgnoreCase("Change Foreground")){
					txtArea.setForeground(Color.red);
				}
				else{
					txtArea.setBackground(Color.red);
				}
			}
		});
		
		rdbtnmntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChange.getText().equalsIgnoreCase("Change Foreground")){
					txtArea.setForeground(Color.blue);
				}
				else{
					txtArea.setBackground(Color.blue);
				}
			}
		});
		
		rdbtnmntmYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChange.getText().equalsIgnoreCase("Change Foreground")){
					txtArea.setForeground(Color.yellow);
				}
				else{
					txtArea.setBackground(Color.yellow);
				}
			}
		});
		*/
		//------------------------------------------------------------------------------
		
		
		chckbxmntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();
				btnChange.setBackground(getBackground());
				btnChange.setForeground(getForeground());
				chckbxmntmClear.setSelected(false);
				txtArea.setText("");
			}
		});
		
		chckbxmntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser f = new JFileChooser();
				
				int r = f.showOpenDialog(getParent());
				if(r==JFileChooser.APPROVE_OPTION){
					String filename = f.getSelectedFile().getAbsolutePath();
					try {
						FileReader fr = new FileReader(filename);
						BufferedReader br = new BufferedReader(fr);
						
						String noidung="";
						while(br.ready()){
							noidung=noidung + br.readLine() + "\r\n";
						}
						txtArea.setText(noidung);
						br.close();
					} catch (IOException ex){
						System.out.println(ex.getMessage());
					}
				}
			}
		});
		
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser f = new JFileChooser();
				int chon = f.showSaveDialog(getParent());
				
				if(chon==f.APPROVE_OPTION){
					String filename = f.getSelectedFile().getAbsolutePath();
					try {
						FileWriter fr = new FileWriter(filename);
						BufferedWriter br = new BufferedWriter(fr);
						
						String noidung=txtArea.getText();
						br.write(noidung);
						
						br.close();
					} catch (IOException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});
		
		mnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(),"Thông tin tác giả: yuto \r\n Version: 1.0", "Thông báo",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}