package gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import fileProcess.IconResize;

/*
 * Lớp nút nhấn để thêm ảnh vào JPanel panel
 */

public class FileButton extends JButton implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2122372112725029898L;
	private java.io.File[] file;
	private JPanel panel;
	protected ArrayList<String> link;
	private InjectInfor inject;
	public static final File target = new File(System.getProperty("user.dir") + "\\DuLieu\\Anh");	
	public FileButton(JPanel panel, InjectInfor inject) {
		this.inject = inject;
		setIcon(new IconResize("pictures.png",20,20));
		setText("Thêm ảnh");
		this.panel = panel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fileDialog = new JFileChooser();
		fileDialog.setMultiSelectionEnabled(true);
		fileDialog.setAcceptAllFileFilterUsed(false);
		fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		fileDialog.setDialogTitle("Select Image/Images");
		int returnVal = fileDialog.showOpenDialog(new JFrame());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileDialog.getSelectedFiles();//Lấy file đã chọn trong JFileChooser
			/*
			ImageIcon icon = new ImageIcon(file.getAbsolutePath());//Tạo ảnh
			Image newIcon = ResizeImage.getScaledImage(icon, 120, 120);//Chinh sửa kích thước ảnh
			icon = new ImageIcon(newIcon);
			 */
			for(File f: file) {
				//Them anh
				ImageIcon original = new ImageIcon(f.getAbsolutePath());
				int height = original.getIconHeight();
				int width = original.getIconWidth();
				while(width > 500 || height > 600) {
					height *= 0.75;
					width *= 0.75;
				}
				IconResize icon = new IconResize(f.getAbsolutePath(), width, height);
				JButton p = new JButton(icon);
				p.setContentAreaFilled(false);
				p.setBorderPainted(false);
				p.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						JDialog dialog = new JDialog();
						dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);


						@SuppressWarnings("serial")
						JPanel pane = new JPanel() {
							@Override
							public void paintComponent(Graphics g){
								Dimension d = getSize();
								g.drawImage(original.getImage(), 0, 0, d.width, d.height, null);
								setOpaque(false);
								super.paintComponent(g);
							} 
						};
						dialog.getContentPane().add(pane);
						dialog.setSize(new Dimension(original.getIconWidth()/2, original.getIconHeight()/2));
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);

					}
				});
				panel.add(p);
				panel.validate();

				try {
					org.apache.commons.io.FileUtils.copyFileToDirectory(f, target);
					inject.picture.add(target.getAbsolutePath() +"\\" + f.getName());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
