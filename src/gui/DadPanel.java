package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

/*
 * JPanel thể hiện thông tin, lịch sử tiêm,
 * chỉ số dinh dưỡng của cha
 */

public class DadPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9176537411779295364L;
	public MainTabbedPane pane;
	public InforPanel dadInfor;
	public Nutrition dadNutrition;
	public InjectPane dadInject;
	/**
	 * Create the panel.
	 */
	public DadPanel(MainTabbedPane pane) {
		this.pane = pane;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		tabbedPane.addTab("Thông tin", null,dadInfor = new InforPanel(this.pane, 0), null);
		tabbedPane.addTab("Lịch sử tiêm",null, dadInject = new InjectPane(this.pane, 0), null);
	}	

}
