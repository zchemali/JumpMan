package Game_ch;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Image_editors.Texture;

public class MovingObsticale extends GameObjects{
	private int count =0;
	private final int MAX_COUNT=200;
	public MovingObsticale(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		velx=2;
	}

	

	
	@Override
	public void update(ArrayList<GameObjects> Objects) {
		if(count==MAX_COUNT)
		count=0;
		if(count<100)
		{x+=1;
		count++;}
		if(count>=100)
		{	x-=1;
		count++;}
		
		//System.out.println(count);
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
		return  new Rectangle((int)x, (int)y, 100, 30);
	}

}
