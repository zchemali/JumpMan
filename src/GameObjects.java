import java.awt.Graphics;
/**
 * 
 * @author zchem
 *@version 1.0
 *this is an abstract class which is used to create characters/obstacles
 */
public abstract class GameObjects {
	
	protected int x;
	protected int y;
	protected int velx;
	private int vely;
	protected Tag tag;
	// constructor
 public GameObjects(int x,int y,Tag tag)
 {
	 this.x=x;
	 this.y=y;
	 this.tag=tag;
 }
	
	public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getVelx() {
	return velx;
}

public void setVelx(int velx) {
	this.velx = velx;
}

public int getVely() {
	return vely;
}

public void setVely(int vely) {
	this.vely = vely;
}
// abstract methods are overridden 
	abstract void update();
	abstract void render (Graphics g);
}
