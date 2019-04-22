package Calendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Calendar extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar frame = new Calendar();
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
	public Calendar() {			
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSelectedDate = new JPanel();
		panelSelectedDate.setBounds(0, 0, 866, 120);
		contentPane.add(panelSelectedDate);
		panelSelectedDate.setLayout(null);
		
		JLabel lblSelectedDate = new JLabel("Selected Date");
		lblSelectedDate.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSelectedDate.setBounds(10, 11, 96, 15);
		panelSelectedDate.add(lblSelectedDate);
		
		txtDate = new JTextField();
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setText("May, 27th December, 2018");
		txtDate.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDate.setBounds(10, 35, 846, 74);
		panelSelectedDate.add(txtDate);
		txtDate.setColumns(10);		
		
		JPanel panelYear = new JPanel();
		panelYear.setBounds(0, 120, 866, 120);
		contentPane.add(panelYear);
		panelYear.setLayout(null);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Arial", Font.PLAIN, 13));
		lblYear.setBounds(10, 11, 96, 15);
		panelYear.add(lblYear);
		
		JSlider sliderYear = new JSlider();		
		sliderYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sliderYear.setMinorTickSpacing(1);
		sliderYear.setMaximum(2020);
		sliderYear.setMinimum(2000);
		sliderYear.setMajorTickSpacing(5);
		sliderYear.setValue(0);
		sliderYear.setPaintLabels(true);
		sliderYear.setPaintTicks(true);
		sliderYear.setSnapToTicks(true);
		sliderYear.setBounds(10, 37, 846, 72);
		
		
		
		panelYear.add(sliderYear);
		
		
		
		JPanel panelMonth = new JPanel();
		panelMonth.setBounds(0, 238, 866, 120);
		contentPane.add(panelMonth);
		panelMonth.setLayout(null);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMonth.setBounds(10, 11, 96, 15);
		panelMonth.add(lblMonth);
		
		JSlider sliderMonth = new JSlider();
		
		sliderMonth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sliderMonth.setMajorTickSpacing(1);
		sliderMonth.setValue(0);
		sliderMonth.setSnapToTicks(true);
		sliderMonth.setPaintTicks(true);
		sliderMonth.setPaintLabels(true);
		sliderMonth.setMinorTickSpacing(1);
		sliderMonth.setMaximum(11);
		sliderMonth.setBounds(10, 37, 846, 72);
		
		
		
		panelMonth.add(sliderMonth);
		
		JPanel panelDay = new JPanel();
		panelDay.setBounds(0, 360, 866, 120);
		contentPane.add(panelDay);
		panelDay.setLayout(null);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDay.setBounds(10, 11, 96, 15);
		panelDay.add(lblDay);
		
		JSlider sliderDay = new JSlider();
		sliderDay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sliderDay.setValue(0);
		sliderDay.setSnapToTicks(true);
		sliderDay.setPaintTicks(true);
		sliderDay.setPaintLabels(true);
		sliderDay.setMinorTickSpacing(1);
		sliderDay.setMinimum(1);
		sliderDay.setMaximum(31);
		sliderDay.setMajorTickSpacing(1);
		sliderDay.setBounds(10, 37, 846, 72);
		
		panelDay.add(sliderDay);
		
		String []chuoi= {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		Hashtable<Integer, JLabel> h = new Hashtable<Integer, JLabel>();
		for (int i = 0; i < chuoi.length; i++) {
			h.put(i, new JLabel(chuoi[i]));
		}
		sliderMonth.setLabelTable(h);
		
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(sliderYear.getValue(), sliderMonth.getValue(), sliderDay.getValue());
		java.util.Date date = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		String sDate = sdf.format(date);
		
		txtDate.setText(sDate);
		
		sliderYear.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cal.set(sliderYear.getValue(), sliderMonth.getValue(), sliderDay.getValue());
				java.util.Date date = cal.getTime();
				date = cal.getTime();
				
				SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
				String sDate = sdf.format(date);
				
				txtDate.setText(sDate);
				
				switch(sliderMonth.getValue()){
				case 0: case 2: case 4: case 6: case 7: case 9: case 11:
					sliderDay.setMaximum(31);
					
					break;
				case 3: case 5: case 8: case 10:
					sliderDay.setMaximum(30);
					break;
				case 1:
					int year = sliderYear.getValue();
					if(year%400==0 || (year%4==0 && year%100!=0)){
						sliderDay.setMaximum(29);
					}
					else{
						sliderDay.setMaximum(28);
					}
					break;
				}
				
				
			}
		});
		
		sliderMonth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cal.set(sliderYear.getValue(), sliderMonth.getValue(), sliderDay.getValue());
				java.util.Date date = cal.getTime();
				date = cal.getTime();
				
				SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
				String sDate = sdf.format(date);
				
				switch(sliderMonth.getValue()){
				case 0: case 2: case 4: case 6: case 7: case 9: case 11:
					sliderDay.setMaximum(31);
					
					break;
				case 3: case 5: case 8: case 10:
					sliderDay.setMaximum(30);
					break;
				case 1:
					int year = sliderYear.getValue();
					if(year%400==0 || (year%4==0 && year%100!=0)){
						sliderDay.setMaximum(29);
					}
					else{
						sliderDay.setMaximum(28);
					}
					break;
				}
				
				txtDate.setText(sDate);
			}
		});
		
		sliderDay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cal.set(sliderYear.getValue(), sliderMonth.getValue(), sliderDay.getValue());
				java.util.Date date = cal.getTime();
				date = cal.getTime();
				
				SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
				String sDate = sdf.format(date);
				
				txtDate.setText(sDate);
			}
		});
		
		
	}
}