package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import cuong.QuanLy;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VaccineNumber extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3464963527771993324L;
	private final JPanel contentPanel = new JPanel();
	private MaskFormatter format;
	public static final String[] columnName = {"Tháng", "Số mũi vaccine"};
	private ArrayList<Integer> vaccine;
	private JPanel panel;
	/**
	 * Launch the application.
	 */


	public class TableModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5618015006201099087L;
		public final String[] columName = {"Tháng", "Số mũi vaccine"};

		public int getRowCount() {
			return vaccine.size();
		}

		public int getColumnCount() {
			return 2;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if(columnIndex == 0)	return rowIndex + 1;
			else if(columnIndex == 1)	return vaccine.get(rowIndex);
			return "";	        
		}

		@Override
		public String getColumnName(int column) {
			return columnName[column];
		}
	}

	/**
	 * Create the dialog.
	 */
	public VaccineNumber(ArrayList<MainTabbedPane> mainPane) {
		try {
			format = new MaskFormatter("####");
			format.setPlaceholderCharacter('#');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{105, 45, 125, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNewLabel = new JLabel("Năm:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);

		JFormattedTextField yearTF = new JFormattedTextField(format);
		GridBagConstraints gbc_yearTF = new GridBagConstraints();
		gbc_yearTF.insets = new Insets(0, 0, 5, 5);
		gbc_yearTF.anchor = GridBagConstraints.NORTH;
		gbc_yearTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearTF.gridx = 2;
		gbc_yearTF.gridy = 0;
		contentPanel.add(yearTF, gbc_yearTF);


		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !yearTF.getText().equals("####") ) {
					vaccine = QuanLy.dem_vacxin_nam_nay(Integer.parseInt(yearTF.getText()), mainPane);
					JTable table = new JTable(new TableModel());
					JScrollPane scroll = new JScrollPane(table);
					panel.add(scroll, BorderLayout.CENTER);
					validate();
				}
			}
		});
		contentPanel.add(btnNewButton, gbc_btnNewButton);
		/*
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		 */
		setTitle("Số lượng vaccine theo tháng");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
