package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import imageHandling.Texture;

/**
 * This class is for obstacles that move left and right
 * 
 * @author zchem
 *
 */
public class MovingObsticale extends GameObjects {
	private int count = 0;
	private final int MAX_COUNT = 200;
	private BufferedImage[] image;

	public MovingObsticale(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		velx = 2;
		image=texture.getBlocks();
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		if (count == MAX_COUNT)
			count = 0;
		if (count < 100) {
			x += 1;
			count++;
		}
		if (count >= 100) {
			x -= 1;
			count++;
		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image[4],(int) x,(int) y, 100, 30, null);
//drawing boundaries
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.WHITE);
		//g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 100, 30);
	}

}
