package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

/*
 * JPanel thể hiện thông tin, lịch sử tiêm,
 * chỉ số dinh dưỡng, thai kì của bà mẹ
 */

public class MumPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6915575951587625679L;
	public MainTabbedPane pane;
	public InforPanel mumInfor;
	public InjectPane mumInject;
	public Nutrition mumNutrition;
	public PregnancyInfor mumPregnancy;
	/**
	 * Create the panel.
	 */
	public MumPanel(MainTabbedPane pane) {
		this.pane = pane;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Thông tin", null, mumInfor = new InforPanel(this.pane, 1) , null);
		tabbedPane.addTab("Lịch sử tiêm",null,mumInject = new InjectPane(this.pane, 1),null);
		tabbedPane.addTab("Thông tin thai kì", null, mumPregnancy =  new PregnancyInfor(this.pane) , null);
		
		add(tabbedPane);
	}
	
}
