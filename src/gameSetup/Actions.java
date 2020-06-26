package gameSetup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.net.ssl.SSLEngineResult.Status;

import gameObjects.*;
import imageHandling.Texture;


/**
 * This class controls all key pressed and based on the key pressed somthing
 * happens to the player
 * 
 * @author zchem
 *
 */
public class Actions implements KeyListener {
	private Handler handler;
	private Texture texture;
	int count = 0;// used for limiting number of jumps
	int countKunai=100;//used to limit kunais thrown NOTE: add pick up elements to set this number 
	/** 
	 * This is a constructor that sets the handler variable in this class to @param
	 * 
	 * @param handler2 passed from the @Game Class
	 * @param texture 
	 */
	public Actions(Handler handler2, Texture texture) {
		this.handler = handler2;
		this.texture=texture;
		

	}

	

	/**
	 * Overriding @KeyListener method
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Overriding @KeyListener method This method is used for when a key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		if (i == KeyEvent.VK_ESCAPE)// if user hits the Esc key then close Window
			System.exit(1);
		// Looking for the Player class in the Array
		for (int j = 0; j < handler.gameObjects.size(); j++) {
			GameObjects temp = handler.gameObjects.get(j);
			if (temp.tag == Tag.Player) { // setting velocities
				if (i == KeyEvent.VK_D && !temp.isAttacking() &&!temp.isThrowing())
				{	temp.setVelx(5);
				 	temp.setPointer(1);
				}
				if (i == KeyEvent.VK_A && !temp.isAttacking()&& !temp.isThrowing())
					{
					temp.setVelx(-5);
					temp.setPointer(-1);
					}
				if (i == KeyEvent.VK_L&& !temp.isAttacking())
					temp.setAttacking(true);// this is used for attacking animation
				
				if(i==KeyEvent.VK_K && !temp.isThrowing() && countKunai>0)
					{temp.setThrowing(true);//sets throwing to true for animation
					if(temp.getPointer()==1)//checks if player facing right
					handler.addObject(new Kunai(temp.getX(), temp.getY(), Tag.KunaiRight, texture,countKunai));
					else//if player facing opp direction
						handler.addObject(new Kunai(temp.getX(), temp.getY(), Tag.KunaiLeft, texture,countKunai));
					countKunai--;
					}
				
				}

				// setting the jumping of player
				if ((i == KeyEvent.VK_SPACE) && temp.isJumping()&& !temp.isAttacking()) { // you can only jump three times in a row
					if (count <= 2) {
						temp.setJumpCheck(true);
						temp.setVely(-5);
						count += 1;
						if(temp.isCounterReset())
							count=0;
						if (count == 2 ) {
							{ 
								temp.setGliding(true);
								temp.setJumping(false);// if count=3 then player cant jump
								count =0;
							}
						}

					}

				}
			}
	}
	

	/**
	 * This method is used for when a key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int i = e.getKeyCode();
		// looking for Players class
		for (int j = 0; j < handler.gameObjects.size(); j++) {
			GameObjects temp = handler.gameObjects.get(j);
			if (temp.tag == Tag.Player) {
				if (i == KeyEvent.VK_D)
					temp.setVelx(0);
				if (i == KeyEvent.VK_A)
					temp.setVelx(0);
				if (i == KeyEvent.VK_W)
					temp.setVely(0);
				if (i == KeyEvent.VK_L)
					temp.setAttacking(false);//if key released then stop animation of attacking
				if(i==KeyEvent.VK_K )
				{
					temp.setThrowing(false);//if key released then stop animation of throwing
					
				}
				
				if (i == KeyEvent.VK_SPACE) {
					temp.setJumpCheck(false);
					temp.setFalling(true);// Whenever space key is released then sets falling to true so gravity can be
				}
			}
		}
	}
/**
 * 
 * @return count kunai left
 */
	public int getCountKunai() {
		return countKunai;
	}

	public void setCountKunai(int countKunai) {
		this.countKunai = countKunai;
	}

	
	
	}


