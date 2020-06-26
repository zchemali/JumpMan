package gameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import imageHandling.Texture;

public class Kunai extends GameObjects {
int width,height,count,tempx,tempy;
BufferedImage[] image;
	public Kunai(float x, float y, Tag tag, Texture texture, int countKunai) {
		super(x, y, tag, texture);
		pointer=1;
		width=20;
		height=10;
		//grabbing the kunai images from texture class
		image=texture.getKunai();
		this.count=countKunai;
		
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
				
				}
				if(Objects.get(i).getHealth()<2)
					Objects.remove(i);	
			}
				}
		
		if(Objects.get(i).tag==Tag.Player)
		{
			tempx=(int) Objects.get(i).getX();
			tempy=(int) Objects.get(i).getY();
			
		}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		
	if(tag==Tag.KunaiLeft)//checking direction of kunai thrown
		g.drawImage(image[1], (int)x, (int)y+60, width, height,null);
	else if(tag==Tag.KunaiRight)
		g.drawImage(image[0], (int)x, (int)y+60, width, height,null);
		g.setColor(Color.red);
	//g.fillRect((int)x, (int)y+60, width, height);
		//trying to display kunais left
		/*Graphics2D g2d =(Graphics2D) g;
		g.setFont(new Font ("",1,40));
		
		g.setColor(Color.BLACK);
		g2d.drawString(""+count, tempx-150, tempy-235);*/
	}
	

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y+60,width,height);
	}

}
