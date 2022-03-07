package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.event.ListSelectionListener;

import cuong.ThanhVien;
import fileProcess.IconResize;

import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Color;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3566377227932409199L;
	public ArrayList<MainTabbedPane> familyPane;
	public JList<String> myList;
	public JTextField textField;
	public JPanel rightPanel;
	public JLayeredPane leftPanel;
	
	/*
	public class TableModel extends AbstractTableModel{
		public ArrayList<GiaDinh> giadinh;
		
		public int getRowCount() {
	        return giadinh.size();
	    }
		
		public int getColumnCount() {
	        return 3;
	    }
		
		public String getValueAt(int rowIndex, int columnIndex) {
	        if(columnIndex == 1)	return ""+rowIndex;
	        else if(columnIndex == 2)	return giadinh.get(rowIndex-1).getTenGiaDinh();
	        else if(columnIndex == 3)	return giadinh.get(rowIndex-1).getList().get(0).
			return null;
	        
	    }
	}
	*/
	
	private ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand() == "XÓA") {
	            deleteItem();
	            return;
	        }
	        if (e.getActionCommand() == "THÊM") {
	            addItem();
	        }
	        if (e.getActionCommand() == "SỬA") {
	        	renameItem();
	        }
		}
	};
	public ListSelectionListener listListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			int index = myList.getSelectedIndex();
            leftPanel.removeAll();
            leftPanel.add(familyPane.get(index));
            leftPanel.validate();
		}
	};

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		//setContentPane(contentPane);
		
		// Khởi tạo
		familyPane = new ArrayList<MainTabbedPane>();
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(splitPane);
		
		leftPanel = new JLayeredPane();
		leftPanel.setMinimumSize(new Dimension(500, 0));
		leftPanel.setBounds(new Rectangle(100, 100, 100, 100));
		splitPane.setLeftComponent(leftPanel);
		leftPanel.setLayout(new CardLayout(0, 0));
		
		JPanel rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		rightPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 224, 208));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("THÊM", new IconResize("plus.png", 20, 20));
		btnNewButton.addActionListener(listener);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("XÓA", new IconResize("eraser.png", 20, 20));
		btnNewButton_1.addActionListener(listener);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SỬA", new IconResize("letter.png", 20, 20));
		btnNewButton_2.addActionListener(listener);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 224, 208));
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nhập ID:");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel_1.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Gửi mail");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MailFrame();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Thông tin phòng tiêm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InjectionRoom();
			}
		});
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		panel.add(btnNewButton_4);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Số lượng vaccine");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VaccineNumber(familyPane);
			}
		});
		panel.add(btnNewButton_5);
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		myList = new JList<String>(model);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myList.addListSelectionListener(listListener);
		JScrollPane scrollPane = new JScrollPane(myList);
		rightPanel.add(scrollPane, BorderLayout.CENTER);
		
		
	}
    
    private void deleteItem() {
    	int index = myList.getSelectedIndex();
    	myList.removeListSelectionListener(listListener);
    	DefaultListModel<String> model  = (DefaultListModel<String>) myList.getModel();
    	
        // xóa item và panel tương ứng trong myList và familyPane
    	familyPane.remove(index);
    	model.removeElementAt(index);
    	
    	//Chỉnh sửa thứ tự danh sách
    	StringBuffer s;
    	for(int i=index; i<familyPane.size(); i++) {
    		s = new StringBuffer(model.get(i).split(".", 2)[1]); 		
    		model.set(i, "" + (i+1) + s);
    	}
    	
    	//Cài đặt hiển thị
    	myList.setModel(model);
    	myList.addListSelectionListener(listListener);
    	if(index < familyPane.size())
    		myList.setSelectedIndex(index);
    	else myList.setSelectedIndex(index - 1);
    	//leftPanel.removeAll();
    	//leftPanel.validate();
    }
    
    private void addItem() {
        if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Bạn chưa nhập ID hộ gia đình.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
        	String item = "" + (familyPane.size()+1) + "." + textField.getText().trim();
        	myList.removeListSelectionListener(listListener);
            DefaultListModel<String> model = (DefaultListModel<String>) myList.getModel();
            model.addElement(item);
            myList.setModel(model);
            myList.addListSelectionListener(listListener);
            /*MainTabbedPane newPane = new MainTabbedPane();
            for(int i=0; i<newPane.giaDinh.size(); i++)
            	newPane.giaDinh.get(i).setId(textField.getText().trim());
            familyPane.add(newPane);*/
            //Thêm Panel tương ứng với list vừa tạo vào bên trái
            leftPanel.removeAll();
            leftPanel.add(createNewPanel(textField.getText().trim()));
            leftPanel.validate();
            textField.setText("");
            
        }
    }
    
    private void renameItem() {
        if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Bạn chưa ID tên hộ gia đình.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
        	int index = myList.getSelectedIndex();
        	DefaultListModel<String> model = (DefaultListModel<String>) myList
                    .getModel();
        	model.set(index, "" + (index+1) + "." + textField.getText().trim()); 
        	for(ThanhVien t: familyPane.get(index).giaDinh) {
        		t.setId(textField.getText().trim());
        	}
        	
        	textField.setText("");
        	myList.removeListSelectionListener(listListener);
        	myList.setModel(model);
        	myList.addListSelectionListener(listListener);
        }
    }
    //Tạo thêm Panel tương ứng với JList
    public MainTabbedPane createNewPanel(String ID) {
    	MainTabbedPane newPane = new MainTabbedPane();
        for(int i=0; i<newPane.giaDinh.size(); i++)
        	newPane.giaDinh.get(i).setId(ID);
    	familyPane.add(newPane);
    	return newPane;
    }
}
