
package Game_ch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Image_editors.Texture;

/**
 * This class for objects that move up and down.Note I could combine them in
 * platform but it will make code longer Next step is to combine moving objects
 * in separate class
 * 
 * @author zchem
 *
 */
public class UpDown extends GameObjects {
	private final int MAX_COUNT = 200;

	public UpDown(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		if (count == MAX_COUNT)
			count = 0;
		if (count < 100) {
			y += 3;
			count++;
		}
		if (count >= 100) {
			y -= 3;
			count++;
		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 100, 30);
		// drawing boundaries
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 100, 30);
	}

}
