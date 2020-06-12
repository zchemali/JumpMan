package Game_ch;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Image_editors.Animation;
import Image_editors.Texture;
/**
 * Thi is the player class , it is invoked by  handler.updae and handler .render
 * @author zchem
 *
 */
public class Player extends GameObjects{
	private static final float MAX_VELY = 4;
	private int width=48,height=92;
	BufferedImage []temp,temp2,temp3;
	BufferedImage [] left,right,jump,idl;
	// you can have here multiple animation example walking left right jumping etc.
	private Animation walkingRight,walkingLeft,jumpingUp,idle;
	public Player(float x, float y, Tag tag, Texture texture) {
		super(x, y, tag, texture);
		falling=true;
		count=0;
		setJumping(false);
		setGravity(0.2f);
		temp=texture.getPlayerRight();
		//for(int col=0 ; col<temp[0].length;col++)
		//	right[col]=temp[0][col];
		//instantiating the animations here by passing the sequece of images
		walkingRight =new Animation (4,temp);
		temp2=texture.getPlayerLeft();
		walkingLeft=new Animation (4,temp2);
		temp3=texture.getPlayerIdle();
		idle=new Animation (4,temp3);
		velx=0;
		health=200;
	}



	


	

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		x+=velx;
		y+=vely;
		
	// setting gravity
		if(falling || jumping)
		{vely+=gravity;
		if (vely>MAX_VELY)
			vely=MAX_VELY;}
		
		//setting collision detection
		for (int i=0; i<Objects.size();i++)
		{	GameObjects temp =Objects.get(i);
			//System.out.println(temp.x);
			if (temp.tag==Tag.Block1 || temp.tag==Tag.Block2 || temp.tag==Tag.Tree) {
				//System.out.println("yes");
				if(getBoundsBottom().intersects(temp.getBounds())) {
					vely=0;
					setJumping(true);
					falling=false;
					
					//System.out.println("intersection"+jumping);
					}
				else if(!getBoundsBottom().intersects(temp.getBounds()))
					{falling=true;
					
					//System.out.println("no intersection"+jumping);
					}
				
					if(getBoundsLeft().intersects(temp.getBounds()))
						{velx=0;
						x=getX()+8;
						
						}
					if(getBoundsRight().intersects(temp.getBounds()))
					{velx=0;
					x=getX()-8;
					
					}
					if(getBoundsTop().intersects(temp.getBounds()))
					{ vely=+10;
					y=getY()+4;
							
					}
					
				
				}
			//sets collision for moving objects s
			else if (temp.tag==Tag.Obstacle1 || temp.tag==Tag.Obstacle2 ) {
				if(getBounds().intersects(temp.getBounds()))
				{vely=0;
				setX(temp.getX()+20);
				setY(temp.getY()-90);
				falling=false;
				setJumping(true);
				//System.out.println("YESS");
				}
				
			}
			else if (temp.tag==Tag.Enemy )
				
			if(attacking) {
				if(getBoundsSwordRight().intersects(temp.getBounds()))
				{	Objects.get(i).setHealth(health-10);
				
				if(Objects.get(i).getHealth()<=10)					
				{Objects.remove(i);
					System.out.println("Attack");}}
		
		
		}
			else if(getBoundsSwordRight().intersects(temp.getBounds())) {
				System.out.println(Objects.get(i).getHealth());
				health-=1;}}
		try {
			//this will shuffle through images of the player
		walkingRight.runAnimation(); 
		idle.runAnimation();
		walkingLeft.runAnimation();}catch (Exception e) { System.err.println("Player>update> line 101");
		}
		
		}
		
	
		
		
	//animation

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.BLACK);
		//g.fillRect((int)x-150, (int)y-280, health, 20);
		
		g.setColor(Color.black);
		if (velx>0)
		{walkingRight.drawAnimation(g, (int)x, (int)y+30, width, height-30);}
		else if (velx<0)
		{walkingLeft.drawAnimation(g, (int)x, (int)y+30, width, height-30);}
		else 
			{idle.drawAnimation(g, (int)x, (int)y+30, width-10, height-30);}
		
		//else //draw idle animation
		//.drawImage(temp[0], (int)x , (int) y, width, height+9, null);
		//g.drawImage(temp[0], x, y, bgcolor, observer)
		Graphics2D g2d;
		
		g2d=(Graphics2D) g;
		
		g.setColor(Color.GREEN);
		
		g.fillRect((int)x-150, (int)y-280, health, 20);
	g.setColor(Color.BLACK);
		g2d.drawRect((int)x-150, (int)y-280, 200, 20);
		//g2d.draw(getBoundsBottom());
		/*g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsTop());*/
	}
//getbounds method to represet the boundary of the player
	@Override
	/**
	 * FDD
	 */
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x-5,(int)y ,width,height);

	}
	public Rectangle getBoundsBottom() {
		return new Rectangle((int)x,(int)y+75 ,width-10,height-72);
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x-2,(int)y+20,width-42,height-20);
}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x+35,(int)y+20,width-42,height-20);
}
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y+20,width-10,height-70);
}
public Rectangle getBoundsSwordRight() {
	return new Rectangle((int)x+20, (int)y+50, width-20, height-50);
}
public Rectangle getBoundsSwordLeft() {
	return new Rectangle((int)x,(int)y, width, height);
}

	public int getCount() {
		return count;
	}
}