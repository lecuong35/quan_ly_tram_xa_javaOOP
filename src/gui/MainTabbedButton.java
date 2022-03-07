package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


/*
 * Tùy biến tab của MainTabbedPane
 * giúp tab của nó có thêm button "x" để xóa tab
 */
 
public class MainTabbedButton extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2237311050224307817L;
	MainTabbedPane customJTabbedPane;
	
	/** JPanel contain a JLabel and a JButton to close */
	public MainTabbedButton(MainTabbedPane customJTabbedPane) {
		this.customJTabbedPane = customJTabbedPane;
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setBorder(new EmptyBorder(5,2,2,2));
		setOpaque(false);
		addLabel();
		add(new CustomButton("x"));
	}
	
	private void addLabel() {
		@SuppressWarnings("serial")
		JLabel label = new JLabel() {
			/** set text for JLabel, it will title of tab */
			
			public String getText() {
                int index = customJTabbedPane.mainTabbedPane
                        .indexOfTabComponent(MainTabbedButton.this);
                if (index != -1) {
                    return customJTabbedPane.mainTabbedPane.getTitleAt(index);
                }
                return null;
            }
		};
		// Tao ra them khoang trong giua label va button
		label.setBorder(new EmptyBorder(0,0,0,10));
		add(label);
	}
	
	
	class CustomButton extends JButton implements MouseListener {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1909500619442993722L;

		public CustomButton(String text) {
            int size = 15;
            setText(text);
            /** set size for button close */
            setPreferredSize(new Dimension(size, size));
 
            setToolTipText("close the Tab");
 
            /** set transparent */
            setContentAreaFilled(false);
 
            /** set border for button */
            setBorder(new EtchedBorder());
            /** don't show border */
            setBorderPainted(false);
 
            setFocusable(false);
 
            /** add event with mouse */
            addMouseListener(this);
 
        }
 
        /** when click button, tab will close */
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = customJTabbedPane.mainTabbedPane
                    .indexOfTabComponent(MainTabbedButton.this);
            if (index != -1) {
                customJTabbedPane.removeTab(index);
            }
        }
 
        @Override
        public void mousePressed(MouseEvent e) {
        }
 
        @Override
        public void mouseReleased(MouseEvent e) {
        }
 
        /** show border button when mouse hover */
        @Override
        public void mouseEntered(MouseEvent e) {
            setBorderPainted(true);
            setForeground(Color.RED);
        }
 
        /** hide border when mouse not hover */
        @Override
        public void mouseExited(MouseEvent e) {
            setBorderPainted(false);
            setForeground(Color.BLACK);
        }
    }
}
