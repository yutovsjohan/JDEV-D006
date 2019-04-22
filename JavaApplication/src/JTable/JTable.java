package JTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JTable extends JFrame {

	private JPanel contentPane;
	private JTextField txtProductName;
	private JTextField txtPrice;
	private javax.swing.JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable frame = new JTable();
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
	DefaultTableModel model = new DefaultTableModel();
	
	public JTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProductName.setBounds(23, 29, 100, 23);
		panel.add(lblProductName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCategory.setBounds(23, 74, 100, 23);
		panel.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(23, 121, 100, 23);
		panel.add(lblPrice);
		
		txtProductName = new JTextField();
		txtProductName.setBounds(158, 31, 216, 20);
		panel.add(txtProductName);
		txtProductName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(158, 123, 216, 20);
		panel.add(txtPrice);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Tablet", "SmartPhone", "TV"}));
		cbCategory.setBounds(158, 76, 216, 20);
		panel.add(cbCategory);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 189, 620, 225);
		panel.add(scrollPane);
		
		table = new javax.swing.JTable();
		scrollPane.setViewportView(table);
		
		Object[] columns = {"Product Name","Category","Price"};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		readfile();
		
		JLabel lblThongbao = new JLabel("Th\u00F4ng b\u00E1o");
		lblThongbao.setFont(new Font("Arial", Font.PLAIN, 13));
		lblThongbao.setBounds(298, 154, 76, 23);
		panel.add(lblThongbao);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setBounds(462, 30, 89, 23);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setBounds(462, 75, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.setBounds(462, 122, 89, 23);
		panel.add(btnDelete);
		
		Object[] row = new Object[3];
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				row[0] = txtProductName.getText();
				row[1] = cbCategory.getSelectedItem();
				row[2] = txtPrice.getText();
				
				model.addRow(row);
				writefile();
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(txtProductName.getText(), i, 0);
				model.setValueAt(cbCategory.getSelectedItem(), i, 1);
				model.setValueAt(txtPrice.getText(), i, 2);
				writefile();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					writefile();
				}				
			}
		});
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				txtProductName.setText(model.getValueAt(i, 0).toString());
				cbCategory.setSelectedItem(model.getValueAt(i, 1).toString());
				txtPrice.setText(model.getValueAt(i, 2).toString());
			}
		});
		
		
	}
	
	public void writefile() {
		FileWriter fr;
		try {
			fr = new FileWriter("E://temp.txt");
			BufferedWriter br = new BufferedWriter(fr);
			String row;
			for (int i = 0; i < model.getRowCount(); i++) {
				row = model.getValueAt(i, 0) + "\t" + model.getValueAt(i, 1) + "\t" + model.getValueAt(i, 2) + "\r\n";
				br.write(row);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void readfile() {
		try {
			FileReader fr = new FileReader("E://temp.txt");
			BufferedReader br = new BufferedReader(fr);
			String st;
			Object[]row = new Object[3];
			while(br.ready()) {
				st=br.readLine();
				row=st.split("\t");
				model.addRow(row);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
