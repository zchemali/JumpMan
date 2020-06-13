package gameObjects;

import static gameObjects.Tag.Block1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import imageHandling.Texture;
/**
 * This is the small enemy classes prior to Boss
 * @author zchem
 *
 */
public class Enemy extends GameObjects{

	int maxCount,width,height;//used for dimensions of the enemy temp.
	public Enemy(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		health=50;
		maxCount =2;
		velx=2;
		width = 30;
		height = 60;
		setGravity(10f);
		falling=true;
		
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		y+=vely;	
		if(falling)
			vely=gravity;
		
		
		//Used so that the enemeys dont fall below the platform
		for (int i=0 ;i<Objects.size();i++) {
			GameObjects temp =Objects.get(i);
			 if(temp.tag==Block1 )
			{	if(getBounds().intersects(temp.getBounds()))
				{setFalling(false);
				y=temp.getY()-30;}
			}
			
		}}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect((int)x, (int)y, width, height);
		Graphics2D g2d =(Graphics2D) g;
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, width-10, height);
	}

}
