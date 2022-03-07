package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cuong.Bo;
import cuong.Me;
import cuong.ThanhVien;
import fileProcess.IconResize;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/*
 * JPanel hiện các thông tin của người dùng
 */

public class InforPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2056858241837685088L;
	/**
	 * Create the panel.
	 */
	MainTabbedPane pane;
	JPanel mainPanel;
	String []sex = {"Nam", "Nữ"};
	public JLabel thang;
	public JTextField nameTField;
	public JFormattedTextField ageTField;
	public JTextField mailTField;
	public JComboBox<String> comboBox;
	public int kieu;
	private NumberFormat numberFormat = NumberFormat.getIntegerInstance();
	
	public InforPanel(MainTabbedPane pane, int kieu) {
		this.kieu = kieu;
		this.pane = pane;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{484, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		mainPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{482, 0};
		gbl_mainPanel.rowHeights = new int[]{48, 48, 48, 101, 0};
		gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		mainPanel.add(panel, gbc_panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		nameLabel.setBounds(0, 10, 72, 22);
		panel.add(nameLabel);
		
		nameTField = new JTextField();
		nameTField.setBounds(96, 12, 209, 19);
		panel.add(nameTField);
		nameTField.setEditable(false);
		nameTField.setColumns(10);
		
		JLabel sexLabel = new JLabel("Gi\u1EDBi t\u00EDnh:");
		sexLabel.setBounds(316, 15, 58, 13);
		panel.add(sexLabel);
		
		comboBox = new JComboBox<String>(sex);
		comboBox.setBounds(370, 11, 58, 21);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(sex));
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		mainPanel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(null);
		
		JLabel dateOfBirthLabel = new JLabel("Tuổi:");
		dateOfBirthLabel.setBounds(0, 10, 72, 22);
		panel_2.add(dateOfBirthLabel);
		dateOfBirthLabel.setToolTipText("");
		ageTField = new JFormattedTextField(numberFormat);
		ageTField.setBounds(97, 12, 209, 19);
		panel_2.add(ageTField);
		ageTField.setToolTipText("");
		ageTField.setEditable(false);
		ageTField.setColumns(10);
		
		thang = new JLabel("tháng");
		thang.setVisible(false);
		thang.setBounds(316, 15, 45, 13);
		panel_2.add(thang);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		mainPanel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(null);
		
		JLabel mailLabel = new JLabel("Email:");
		mailLabel.setBounds(0, 10, 72, 22);
		panel_3.add(mailLabel);
		
		mailTField = new JTextField();
		mailTField.setBounds(97, 12, 209, 19);
		panel_3.add(mailTField);
		mailTField.setEditable(false);
		mailTField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		mainPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(null);
		
		JButton rewriteButton = new JButton("S\u1EECA", new IconResize("letter.png", 20, 20));
		rewriteButton.setBounds(10, 29, 100, 21);
		panel_1.add(rewriteButton);
		rewriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTField.setEditable(true);
				mailTField.setEditable(true);
				ageTField.setEditable(true);
			}
		});
		rewriteButton.setToolTipText("Sửa thông tin");
		
		JButton clearButton = new JButton("X\u00D3A", new IconResize("eraser.png", 20, 20));
		clearButton.setBounds(140, 29, 100, 21);
		panel_1.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTField.setText("");
				mailTField.setText("");
				ageTField.setText("");
			}
		});
		clearButton.setToolTipText("Xóa hết dữ liệu");
		
		JButton saveButton = new JButton("L\u01AFU", new IconResize("storage.png", 20, 20));
		saveButton.setBounds(270, 29, 100, 21);
		panel_1.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Nếu không nhập tên với ngày sinh => yêu cầu nhập lại
				if(nameTField.getText().equals("")) {
					nameTField.requestFocus();
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập tên.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}else  if(ageTField.getText().equals("")) {
					ageTField.requestFocus();
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa nhập tuổi.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}
				else {
					nameTField.setEditable(false);
					mailTField.setEditable(false);
					ageTField.setEditable(false);
					updateInfor();
				}
			}
		});
		saveButton.setToolTipText("Lưu dữ liệu vừa nhập");
		
	}
	
	public void readToThis(String name, int age, String mail, String sex, int kieu) {
		this.kieu = kieu;
		this.nameTField.setText(name);
		this.ageTField.setText(""+age);
		this.mailTField.setText(mail);
		if(sex.equals("Nam"))
			this.comboBox.setSelectedItem("Nam");
		else this.comboBox.setSelectedItem("Nữ");
	}
	
	public void updateInfor() {
		ThanhVien t = this.pane.giaDinh.get(kieu);
		t.setName(this.nameTField.getText());
		t.setAge(Integer.parseInt(this.ageTField.getText().replace(".", "")));
		t.setSex(this.comboBox.getSelectedItem().toString());
		if(t instanceof Bo ) {
			((Bo)t).setEmail(this.mailTField.getText());
		}
		else if(t instanceof Me) {
			((Me)t).setEmail(this.mailTField.getText());
		}
	}
}
