package gui;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


/*
 * Tùy biến tab của InjectPane
 * giúp tab của nó có thêm button "x" để xóa tab
 */

public class InjectPaneTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7046194281501070489L;
	InjectPane injectPane;
	
	/** JPanel contain a JLabel and a JButton to close */
	public InjectPaneTab(InjectPane injectPane) {
		this.injectPane = injectPane;
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
                int index = injectPane.injectPane
                        .indexOfTabComponent(InjectPaneTab.this);
                if (index != -1) {
                    return injectPane.injectPane.getTitleAt(index);
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
		private static final long serialVersionUID = -1440579100738787093L;

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
            int index = injectPane.injectPane
                    .indexOfTabComponent(InjectPaneTab.this);
            if (index != -1) {
                injectPane.removeTab(index);
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

