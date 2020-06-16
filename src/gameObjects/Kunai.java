package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import imageHandling.Texture;

public class Kunai extends GameObjects {
int width,height;
	public Kunai(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		pointer=1;
		width=20;
		height=10;
		
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		//checks how to set velx of kunai based on facing of player
		if(tag==Tag.KunaiRight)
			x+=2;
		else if(tag==Tag.KunaiLeft)
			x-=2;
		for(int i=0;i<Objects.size();i++)
		{
			//Collision detection with enemy
			//if intersects with enemy then reduce healt
			//if enemy health<2 then remove enemy
			if (Objects.get(i).tag==Tag.Enemy) {
				if(getBounds().intersects(Objects.get(i).getBounds())){
				{Objects.get(i).setHealth(Objects.get(i).getHealth()-10);
				System.out.println(Objects.get(i).getHealth());
				
				}
				if(Objects.get(i).getHealth()<2)
					Objects.remove(i);	
			}
				}
		
		}
		
		
	}

	@Override
	public void render(Graphics g) {
	g.setColor(Color.red);
	//g.fillRect((int)x, (int)y+60, width, height);
		Graphics2D g2d =(Graphics2D) g;
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y+60,width,height);
	}

}
