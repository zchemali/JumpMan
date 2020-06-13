package gameSetup;
import java.awt.Graphics;
import java.util.ArrayList;

import gameObjects.*;

/**
 * This class handles all of the @GameObjects such as players or obstacles
 * 
 * @author zchem
 * @since
 * @version 1.0
 * 
 */
public class Handler {
	// Creating an array of all GameObjects sub classes
	ArrayList<GameObjects> gameObjects = new ArrayList<GameObjects>();
	private GameObjects temp;// this variable is used in for loop

	/**
	 * This method will call update in all of the GameObjects created
	 */
	public void update() {

		for (int i = 0; i < gameObjects.size(); i++)

		{
			temp = gameObjects.get(i);
			temp.update(gameObjects);
		}
	}

	//
	/**
	 * This method will call render in all of the GameObjects created
	 * 
	 * @param g is passed from the render() method of @Game class
	 */
	public void render(Graphics g) {
		for (int i = 0; i < gameObjects.size(); i++) {
			temp = gameObjects.get(i);

			temp.render(g);
		}
	}

	/**
	 * This method is invoked Whenever we want to add a GameObject
	 * 
	 * @param tem is the GameObject that is passed
	 */
	public void addObject(GameObjects tem) {
		gameObjects.add(tem);
	}

	/**
	 * Whenver we want to remove an Object from the array
	 * 
	 * @param tem used as a reference for the GameObject
	 */
	public void removeObject(GameObjects tem) {
		gameObjects.remove(tem);
	}

	// This was temp. as we were creating/Testing the Game
	/**
	 * public void createLevel() { for (int xx=0; xx<Game.WIDTH*2 ;xx+=32) {
	 * addObject(new PlatForm(xx,Game.HEIGHT-64,Tag.Block1));
	 * 
	 * } for (int xx=200; xx<Game.WIDTH-200 ;xx+=32) { addObject(new
	 * PlatForm(xx,Game.HEIGHT-200,Tag.Block1));
	 * 
	 * } for (int yy=0; yy<Game.HEIGHT ;yy+=32) { addObject(new
	 * PlatForm(0,yy,Tag.Block1));
	 * 
	 * } }
	 */
	// Temp method to create enemy
	public void createEnemy() {
		for (int xx = 0; xx < Game.WIDTH * 2; xx += 300) {
			addObject(new Enemy(xx, 0, Tag.Enemy, null));
		}
	}
}
