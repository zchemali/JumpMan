package imageHandling;

import java.awt.image.BufferedImage;

/**
 * This class crops the images from the spritesheet
 * 
 * @author zchem
 *
 */
public class SpriteSheet {
	private BufferedImage image;

	/**
	 * Constructor to set the image @param
	 * 
	 * @param image
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	/**
	 * This method crops the image at specific coordinates
	 * 
	 * @param col    of the sprite sheet
	 * @param row    of the sprite sheet
	 * @param width  of the image . usually its 32
	 * @param height of the image . usually its 32
	 * @return the cropped image
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		return img;
	}
}
