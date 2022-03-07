package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cuong.Bo;
import cuong.Me;
import cuong.ThanhVien;
import cuong.TreCon;


public class MainTabbedPane extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6312980063540810520L;
	public JTabbedPane mainTabbedPane;
	public int numTabs=0;
	public JPanel addTab;
	public DadPanel dadPanel;
	public MumPanel mumPanel;
	public ArrayList<ChildPanel> childPanel;
	public ArrayList<ThanhVien> giaDinh;
	
	/**
	 * Create the panel.
	 */
	public MainTabbedPane() {
		createJTabbedPane();
		setLayout(new GridLayout(1,1,0,0));
		add(mainTabbedPane);
	}

    /** create JTabbedPane contain 2 tab */
    public void createJTabbedPane() {
    	/* them 3 thanh vien */
    	giaDinh = new ArrayList<ThanhVien>();
    	giaDinh.add(new Bo());
    	giaDinh.add(new Me());
    	giaDinh.add(new TreCon());
        /* create JTabbedPane */
        mainTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        
        /* add 3 tab: Dad, Mum, First Child to mainTabbedPane */
        mainTabbedPane.add(dadPanel = new DadPanel(this),"Bố", numTabs++);
        mainTabbedPane.add(mumPanel = new MumPanel(this),"Mẹ", numTabs++);
        childPanel = new ArrayList<ChildPanel>();
        ChildPanel firstChild= new ChildPanel(this, 2);
        firstChild.childInfor.thang.setVisible(true);
        childPanel.add(firstChild);
        mainTabbedPane.add(childPanel.get(0),"Con đầu", numTabs++);
        
        /* add tab to add new tab when click */
        mainTabbedPane.addTab("+",new JPanel());
        numTabs++;
        mainTabbedPane.addChangeListener(changeListener);
    }
    
 
    public ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            addNewTab();
        }
    };
 
    public void addNewTab() {
        int index = numTabs - 1;
        if (mainTabbedPane.getSelectedIndex() == index) { /* if click new tab */
        	TreCon tre = new TreCon();
        	tre.setId(giaDinh.get(0).getId());
        	giaDinh.add(tre);
        	
        	/* add new tab */
        	ChildPanel newChild = new ChildPanel(this, numTabs);
        	newChild.childInfor.thang.setVisible(true);
        	childPanel.add(newChild);
            mainTabbedPane.insertTab("Con thứ " + String.valueOf(index - 1), null, newChild,null, index);
            /* set tab is custom tab */
            mainTabbedPane.setTabComponentAt(index, new MainTabbedButton(this));
            mainTabbedPane.removeChangeListener(changeListener);
            mainTabbedPane.setSelectedIndex(index);
            mainTabbedPane.addChangeListener(changeListener);
            numTabs++;
        } 
    }
 
    public void removeTab(int index) {
    	giaDinh.remove(index);
        mainTabbedPane.remove(index);
        numTabs--;
 
        if (index == (numTabs -1) && index > 0) {
            mainTabbedPane.setSelectedIndex(numTabs - 2);
        } else {
            mainTabbedPane.setSelectedIndex(index);
        }
        
        for(int i=3; i<numTabs-1; i++) {
        	mainTabbedPane.setTitleAt(i, "Con thứ " + (i-1));
        }
    }
}
