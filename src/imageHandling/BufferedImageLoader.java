package imageHandling;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class loads the images.png
 * 
 * @author zchem
 *
 */
public class BufferedImageLoader {

	private BufferedImage image;

	/**
	 * This method loads the image and return it. It is used in @SpriteSheet class
	 * and in @Game class to get background
	 * 
	 * @param path
	 * @return
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
