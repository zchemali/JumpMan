import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
/**
 * 
 * @author zchem
 *@version 1.0
 *this is an abstract class which is used to create characters/obstacles
 */
public abstract class GameObjects {
	
	protected float x;
	protected float y;
	protected float velx;
	protected float vely;
	protected float gravity;
	protected boolean falling;
	
	protected Tag tag;
	// constructor
 public GameObjects(float x,float y,Tag tag)
 {
	 this.x=x;
	 this.y=y;
	 this.tag=tag;
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

public float getVelx() {
	return velx;
}

public void setVelx(float velx) {
	this.velx = velx;
}

public float getVely() {
	return vely;
}

public void setVely(float vely) {
	this.vely = vely;
}
// abstract methods are overridden 
	public abstract void update(ArrayList<GameObjects> Objects);
	public abstract void render (Graphics g);
	//this method is for collision detection
	public abstract Rectangle getBounds();

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
}
