import Game_ch.*;
/*
 * This class simply translates the x,y coordinates of the player. You have to initialize it in the Game constructor
 * then invoke the update section in update of the game class
 * then pass the players class to the update 
 */
public class Camera {

	float x,y;
	public Camera (float x, float y)
	{
		this.x=x;
		this.y=y;}
		public void update (GameObjects player)
		{
			x=-player.getX()+Game.WIDTH/4;//we are saying to shift the coordinate system by 1/2 the Width of the game
			y=-player.getY()+Game.HEIGHT/2;//we are saying to shift the coordinate system by 1/2 the height of the game
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
