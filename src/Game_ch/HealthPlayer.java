package Game_ch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Image_editors.Texture;

public class HealthPlayer extends GameObjects  {

	public HealthPlayer(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
health=200;
	
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x-150, (int)y-280, health, 20);
		g.setColor(Color.BLACK);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
