package gameSetup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.net.ssl.SSLEngineResult.Status;

import gameObjects.*;


/**
 * This class controls all key pressed and based on the key pressed somthing
 * happens to the player
 * 
 * @author zchem
 *
 */
public class Actions implements KeyListener {
	private Handler handler;
	int count = 0;// used for limiting number of jumps

	/**
	 * This is a constructor that sets the handler variable in this class to @param
	 * 
	 * @param handler2 passed from the @Game Class
	 */
	public Actions(Handler handler2) {
		this.handler = handler2;

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
				if (i == KeyEvent.VK_D)
					temp.setVelx(5);
				if (i == KeyEvent.VK_A)
					temp.setVelx(-5);
				if (i == KeyEvent.VK_L)
					temp.setAttacking(true);// this is used for attacking
				// have another if for kunai throwing

				// setting the jimping of player
				if ((i == KeyEvent.VK_SPACE) && temp.isJumping()) { // you can only jump three times in a row
					if (count <= 3) {
						temp.setVely(-5);
						count += 1;
						if (count == 3) {
							{
								temp.setJumping(false);// if count=3 then player cant jump
								count -= 3;
							}
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
					temp.setAttacking(false);
				if (i == KeyEvent.VK_SPACE) {

					temp.setFalling(true);// Whenever space key is released then sets falling to true so gravity can be
											// activated
				}
			}
		}
	}

}
