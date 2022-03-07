package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

/*
 * JPanel thể hiện thông tin, lịch sử tiêm,
 * chỉ số dinh dưỡng của trẻ
 */

public class ChildPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4895535111999392545L;
	public MainTabbedPane pane;
	public InforPanel childInfor;
	public InjectPane childInject;
	public Nutrition childNutrition;
	public JTabbedPane tabbedPane;
	int kieu;
	/**
	 * Create the panel.
	 */
	public ChildPanel(MainTabbedPane pane, int kieu) {
		this.pane = pane;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		tabbedPane.addTab("Thông tin", null, childInfor = new InforPanel(this.pane, kieu), null);
		tabbedPane.addTab("Lịch sử tiêm", null, childInject = new InjectPane(this.pane, kieu), null);
		tabbedPane.addTab("Chỉ số dinh dưỡng", null, childNutrition = new Nutrition(this.pane, kieu),null);
	}
	
}
