package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class InjectionRoom extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5662316675602521060L;
	JPanel contentPane;
	JList<String> myList;
	ArrayList<String> phongtiem = new ArrayList<String>();
	public InjectionRoom(){
		phongtiem.add("Địa chỉ: 137 Lê Thanh Nghị - Hai Bà Trưng - Hà Nội");
		phongtiem.add("Địa chỉ: Viện Thanh Nhàn - Hai Bà Trưng - Hà Nội");
		phongtiem.add("Địa chỉ: Viện Nông Nghiệp - Thanh Trì - Hà Nội");
		phongtiem.add("Địa chỉ: Viện 306 - Hà Đông - Hà Nội");
		phongtiem.add("Địa chỉ: Viện Quân Y 354 - Ba Đình - Hà Nội");
		phongtiem.add("Địa chỉ: Viện TW Quân Đội - Hai Bà Trưng - Hà Nội");
		
		setTitle("Các phòng tiêm lân cận.");
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addAll(phongtiem);
		myList = new JList<String>(model);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(myList);
		add(scrollPane, BorderLayout.CENTER);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600,400);
		setVisible(true);
	}
}