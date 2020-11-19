package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import imageHandling.Texture;

/**
 * This is an abstract class which is used to create characters/obstacles
 * 
 * @author zchem
 * @version 1.0
 *
 */
public abstract class GameObjects {
	// Variables that are used by the subclasses
	protected float x;
	protected float y;
	protected float velx;
	protected float vely;
	protected int count;
	protected float gravity;
	protected boolean falling;
	protected boolean jumping;
	protected boolean attacking;
	protected boolean gliding;
	protected int health;
	protected int pointer;
	protected boolean throwing;
	protected boolean jumpCheck;
	protected boolean counterReset;
	public Tag tag;
	Texture texture;

	/**
	 * Constructor that sets the variables in the class
	 * 
	 * @param x
	 * @param y
	 * @param tag
	 * @param texture
	 */
	public GameObjects(float x, float y, Tag tag, Texture texture) {
		this.x = x;
		this.y = y;
		this.tag = tag;
		this.texture = texture;
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
	public abstract void update(ArrayList<GameObjects> Objects);// This method is used for Updating the x,y coordinated

	public abstract void render(Graphics g);// this method is used for graphics

	public abstract Rectangle getBounds();// this method is for collision detection

	// ------------------Getters and Setters-------------------//
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

	public int getCount() {
		return count;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public int getPointer() {
		return pointer;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}

	public boolean isThrowing() {
		return throwing;
	}

	public void setThrowing(boolean throwing) {
		this.throwing = throwing;
	}

	public boolean isGliding() {
		return gliding;
	}

	public void setGliding(boolean gliding) {
		this.gliding = gliding;
	}

	public boolean isJumpCheck() {
		return jumpCheck;
	}

	public void setJumpCheck(boolean jumpCheck) {
		this.jumpCheck = jumpCheck;
	}

	public boolean isCounterReset() {
		return counterReset;
	}

	public void setCounterReset(boolean counterReset) {
		this.counterReset = counterReset;
	}
	
}
