package imageHandling;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * This Class creates the animation . it simply gets the buffered images and
 * shuffles through them based on a speed that is passed to it through the
 * constructor NOTE the runAnimation method must be invoked in the update
 * section of the GameObject subclass
 * 
 * @author zchem
 *
 */
public class Animation {
	int speed, frames, index = 0, count = 0;

	private BufferedImage[] images;
	private BufferedImage currentImage;

	public Animation(int speed, BufferedImage[] args) {
		this.speed = speed;
		images = new BufferedImage[args.length];// setting images to length of passed array
		for (int i = 0; i < args.length; i++) {
			images[i] = args[i];

		}

		frames = args.length;

	}

	/**
	 * This method will limit the sped at which the nextFrame() is invoked
	 */
	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}

	/**
	 * This method sets the current image
	 */
	private void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i)
				currentImage = images[i];
		}
		count++;
		if (count > frames)
			count = 0;// resetting the loop
	}

	/**
	 * This method is invoked in render() to draw the current image
	 * 
	 * @param g
	 * @param x
	 * @param y
	 * @param scaleX
	 * @param scaleY
	 */
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImage, x, y, scaleX, scaleY, null);
	}
}