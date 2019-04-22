package Calendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Slider extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiaTri;
	private JTextField txtValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider frame = new Slider();
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
	public Slider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 469, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtGiaTri = new JTextField();
		txtGiaTri.setBounds(65, 23, 99, 20);
		panel.add(txtGiaTri);
		txtGiaTri.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int gtri = slider.getValue();
				txtGiaTri.setText(String.valueOf(gtri));
			}
		});
		slider.setBounds(10, 67, 393, 74);
		panel.add(slider);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setValue(0);
		
		JLabel lblGiTr = new JLabel("Gi\u00E1 tr\u1ECB");
		lblGiTr.setBounds(10, 11, 68, 45);
		panel.add(lblGiTr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 180, 469, 157);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtValue = new JTextField();
		txtValue.setBounds(67, 11, 107, 20);
		txtValue.setColumns(10);
		panel_1.add(txtValue);
		
		JSlider sliderColor = new JSlider();
		sliderColor.setPaintLabels(true);
		sliderColor.setPaintTicks(true);
		sliderColor.setSnapToTicks(true);
		
		
		
		sliderColor.setMaximum(3);
		sliderColor.setMajorTickSpacing(1);
		sliderColor.setMinorTickSpacing(5);
		sliderColor.setLabelTable(slider.createStandardLabels(10));
		sliderColor.setValue(0);
		sliderColor.setBounds(10, 57, 397, 57);
		panel_1.add(sliderColor);
		
		String []chuoi= {"Vàng", "Xanh", "Đỏ", "Tím"};
		Hashtable<Integer, JLabel> h = new Hashtable<Integer, JLabel>();
		for (int i = 0; i < chuoi.length; i++) {
			h.put(i, new JLabel(chuoi[i]));
		}
		sliderColor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int gtri = sliderColor.getValue();
				txtValue.setText(String.valueOf(chuoi[gtri]));
			}
		});
		sliderColor.setLabelTable(h);
		sliderColor.setValue(0);
		
		
		
	}
}