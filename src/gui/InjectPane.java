package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;

import cuong.TiemChung;

import javax.swing.event.ChangeEvent;

/*
 * JPanel có các tab là các thông tin mỗi lần tiêm
 */

public class InjectPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3799056375872606556L;
	public JTabbedPane injectPane;
	public int numTabs = 0;
	public ArrayList<InjectInfor> inforPanel;
	JPanel addTab;
	public MainTabbedPane pane;
	public int kieu;/*kieu = 0 => thuoc DadPanel
						   = 1 => thuoc MumPanel
						   > 1 => thuoc ChildPanel voi thu tu = kieu - 3
						   */ 

	public InjectPane(MainTabbedPane pane, int kieu) {
		this.kieu = kieu;
		this.pane = pane;
		setLayout(new GridLayout(1, 1, 0, 0));
		inforPanel = new ArrayList<InjectInfor>();
		injectPane = new JTabbedPane(JTabbedPane.TOP);
		injectPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		injectPane.setAutoscrolls(true);

		InjectInfor panel = new InjectInfor(this, kieu, 0);
		
		//pane.giaDinh.get(kieu).tiemChungs.add(new TiemChung());
		
		inforPanel.add(panel);
		injectPane.addTab("L\u1EA7n 1", null, panel, null);
		injectPane.setTabComponentAt(0, new InjectPaneTab(this));
		injectPane.setEnabledAt(0, true);
		numTabs++;

		injectPane.addTab("+", addTab = new JPanel());
		injectPane.addChangeListener(listener);
		numTabs ++;


		add(injectPane);
	}

	ChangeListener listener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			addNewTab();
		}
	};

	public void addNewTab() {
		int index = numTabs - 1;
		if(injectPane.getSelectedIndex() == index) {//Nếu ấn vào tab "+"
			/* add new tab */
			pane.giaDinh.get(kieu).tiemChungs.add(new TiemChung());
			InjectInfor panel = new InjectInfor(this, kieu, index);
			inforPanel.add(panel);
			injectPane.insertTab("Lần " + String.valueOf(index +1), null, panel,"", index);
			/* set tab is custom tab */
			injectPane.setTabComponentAt(index, new InjectPaneTab(this));
			this.validate();
			injectPane.removeChangeListener(listener);
			injectPane.setSelectedIndex(index);
			injectPane.addChangeListener(listener);
			numTabs++;
		}
	}

	public void removeTab(int index) {
		injectPane.remove(index);
		inforPanel.remove(index);
		for(int i=index; i<inforPanel.size(); i++) {
			inforPanel.get(index).thutu --;
		}
		pane.giaDinh.get(kieu).tiemChungs.remove(index);
		numTabs--;

		//Sau khi xóa 1 tab -> mở tab ở trước tab bị xóa
		if (index == (numTabs -1) && index > 0) {
			injectPane.setSelectedIndex(numTabs - 2);
		} else {
			injectPane.setSelectedIndex(index);
		}

		//Đặt lại thứ tự các lần tiêm khi xóa
		for(int i=0; i<numTabs-1; i++) {
			injectPane.setTitleAt(i, "Lần " + (i+1));
		}
		//Nếu xóa hết tab -> tạo ra 1 tab khác
		if (numTabs == 1) {
			addNewTab();
		}
	}

	public void readToTab(String tenThuoc, String ngayTiem, List<String> file_anh, int kieu, int thutu) {
		int index = numTabs - 1;
		if(index == 1) {
			inforPanel.get(0).readToThis(tenThuoc, ngayTiem, file_anh, thutu);
		}
		else {
			InjectInfor panel = new InjectInfor(this, kieu, thutu);
			panel.readToThis(tenThuoc, ngayTiem, file_anh, thutu);
			inforPanel.add(panel);
			injectPane.insertTab("Lần " + String.valueOf(index +1), null, panel,"", index);
			/* set tab is custom tab */
			injectPane.setTabComponentAt(index, new InjectPaneTab(this));
			this.validate();
			injectPane.removeChangeListener(listener);
			injectPane.setSelectedIndex(index);
			injectPane.addChangeListener(listener);
			numTabs++;
		}
	}
}