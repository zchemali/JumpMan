package gameSetup;
import gameObjects.*;

/**
 * This class simply translates the x,y coordinates of the player. You have to
 * initialize it in the Game constructor then invoke the update section in
 * update of the game class then pass the players class to the update
 * 
 * @author zchem
 *
 */
public class Camera {
//Creating the x,y variables 
	float x, y;

	/**
	 * Constructor class that is invoked in the @Game class constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method is invoke in update() method of @Game class It sets the x,y
	 * coordinates of the Camera
	 * 
	 * @param player passed from the update() method of @Game class
	 */
	public void update(GameObjects player) {
		x = -player.getX() + Game.WIDTH / 4;// we are saying to shift the coordinate system by 1/2 the Width of the game
		y = -player.getY() + Game.HEIGHT / 2;// we are saying to shift the coordinate system by 1/2 the height of the
												// game
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
