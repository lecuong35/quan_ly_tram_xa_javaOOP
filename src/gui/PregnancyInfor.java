package gui;

import javax.swing.JPanel;

import fileProcess.IconResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import cuong.Me;
import cuong.ThanhVien;
/*
 * JPanel hiện thông tin thai kì của bà mẹ
 */

public class PregnancyInfor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7858819315974404036L;
	public JFormattedTextField weight;
	public JFormattedTextField time;
	public JFormattedTextField thaiKy;
	public MainTabbedPane pane;
	private NumberFormat numberFormat = NumberFormat.getIntegerInstance();
	/**
	 * Create the panel.
	 */
	public PregnancyInfor(MainTabbedPane pane) {
		this.pane = pane;
		setLayout(null);

		JLabel weightLabel = new JLabel("Ch\u1EC9 s\u1ED1 c\u00E2n n\u1EB7ng:");
		weightLabel.setBounds(10, 67, 136, 22);
		add(weightLabel);

		JLabel medicalTimeLabel = new JLabel("Th\u1EDDi gian c\u1EA7n th\u0103m kh\u00E1m:");
		medicalTimeLabel.setBounds(10, 114, 166, 22);
		add(medicalTimeLabel);

		weight = new JFormattedTextField(numberFormat);
		weight.setEditable(false);
		weight.setBounds(215, 69, 96, 19);
		add(weight);
		weight.setColumns(10);

		JLabel lblNewLabel = new JLabel("kg");
		lblNewLabel.setBounds(335, 72, 45, 13);
		add(lblNewLabel);

		time = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		time.setToolTipText("Theo định dạng dd/mm/yyyy");
		time.setEditable(false);
		time.setBounds(215, 116, 96, 19);
		add(time);
		time.setColumns(10);

		JButton btnNewButton = new JButton("S\u1EECA", new IconResize("letter.png", 20, 20));
		btnNewButton.setToolTipText("Sửa dữ liệu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weight.setEditable(true);
				time.setEditable(true);
				thaiKy.setEditable(true);
			}
		});
		btnNewButton.setBounds(10, 213, 85, 21);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("X\u00D3A", new IconResize("eraser.png", 20, 20));
		btnNewButton_1.setToolTipText("Xóa hết dữ liệu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weight.setText("");
				time.setText("");
				thaiKy.setText("");
			}
		});
		btnNewButton_1.setBounds(129, 213, 85, 21);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("L\u01AFU", new IconResize("storage.png", 20, 20));
		btnNewButton_2.setToolTipText("Lưu dữ liệu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(time.getText().equals("")) {
					time.requestFocus();
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập ngày tái khám.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}else  if(thaiKy.getText().equals("")) {
					thaiKy.requestFocus();
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập thời gian mang thai.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}else if(weight.getText().equals("")) {
					weight.requestFocus();
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập cân nặng.", "Error",
		                    JOptionPane.ERROR_MESSAGE);				
				}else {
					weight.setEditable(false);
					time.setEditable(false);
					thaiKy.setEditable(false);
					updateInfor();
				}
				
			}
		});
		btnNewButton_2.setBounds(252, 213, 85, 21);
		add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Tháng mang thai:");
		lblNewLabel_1.setBounds(10, 28, 136, 13);
		add(lblNewLabel_1);

		thaiKy = new JFormattedTextField();
		thaiKy.setEditable(false);
		thaiKy.setBounds(215, 25, 96, 19);
		add(thaiKy);

	}
	
	public void ReadToThis(int weight, String time, int thaiKy) {
		this.weight.setText("" + weight);
		this.time.setText(time);
		this.thaiKy.setText("" + thaiKy);
	}
	
	public void updateInfor() {
		int day = Integer.parseInt(time.getText().split("/")[0]);
		int month = Integer.parseInt(time.getText().split("/")[1]);
		int year = Integer.parseInt(time.getText().split("/")[2]);
		LocalDate date = LocalDate.of(year, month, day);
		ThanhVien t = new ThanhVien();
		t = this.pane.giaDinh.get(1);
		if(t instanceof Me) {
			((Me)t).setMangThai(true);
			((Me)t).setCanNang(Integer.parseInt(weight.getText().replace(".", "")));
			((Me)t).setNgayThamKham(date);
			((Me)t).setThangThu(Integer.parseInt(thaiKy.getText().replace(".", "")));
		}
	}
}
