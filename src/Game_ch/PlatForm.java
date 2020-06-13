package Game_ch;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Image_editors.Texture;
/**
 * THis class is used to creat the platform blocks
 * @author zchem
 *
 */
public class PlatForm  extends GameObjects{

//Temp array for storing the images
BufferedImage [] temp;
/**
 * Constructor
 * @param x
 * @param y
 * @param tag
 * @param texture
 */
	public PlatForm(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		temp=texture.getBlocks();//grabbing the images from the texture variable
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		
	}

	@Override
	public void render(Graphics g) {
		//if/else statements to create different blocks/trees/ladders...etc
		if(tag==Tag.Block1)
		g.drawImage(temp[0],(int) x, (int)y, 32, 32,null);
		else if (tag==Tag.Block2)
		{
			g.drawImage(temp[3],(int) x, (int)y, 32, 32,null);
		}
		else if (tag==Tag.Tree)
		{
			g.drawImage(temp[4],(int) x-60, (int)y-150, 150, 200,null);
		}
			
		//g.setColor(Color.WHITE);
		//g.drawRect((int)x, (int)y, 32, 32);
		//g.setColor(Color.red);
		//Graphics2D g2d =(Graphics2D) g;
		//g2d.draw(getBounds());
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}

}
