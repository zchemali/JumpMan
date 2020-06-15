package gameObjects;

import static gameObjects.Tag.Block1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import imageHandling.Animation;
import imageHandling.Texture;
/**
 * This is the small enemy classes prior to Boss
 * @author zchem
 *
 */
public class Enemy extends GameObjects{
	BufferedImage[] idle,run,attack;//temp array to hold the pictures
	Animation  idling,running,attacking;//creating variables for diff kind animation
	int maxCount,width,height;//used for dimensions of the enemy temp.
	public Enemy(float x, float y, Tag tag, Texture texture) {
		super((float)x, (float)y, tag, texture);
		health=50;
		maxCount =2;
		velx=2;
		width = 30;
		height = 60;
		setGravity(10f);
		falling=true;
		
		idle=texture.getEnemyIdle();
		//run=texture.getEnemyRun();
		//attack=texture.getEnemyAttack();
		idling=new Animation(4, idle);
		//running=new Animation(4,run);
		//attacking=new Animation(4,attack);
		
		
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
			 
			
		}
		//invoking runAnimation() method to shuffle between pictures
	try {
			idling.runAnimation();
			//running.runAnimation();
			//attacking.runAnimation();
		}catch(Exception e)
		{
			System.err.println("Enemy class line 79");
		}
	
	}
	@Override
	public void render(Graphics g) {
		//temp drawing idle. In future i want to creat an enemy that walks and automatically attacks player 
		idling.drawAnimation(g, (int)x,(int) y-50, width+30, height+30);
		//Graphics2D g2d =(Graphics2D) g;
		//g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y-30, width-10, height);
	}

}
