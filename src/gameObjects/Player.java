package gameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gameSetup.Actions;
import gameSetup.Game;
import imageHandling.Animation;
import imageHandling.Texture;

/**
 * This is the player class
 * 
 * @author zchem
 *
 */
public class Player extends GameObjects  {
	Game game;
	private static final float MAX_VELY = 4;// used for setting the limit on Gravity
	private int width = 48, height = 92;// dimensions of the player
	BufferedImage[] temp, temp2, temp3,temp4,temp5,temp6,temp7,temp8,temp9,temp10,temp11;// Different arrays to store different types of movements
	private Animation walkingRight, walkingLeft, jumpingRight,jumpingLeft, idle,attackingRight,attackingLeft,throwingRight,throwingLeft,glidingRight,glidingLeft;// Creating Animation variables that will shuffle
																	// through the images

	public Player(float x, float y, Tag tag, Texture texture, Game game) {
		super(x, y, tag, texture);
		falling = true;// setting falling to true
		setJumping(false);// setting jumping to false initially
		setGravity(0.2f);// setting gravityj
		// grabbing the images from texture class and instantiating the animation
		temp = texture.getPlayerRight();
		walkingRight = new Animation(4, temp);
		temp2 = texture.getPlayerLeft();
		walkingLeft = new Animation(4, temp2);
		temp3 = texture.getPlayerIdle();
		idle = new Animation(4, temp3);
		temp4=texture.getPlayerAttaackRight();
		attackingRight=new Animation(1, temp4);
		temp5=texture.getPlayerThrowRight();
		throwingRight=new Animation(2, temp5);
		temp6=texture.getPlayerAttaackLeft();
		attackingLeft=new Animation(1,temp6);
		temp7=texture.getPlayerThrowLeft();
		throwingLeft=new Animation(2,temp7);
		temp8=texture.getGlideRight();
		glidingRight=new Animation(5, temp8);
		temp9=texture.getGlideLeft();
		glidingLeft=new Animation(1, temp9);
		temp10=texture.getJumpRight();
		jumpingRight=new Animation(5,temp10);
		temp11=texture.getJumpLeft();
		jumpingLeft=new Animation(5, temp11);
		velx = 0;
		health = 200;// setting initial health lvl
		pointer=1;//by default player facing rigth
		this.game=game;
	
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		//temp checks if falling in sky
		
		
		//try{System.err.println(kunaiCount.getCount());}catch (Exception e) {}
		//checks health temp 
if(health>=0 )
{	x += velx;
	y += vely;
	counterReset=false;}

if (gliding)
	setGravity(0.05f);
else
	setGravity(0.3f);
		if (falling) {
			vely += gravity;
			if (vely > MAX_VELY)
				vely = MAX_VELY;
		}

		// setting collision detection
		for (int i = 0; i < Objects.size(); i++) {
			GameObjects temp = Objects.get(i);
			// Collision with the platform blocks
			if (temp.tag == Tag.Block1 || temp.tag == Tag.Block2 || temp.tag == Tag.Tree) {
				// if player's legs intersect with the platform
				if (getBoundsBottom().intersects(temp.getBounds())) {
					vely = 0;
					setJumping(true);// now the player can jump
					falling = false;// cant fall anymore so gravity is disabled
					gliding=false;
					counterReset=true;
				}
				else if(!getBoundsBottom().intersects(temp.getBounds()))
					setFalling(true);//so that player is falling if its not intersecting
				

				// Players left side collision with the platform
				if (getBoundsLeft().intersects(temp.getBounds())) {
					velx = 0;
					x = getX() + 8;
				}
				// players right side colision with platform
				if (getBoundsRight().intersects(temp.getBounds())) {
					velx = 0;
					x = getX() - 8;

				}
				// players top side cloosion with plaftorm
				if (getBoundsTop().intersects(temp.getBounds())) {
					vely = +10;
					y = getY() + 4;

				}

			}
			// sets collision for moving platform blocks NOTE: might need to adjust for all
			// of players sides
			else if (temp.tag == Tag.Obstacle1 || temp.tag == Tag.Obstacle2) {
				if (getBounds().intersects(temp.getBounds())) {
					vely = 0;
					setX(temp.getX() + 20);
					setY(temp.getY() - 90);
					falling = false;
					setJumping(true);
					gliding=false;
				}

			}
			// sets collision with enemys NOTE might need to add if player is atcking from
			// right or left
			else if (temp.tag == Tag.Enemy)
				// if the player attacks the enemy then reduce the enemys health
				if (attacking) {
					if (getBoundsSwordRight().intersects(temp.getBounds())) {
						Objects.get(i).setHealth(Objects.get(i).getHealth()- 5);
						// removes the enemym if the enemys health dropped below 10
						if (Objects.get(i).getHealth() <= 2) {
							Objects.remove(i);
						}
					}

				}
				// if the player didn't attack the enemy the reduce Player's health
				else if (getBoundsSwordRight().intersects(temp.getBounds())) {
					health -= 1;
				}
		}
		//////// NOTE add health items that increase players health

		// invokes the runAnimation() method in Animation class
		try {
			walkingRight.runAnimation();
			idle.runAnimation();
			walkingLeft.runAnimation();
			attackingRight.runAnimation();
			throwingRight.runAnimation();
			attackingLeft.runAnimation();
			throwingLeft.runAnimation();
			glidingRight.runAnimation();
			glidingLeft.runAnimation();
			jumpingRight.runAnimation();
			jumpingLeft.runAnimation();
		} catch (Exception e) {
			System.err.println("Player>update> line 101");
		}

	}

