package Image_editors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * This Class creates the animation . it simply gets the buffererd immageds anf shuffles through them
 * based on a speed that is passed to it throught the constructor
 * @author zchem
 *
 */
public class Animation {
int speed,frames,index=0,count=0;

private BufferedImage[] images;
private BufferedImage currentImage;
public Animation (int speed , BufferedImage ... args) {
	this.speed=speed;
	images=new BufferedImage[args.length];//setting images to length of passed array
	for (int i =0 ;i<args.length;i++) {
		images[i]=args[i];
		
	}
	frames=args.length;
	
}
public void runAnimation() {
	index++;
	if (index>speed) {
		index=0;
		nextFrame();
	}
}//getting th image at count incremental 
private void nextFrame() {
	for (int i=0;i<frames;i++) {
		if(count==i)
		currentImage=images[i];
	} 
	count++;
	if(count>frames)
		count=0;//resetting 
}
public void drawAnimation (Graphics g, int x ,int y,int scaleX,int scaleY)
{
	g.drawImage(currentImage, x, y,scaleX,scaleY, null);
}}