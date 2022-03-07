package fileProcess;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IconResize extends ImageIcon{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812543879921221416L;

	public IconResize(String path, int width, int height) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ImageIcon iconButton = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        setImage(iconButton.getImage());
	}
}