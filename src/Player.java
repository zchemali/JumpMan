import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends GameObjects{
	private static final float MAX_VELY = 4;
	private int width=48,height=92;
	private boolean jumping=true;
	public Player(float x, float y, Tag tag) {
		super(x, y, tag);
		falling=true;
		setGravity(0.2f);
		
	}

	

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		x+=velx;
		y+=vely;
		
	
		if(falling || jumping)
		{vely+=gravity;
		if (vely>MAX_VELY)
			vely=MAX_VELY;}
		for (int i=0; i<Objects.size();i++)
		{	GameObjects temp =Objects.get(i);
			//System.out.println(temp.x);
			if (temp.tag==Tag.Block1) {
				//System.out.println("yes");
				if(getBounds().intersects(temp.getBounds())) {
					vely=0;
					
					}
				
					if(getBoundsLeft().intersects(temp.getBounds()))
						{velx=0;
						}
					if(getBoundsRight().intersects(temp.getBounds()))
					{velx=0;
					
					}
					if(getBoundsTop().intersects(temp.getBounds()))
					{ vely=0;
					
					}
				
				}
			}
		}
		
	
		
		
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, height);
		Graphics2D g2d;
		g.setColor(Color.BLUE);
		g2d=(Graphics2D) g;
		g2d.draw(getBounds());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsTop());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x+5,(int)y+75,width-10,height-70);

	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x-2,(int)y+2,width-42,height);
}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x+44,(int)y-2,width-42,height);
}
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x+5,(int)y,width-10,height-70);
}
}