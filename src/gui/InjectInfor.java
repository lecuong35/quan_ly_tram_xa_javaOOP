package gui;

import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cuong.ThanhVien;
import cuong.TiemChung;
import fileProcess.IconResize;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.FlowLayout;

/*
 * JPanel hiển thị thông tin tiêm chủng
 */

public class InjectInfor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6998677811124279827L;
	public JFormattedTextField dateTF;
	public JTextField vaccineTF;
	public ArrayList<String> picture;
	public JPanel picturePanel;
	public InjectPane injectPane;
	public FileButton picButton;
	int thutu;
	int kieu;
	/**
	 * Create the panel.
	 */
	public InjectInfor(InjectPane pane,int kieu, int thutu) {
		picture = new ArrayList<String>();
		injectPane = pane;
		this.kieu = kieu;
		this.thutu = thutu;
		setAutoscrolls(true);
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setSize(900, 800);

		//add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{900, 0};
		gbl_panel_7.rowHeights = new int[]{156, 800, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_7.add(panel_6, gbc_panel_6);
		panel_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{377, 0};
		gbl_panel_6.rowHeights = new int[] {40, 40, 72, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_6.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {118, 35, 330, 0};
		gbl_panel.rowHeights = new int[]{22, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel injectDateLabel = new JLabel("Ng\u00E0y ti\u00EAm:");
		GridBagConstraints gbc_injectDateLabel = new GridBagConstraints();
		gbc_injectDateLabel.fill = GridBagConstraints.BOTH;
		gbc_injectDateLabel.insets = new Insets(0, 0, 0, 5);
		gbc_injectDateLabel.gridx = 0;
		gbc_injectDateLabel.gridy = 0;
		panel.add(injectDateLabel, gbc_injectDateLabel);

		dateTF = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dateTF.setEditable(false);
		dateTF.setToolTipText("Nhập theo định dạng: dd/mm/yyyy");
		GridBagConstraints gbc_dateTF = new GridBagConstraints();
		gbc_dateTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateTF.gridx = 2;
		gbc_dateTF.gridy = 0;
		panel.add(dateTF, gbc_dateTF);
		dateTF.setColumns(10);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_6.add(panel_2, gbc_panel_2);
		panel_2.setLayout(null);

		JLabel vaccineLabel = new JLabel("Lo\u1EA1i vaccine:");
		vaccineLabel.setBounds(0, 0, 89, 22);
		panel_2.add(vaccineLabel);

		vaccineTF = new JTextField();
		vaccineTF.setEditable(false);
		vaccineTF.setBounds(153, 2, 330, 20);
		panel_2.add(vaccineTF);
		vaccineTF.setColumns(10);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_6.add(panel_5, gbc_panel_5);
		panel_5.setLayout(null);

		JLabel pictureLabel = new JLabel("H\u00ECnh \u1EA3nh:");
		pictureLabel.setBounds(0, 11, 188, 40);
		panel_5.add(pictureLabel);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		picturePanel = new JPanel();
		scrollPane.setViewportView(picturePanel);
		picturePanel.setBackground(Color.WHITE);
		picButton = new FileButton(picturePanel, this);
		picturePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		picButton.setBounds(127, 21, 115, 20);
		panel_5.add(picButton);

		JButton btnNewButton = new JButton("LƯU", new IconResize("storage.png", 20, 20));
		btnNewButton.setBounds(299, 21, 85, 21);
		panel_5.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SỬA", new IconResize("letter.png", 20, 20));
		btnNewButton_1.setBounds(394, 21, 85, 21);
		panel_5.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("XÓA", new IconResize("eraser.png", 20, 20));
		btnNewButton_2.setBounds(489, 21, 85, 21);
		panel_5.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTF.setText("");
				vaccineTF.setText("");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTF.setEditable(true);
				vaccineTF.setEditable(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dateTF.getText().equals("")) {
					dateTF.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Bạn chưa nhập ngày tiêm.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else  if(vaccineTF.getText().equals("")) {
					vaccineTF.requestFocus();
					JOptionPane.showMessageDialog(null,
							"Bạn chưa nhập tên vaccine.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}else {
					dateTF.setEditable(false);
					vaccineTF.setEditable(false);
					if(injectPane.pane.giaDinh.get(kieu).tiemChungs.size() <= thutu) injectPane.pane.giaDinh.get(kieu).tiemChungs.add(new TiemChung());
					updateInfor();
				}
			}
		});


		panel_7.add(scrollPane, gbc_scrollPane);

		JScrollPane scroll = new JScrollPane(panel_7);
		panel_7.setSize(900, 1200);
		panel_7.setPreferredSize(new Dimension(900, 1200));
		panel_7.revalidate();
		add(scroll);
	}

	public void readToThis(String tenThuoc, String ngayTiem, List<String> file_anh, int thutu) {
		this.thutu = thutu;
		this.dateTF.setText(ngayTiem);
		this.vaccineTF.setText(tenThuoc);
		for(String link: file_anh) {
			//Them anh
			ImageIcon original = new ImageIcon(link);
			int height = original.getIconHeight();
			int width = original.getIconWidth();
			while(width > 500 || height > 600) {
				height *= 0.75;
				width *= 0.75;
			}
			IconResize icon = new IconResize(link, width, height);
			JButton p = new JButton(icon);
			p.setContentAreaFilled(false);
			p.setBorderPainted(false);
			p.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt) {
					JDialog dialog = new JDialog();
					dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);


					@SuppressWarnings("serial")
					JPanel panel = new JPanel() {
						@Override
						public void paintComponent(Graphics g){
							Dimension d = getSize();
							g.drawImage(original.getImage(), 0, 0, d.width, d.height, null);
							setOpaque(false);
							super.paintComponent(g);
						} 
					};
					dialog.getContentPane().add(panel);
					dialog.setSize(new Dimension(original.getIconWidth()/2, original.getIconHeight()/2));
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				}
			});
			picturePanel.add(p);
			picturePanel.validate();

			try {
				File f = new File(link);			 
	            if (!f.exists()) 
	            	org.apache.commons.io.FileUtils.copyFileToDirectory(f, FileButton.target);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updateInfor() {
		if(dateTF.getText() != "") {
			int day = Integer.parseInt(dateTF.getText().split("/")[0]);
			int month = Integer.parseInt(dateTF.getText().split("/")[1]);
			int year = Integer.parseInt(dateTF.getText().split("/")[2]);
			LocalDate date = LocalDate.of(year, month, day);
			ThanhVien t = injectPane.pane.giaDinh.get(kieu);
			t.tiemChungs.get(thutu).setNgayTiem(date);
			t.tiemChungs.get(thutu).setTenThuocString(vaccineTF.getText());
			t.tiemChungs.get(thutu).setFile_anh(this.picture);
		}
	}
}
