package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cuong.QuanLy;
import fileProcess.IconResize;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Dialog;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4008990407787702206L;
	private JPanel contentPane;
	public JTextField sender;
	private JPasswordField password;
	private JTextField receiver;
	private JTextField object;

	/**
	 * Create the frame.
	 */
	public MailFrame() {
		setTitle("Send Mail");

		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("G\u1EECI MAIL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 108, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email g\u1EEDi:");
		lblNewLabel_1.setBounds(0, 10, 85, 13);
		panel_1.add(lblNewLabel_1);
		
		sender = new JTextField();
		sender.setBounds(145, 7, 250, 19);
		panel_1.add(sender);
		sender.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_2.setBounds(0, 13, 106, 13);
		panel_2.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(145, 10, 250, 19);
		panel_2.add(password);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Email nh\u1EADn:");
		lblNewLabel_3.setBounds(0, 10, 125, 13);
		panel_3.add(lblNewLabel_3);
		
		receiver = new JTextField();
		receiver.setBounds(145, 7, 250, 19);
		panel_3.add(receiver);
		receiver.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ch\u1EE7 \u0111\u1EC1:");
		lblNewLabel_5.setBounds(0, 10, 135, 13);
		panel_4.add(lblNewLabel_5);
		
		object = new JTextField();
		object.setBounds(145, 7, 250, 19);
		panel_4.add(object);
		object.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("N\u1ED9i dung:");
		lblNewLabel_4.setLocation(new Point(10, 0));
		panel_5.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JTextArea content = new JTextArea();
		content.setWrapStyleWord(true);
		content.setLineWrap(true);
		panel_5.add(content, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton = new JButton("G\u1EEDi", new IconResize("message.png", 30, 30));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String Sender, Receiver, Pass, Content, Object;
				if(sender.getText().equals("")) {
					sender.requestFocus();
				}else {
					Sender = sender.getText();
					if(password.getText().equals("")) {
						password.requestFocus();
					}else {
						Pass = password.getText();
						if(receiver.getText().equals("")) {
							receiver.requestFocus();
						}else {
							Receiver = receiver.getText();
							Content = content.getText();
							Object = object.getText();
							try {
								QuanLy.gui_mail(Sender, Pass, Receiver, Object, Content);
					            JOptionPane.showMessageDialog(null,
					                    "Đã gửi email thành công!", "Thông báo",
					                    JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e1) {
					            JOptionPane.showMessageDialog(null,
					                    "Không thể gửi email, hãy kiểm tra lại!", "Error",
					                    JOptionPane.ERROR_MESSAGE);
					            return;
							}
						}
					}
				}
			}
		});
		panel_6.add(btnNewButton);
		//sender.setText("nguyenquangvu05042001@gmail.com");
		//password.setText("vu05042001");
		
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