	@Override
	public void render(Graphics g) {
		//for now this is how to reset game
		if(health<1) {
			
			g.setColor(Color.BLACK);
			g.setFont(new Font ("areal",Font.BOLD,50));
			g.drawString("GAME OVER",(int) x, (int)y);
			g.setColor(Color.WHITE);
			g.setFont(new Font ("areal",Font.BOLD,20));
			g.drawString("Press space to reset",(int) x+20, (int)y+60);}
			//draw dead animation here
		else {
			if(gliding && pointer==1)
				glidingRight.drawAnimation(g, (int)x, (int)y, width+20, height-30);
			else if (gliding && pointer==-1){
				glidingLeft.drawAnimation(g, (int)x, (int)y, width+20, height-30);
			}
			else if (jumpCheck && pointer==1) {
				jumpingRight.drawAnimation(g,(int) x,(int) y+10, width+10, height-25);}
			else if (jumpCheck && pointer==-1) {
				
				jumpingLeft.drawAnimation(g,(int) x,(int) y+10, width+10, height-25);}
			else
			{
				
		// if attacking and facing right
				 if(attacking && pointer==1)
			{ 
				attackingRight.drawAnimation(g,(int) x, (int)y+25, width+20, height-20);
			}
		 else if(attacking && pointer==-1)
			{
				attackingLeft.drawAnimation(g,(int) x, (int)y+25 ,width+20, height-20);
			}
		// if throwing and facing right
		 else if(throwing && pointer==1)
		 {
			 throwingRight.drawAnimation(g, (int) x-20,(int)y+28, width+20, height-25);
		 }
		 else if(throwing && pointer==-1)
		 {
			 throwingLeft.drawAnimation(g,(int) x-20,(int)y+28, width+20, height-25);
		 }
		 
		 else if (velx > 0  ) {
			walkingRight.drawAnimation(g, (int) x, (int) y + 35, width, height - 30);
		} else if (velx < 0 ) {
			walkingLeft.drawAnimation(g, (int) x, (int) y + 35,width, height - 30);
		} else if (velx==0) {
			idle.drawAnimation(g, (int) x, (int) y + 30, width - 10, height - 30);
		}}}
		
		// drawing the health bar NOTE add if statement to change color to red if health
		// is too low
		Graphics2D g2d;
		g2d = (Graphics2D) g;
		g.setColor(Color.GREEN);
		g.fillRect((int) x - 150, (int) y - 280, health / 10, 20);// inner box
		g.setColor(Color.BLACK);
		g2d.drawRect((int) x - 150, (int) y - 280, 200, 20);// bounary for health bar
		//g2d.drawString("Kunai"+, MAX_VELY, MAX_VELY);
		// Temp drawing boundaries to see the players boundaries
		// g2d.draw(getBoundsBottom());
		/*
		 * g2d.draw(getBoundsLeft()); g2d.draw(getBoundsRight());
		 * g2d.draw(getBoundsTop());
		 */
	}

	/**
	 * This is the entire boundary of player
	 */
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x - 5, (int) y, width, height);

	}

	// ---------bottom,top,left,and right boundaries of the player-----------//
	public Rectangle getBoundsBottom() {
		return new Rectangle((int) x, (int) y + 75, width - 10, height - 72);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x - 2, (int) y + 20, width - 42, height - 20);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + 35, (int) y + 20, width - 42, height - 20);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x, (int) y + 20, width - 10, height - 70);
	}

	// ---------Boundaries for sword---------
	public Rectangle getBoundsSwordRight() {
		return new Rectangle((int) x + 20, (int) y + 50, width - 20, height - 50);
	}

	public Rectangle getBoundsSwordLeft() {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	

}