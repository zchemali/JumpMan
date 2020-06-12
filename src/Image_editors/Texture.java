package Image_editors;

import java.awt.image.BufferedImage;
/**
 * This class simply loads SpriteSheets looks at the sprite sheets, then invokes amethod in SpriteSheet class to
 * crop images out and store then in BufferedImage array
 * @author zchem
 *
 */
public class Texture {
SpriteSheet bs,ps;//bs=blocksheet ps=playersheet
private BufferedImage tile=null,character=null;
public BufferedImage [] blocks =new BufferedImage[5];
public BufferedImage [] playerRight =new BufferedImage[10];
public BufferedImage [] playerLeft =new BufferedImage[10];
public BufferedImage [] playerIdle =new BufferedImage[10];
public Texture() {
	BufferedImageLoader loader =new BufferedImageLoader();
	
	
	try {character=loader.loadImage("/PlayerSprite.png");
		tile=loader.loadImage("/SpriteTile.png");
	} catch (Exception e) {System.out.println(e);}
	bs=new SpriteSheet(tile);
	ps=new SpriteSheet(character);
	getBlockImages();
	getPlayerImages();
	
	
	
}


		

//you could have a 2D array
private void getPlayerImages() {
	for (int i =0 ;i<playerRight.length;i++)
	{
		playerRight [i]=ps.grabImage(i+1, 1, 32, 32);
		playerIdle [i]=ps.grabImage(i+1, 3, 32, 32);	
	
		playerLeft [i]=ps.grabImage(i+1, 2, 32, 32);
	
	
	}
}

private void getBlockImages() {
	for (int i =0 ;i<blocks.length;i++)
	{ blocks[i]=bs.grabImage(i+1, 1, 32, 32);
	//System.out.println(i);
}
	blocks[4]=ps.grabImage(1, 2, 32, 32);}

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

}
