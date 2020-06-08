package Image_editors;
import java.awt.image.BufferedImage;
/**
 * 
 * @author zchem
 *this one crops an image from sprite sheet
 */
public class SpriteSheet {
private BufferedImage image;

public SpriteSheet(BufferedImage image) {
this.image=image;
}
//crops the img
public BufferedImage grabImage (int col,int row,int width,int height)
{
	BufferedImage img =image.getSubimage((col*width)-width, (row*height)-height, width, height);
return img;
}
}
