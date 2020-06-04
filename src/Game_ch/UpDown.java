
package Game_ch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class UpDown extends GameObjects {
private final int MAX_COUNT=200;
	public UpDown(float x, float y, Tag tag) {
		super(x, y, tag);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		if(count==MAX_COUNT)
			count=0;
			if(count<100)
			{y+=3;
			count++;}
			if(count>=100)
			{	y-=3;
			count++;}	// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);	
		g.fillRect((int)x,(int) y, 100, 30);
		Graphics2D g2d =(Graphics2D) g;
		g.setColor(Color.WHITE);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 100, 30);
	}

}
