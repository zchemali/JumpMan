package Game_ch;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Image_editors.Texture;

public class Boss extends GameObjects{

	

	public Boss(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		x+=velx;
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
