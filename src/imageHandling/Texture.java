package imageHandling;

import java.awt.image.BufferedImage;

/**
 * This class creates an array of all the cropped images. This is done by
 * invoking grabImage() in @SpriteSheet class
 * 
 * @author zchem
 *
 */
public class Texture {
	SpriteSheet bs, ps,en;// NOte: bs=blocksheet ps=playersheet
	private BufferedImage tile = null, character = null,enemy=null;
	public BufferedImage[] blocks = new BufferedImage[5];// array for the block images
// arrays for specific movemnet of the player
	public BufferedImage[] playerRight = new BufferedImage[10];
	public BufferedImage[] playerLeft = new BufferedImage[10];
	public BufferedImage[] playerIdle = new BufferedImage[10];
	public BufferedImage[] playerAttaackRight = new BufferedImage[10];
	public BufferedImage[] playerThrowRight= new BufferedImage[10];
	// aaray for movement of enemy 
	public BufferedImage[] enemyIdle = new BufferedImage[8];
	public BufferedImage[] enemyRun = new BufferedImage[8];
	public BufferedImage[] enemyAttack = new BufferedImage[8];
	/**
	 * Constructor that will creat an instance of @BufferedImageLoader then will
	 * load the images and invoke grabImage() in @SpriteSheet to crop Then store the
	 * images in an array
	 */
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();

		try {
			character = loader.loadImage("/PlayerSprite.png");
			tile = loader.loadImage("/SpriteTile.png");
			enemy=loader.loadImage("/HeavyBandit.png");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		// creating an instance of SpriteSheet class and passing the images through the
		// constructor
		bs = new SpriteSheet(tile);
		ps = new SpriteSheet(character);
		en=new SpriteSheet(enemy);
		getBlockImages();
		getPlayerImages();
		getEnemyImages();
	}
/**
 * invoking method grabImage() in @SpriteSheet class to crop Enemy pictures
 */
	private void getEnemyImages() {
		for(int i=0;i<enemyAttack.length;i++) {
			enemyIdle[i] = en.grabImage(i+1, 1, 48, 48);
			enemyRun[i] = en.grabImage( i+1, 2, 48, 48);
			enemyAttack[i] = en.grabImage(i+1, 3, 48, 48);
	}
	}

	/**
	 * This method crops the images of the player and store them in the respective
	 * arrays
	 */
	private void getPlayerImages() {
		for (int i = 0; i < playerIdle.length; i++) {
			playerRight[i] = ps.grabImage(i + 1, 1, 32, 32);
			playerIdle[i] = ps.grabImage(i + 1, 3, 32, 32);
			playerLeft[i] = ps.grabImage(i + 1, 2, 32, 32);
			playerAttaackRight[i]=ps.grabImage(i+1, 4, 32, 32);
			playerThrowRight[i]=ps.grabImage(i+1, 6, 32, 32);

		}
	}

	/**
	 * This method crops the images of the platform blocks and store them in the
	 * array of images
	 */
	private void getBlockImages() {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = bs.grabImage(i + 1, 1, 32, 32);
		}
		blocks[4] = ps.grabImage(1, 2, 32, 32);
	}

//--------- Getter methods for the arrays of BufferedImage-----------
	public BufferedImage[] getBlocks() {
		return blocks;
	}

	public BufferedImage[] getPlayerRight() {
		return playerRight;
	}

	public BufferedImage[] getPlayerLeft() {
		return playerLeft;
	}

	public BufferedImage[] getPlayerIdle() {
		return playerIdle;
	}

	public BufferedImage[] getEnemyIdle() {
		return enemyIdle;
	}

	public BufferedImage[] getEnemyRun() {
		return enemyRun;
	}

	public BufferedImage[] getEnemyAttack() {
		return enemyAttack;
	}

	public BufferedImage[] getPlayerAttaackRight() {
		return playerAttaackRight;
	}
	public BufferedImage[] getPlayerThrowRight() {
		return playerThrowRight;
	}

	
}
