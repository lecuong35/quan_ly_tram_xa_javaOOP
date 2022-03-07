package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartPanel;

import cuong.ThanhVien;
import cuong.TreCon;
import fileProcess.IconResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import khang.height;
import khang.weight;
import java.awt.FlowLayout;

/*
 * JPanel hiện các thông tin về dinh dưỡng
 * như cân nặng, chiều cao...
 */

public class Nutrition extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7861427963990921309L;
	public JFormattedTextField heightTF;
	public JFormattedTextField weightTF;
	public JPanel heightPic;
	public JPanel weightPic;
	public JLabel healthLb;
	public JLabel healthLabel;
	public NumberFormat numberFormat = NumberFormat.getIntegerInstance();
	public MainTabbedPane pane;
	int kieu;
	
	public Nutrition(MainTabbedPane pane, int kieu) {
		this.kieu = kieu;
		this.pane = pane;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gridBag = new GridBagLayout();
		gridBag.columnWidths = new int[]{130, 157, 81, 0};
		gridBag.rowHeights = new int[]{21, 19, 26, 33, 168, 177, 0};
		gridBag.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBag.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gridBag);
		
		JLabel heightLabel = new JLabel("Chi\u1EC1u cao:");
		GridBagConstraints gbc_heightLabel = new GridBagConstraints();
		gbc_heightLabel.anchor = GridBagConstraints.WEST;
		gbc_heightLabel.fill = GridBagConstraints.VERTICAL;
		gbc_heightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_heightLabel.gridx = 0;
		gbc_heightLabel.gridy = 0;
		panel.add(heightLabel, gbc_heightLabel);
		
		heightTF = new JFormattedTextField(numberFormat);
		heightTF.setEditable(false);
		GridBagConstraints gbc_heightTF = new GridBagConstraints();
		gbc_heightTF.anchor = GridBagConstraints.NORTH;
		gbc_heightTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_heightTF.insets = new Insets(0, 0, 5, 5);
		gbc_heightTF.gridx = 1;
		gbc_heightTF.gridy = 0;
		panel.add(heightTF, gbc_heightTF);
		heightTF.setColumns(10);
		
		JLabel cm = new JLabel("cm");
		GridBagConstraints gbc_cm = new GridBagConstraints();
		gbc_cm.anchor = GridBagConstraints.SOUTHWEST;
		gbc_cm.insets = new Insets(0, 0, 5, 0);
		gbc_cm.gridx = 2;
		gbc_cm.gridy = 0;
		panel.add(cm, gbc_cm);
		
		JLabel weightLabel = new JLabel("C\u00E2n n\u1EB7ng:");
		GridBagConstraints gbc_weightLabel = new GridBagConstraints();
		gbc_weightLabel.anchor = GridBagConstraints.WEST;
		gbc_weightLabel.fill = GridBagConstraints.VERTICAL;
		gbc_weightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_weightLabel.gridx = 0;
		gbc_weightLabel.gridy = 1;
		panel.add(weightLabel, gbc_weightLabel);
		
		weightTF = new JFormattedTextField(numberFormat);
		weightTF.setEditable(false);
		GridBagConstraints gbc_weightTF = new GridBagConstraints();
		gbc_weightTF.anchor = GridBagConstraints.NORTH;
		gbc_weightTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_weightTF.insets = new Insets(0, 0, 5, 5);
		gbc_weightTF.gridx = 1;
		gbc_weightTF.gridy = 1;
		panel.add(weightTF, gbc_weightTF);
		weightTF.setColumns(10);
		
		JLabel kg = new JLabel("kg");
		GridBagConstraints gbc_kg = new GridBagConstraints();
		gbc_kg.anchor = GridBagConstraints.WEST;
		gbc_kg.insets = new Insets(0, 0, 5, 0);
		gbc_kg.gridx = 2;
		gbc_kg.gridy = 1;
		panel.add(kg, gbc_kg);
		

		
		healthLabel = new JLabel("T\u00ECnh tr\u1EA1ng c\u01A1 th\u1EC3:");
		GridBagConstraints gbc_healthLabel = new GridBagConstraints();
		gbc_healthLabel.anchor = GridBagConstraints.WEST;
		gbc_healthLabel.fill = GridBagConstraints.VERTICAL;
		gbc_healthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_healthLabel.gridx = 0;
		gbc_healthLabel.gridy = 2;
		panel.add(healthLabel, gbc_healthLabel);
		
		healthLb = new JLabel("");
		GridBagConstraints gbc_healthLb = new GridBagConstraints();
		gbc_healthLb.fill = GridBagConstraints.BOTH;
		gbc_healthLb.insets = new Insets(0, 0, 5, 5);
		gbc_healthLb.gridx = 1;
		gbc_healthLb.gridy = 2;
		panel.add(healthLb, gbc_healthLb);
		
		JLabel chartLabel = new JLabel("Bi\u1EC3u \u0111\u1ED3 t\u0103ng tr\u01B0\u1EDFng:");
		GridBagConstraints gbc_chartLabel = new GridBagConstraints();
		gbc_chartLabel.anchor = GridBagConstraints.WEST;
		gbc_chartLabel.fill = GridBagConstraints.VERTICAL;
		gbc_chartLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chartLabel.gridx = 0;
		gbc_chartLabel.gridy = 3;
		panel.add(chartLabel, gbc_chartLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnNewButton = new JButton("LƯU", new IconResize("storage.png", 20, 20));
		btnNewButton.setBounds(0, 0, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SỬA", new IconResize("letter.png", 20, 20));
		btnNewButton_1.setBounds(98, 0, 85, 21);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heightTF.setEditable(true);
				weightTF.setEditable(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("XÓA", new IconResize("eraser.png", 20, 20));
		btnNewButton_2.setBounds(200, 0, 85, 21);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heightTF.setText("");
				weightTF.setText("");
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String	text = heightTF.getText();
				int height = 0, weight = 0;
				
				if(text.equals("")) {		//Nếu không điền vào chiều cao
					heightTF.requestFocus();//Yêu cầu điền
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập chỉ số chiều cao.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						height = Integer.parseInt(text);
					}catch(NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null,
			                    "Chiều cao không hợp lệ. Hãy kiểm tra lại", "Error",
			                    JOptionPane.ERROR_MESSAGE);
			            return;
					}
					if(height <= 0) {
						heightTF.setText("");
						heightTF.requestFocus();
			            JOptionPane.showMessageDialog(null,
			                    "Chỉ số chiều cao không hợp lệ.", "Error",
			                    JOptionPane.ERROR_MESSAGE);
					}
					else {
						text = weightTF.getText();
						if(text.equals("")) {		//Nếu không điền cân nặng
							weightTF.requestFocus();	//Yêu cầu điền
				            JOptionPane.showMessageDialog(null,
				                    "Bạn chưa nhập chỉ số cân nặng.", "Error",
				                    JOptionPane.ERROR_MESSAGE);
						}
						else {
							try {
								weight = Integer.parseInt(text);
							}catch(NumberFormatException ex2) {
					            JOptionPane.showMessageDialog(null,
					                    "Chỉ số cân nặng không hợp lệ. Hãy kiểm tra lại.", "Error",
					                    JOptionPane.ERROR_MESSAGE);
					            return;
							}
							if(weight <= 0) {
								weightTF.setText("");
								weightTF.requestFocus();
					            JOptionPane.showMessageDialog(null,
					                    "Chỉ số cân nặng không hợp lệ.", "Error",
					                    JOptionPane.ERROR_MESSAGE);
							}
							else {
								heightPic.removeAll();
								weightPic.removeAll();
								heightPic.validate();
								weightPic.validate();
								heightTF.setEditable(false);
								weightTF.setEditable(false);
								validate();
								updateInfor();
							}
						}
					}
				}
							
			}
		});
		
		heightPic = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) heightPic.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_heightPic = new GridBagConstraints();
		gbc_heightPic.insets = new Insets(0, 0, 5, 0);
		gbc_heightPic.anchor = GridBagConstraints.WEST;
		gbc_heightPic.fill = GridBagConstraints.VERTICAL;
		gbc_heightPic.gridwidth = 3;
		gbc_heightPic.gridx = 0;
		gbc_heightPic.gridy = 4;
		panel.add(heightPic, gbc_heightPic);
		
		weightPic = new JPanel();
		FlowLayout flowLayout = (FlowLayout) weightPic.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_weightPic = new GridBagConstraints();
		gbc_weightPic.gridwidth = 3;
		gbc_weightPic.fill = GridBagConstraints.BOTH;
		gbc_weightPic.gridx = 0;
		gbc_weightPic.gridy = 5;
		panel.add(weightPic, gbc_weightPic);

	}
	
	public void ReadToThis(List<Integer> chieu_cao, List<Integer> can_nang, int age, int kieu) {
		this.kieu = kieu;
		this.heightTF.setText("" + chieu_cao.get(chieu_cao.size()-1));
		this.weightTF.setText("" + can_nang.get(can_nang.size()-1));
		//Thêm biểu đồ
		if(age == 1) {
	        ChartPanel heightPanel = new ChartPanel(height.createLineChart(chieu_cao));
	        heightPanel.setPreferredSize(new java.awt.Dimension(900, 600));
	        heightPic.add(heightPanel);

	        ChartPanel weightPanel = new ChartPanel(weight.createLineChart(can_nang));
	        weightPanel.setPreferredSize(new java.awt.Dimension(900, 600));
	        weightPic.add(weightPanel);
	        healthLb.setVisible(false);
	        healthLabel.setVisible(false);
		}
		else {
			//Thêm bảng biểu diễn trạng thái
			healthLb.setVisible(true);
			healthLabel.setVisible(true);
		}
	}
	
	public void updateInfor() {
		ThanhVien t = new ThanhVien();
		t = this.pane.giaDinh.get(kieu);
		if(t instanceof TreCon) {
			((TreCon) t).getChieu_cao().add(Integer.parseInt(heightTF.getText().replace(".", "")));
			((TreCon) t).getCan_nang().add(Integer.parseInt(weightTF.getText().replace(".", "")));

			if(t.getAge() <= 12) {
				ChartPanel heightPanel = new ChartPanel(height.createLineChart(((TreCon) t).getChieu_cao()));
				heightPanel.setPreferredSize(new java.awt.Dimension(900, 600));
				heightPic.add(heightPanel);

				ChartPanel weightPanel = new ChartPanel(weight.createLineChart(((TreCon) t).getCan_nang()));
				weightPanel.setPreferredSize(new java.awt.Dimension(900, 600));
				weightPic.add(weightPanel);
				healthLb.setVisible(false);
				healthLabel.setVisible(false);
				validate();
			}
			else {
				healthLabel.setVisible(true);
				healthLb.setVisible(true);
				validate();
				int height = Integer.parseInt(heightTF.getText());
				int weight = Integer.parseInt(weightTF.getText());
				//Xử lí cân nặng và chiều cao để tính ra được tình trạng cơ thế
				double BMI = (double)weight / (height * height) * 10000;
				if(BMI < 18.5) healthLb.setText("Gầy");
				else if(BMI < 22.9) healthLb.setText("Bình thường");
				else if(BMI < 24.9) healthLb.setText("Tiền béo phì");
				else if(BMI < 29.9) healthLb.setText("Béo phì cấp độ I");
				else if(BMI < 40) healthLb.setText("Béo phì cấp độ II");
				else healthLb.setText("Béo phì cấp độ III");
			}
		}
	}
}
