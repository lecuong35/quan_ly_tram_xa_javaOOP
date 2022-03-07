package gui;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import cuong.QuanLy;
import cuong.ThanhVien;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Main {
	ArrayList<ThanhVien> thanhVien;
	MainPanel mainPanel;
	public Main() {
		JFrame frame = new JFrame();
		frame.setTitle("Ứng dụng quản lí sức khỏe gia đình");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new CardLayout(0,0));

		//add(new GUI());
		mainPanel = new MainPanel();
		thanhVien = new ArrayList<ThanhVien>();
		QuanLy.readFile(thanhVien, mainPanel);
		frame.add(mainPanel);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				QuanLy.writeFile(mainPanel.familyPane);
			}
			
		});
		frame.setSize(1000,500);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
