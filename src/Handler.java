import java.awt.Graphics;
import java.util.ArrayList;

import Game_ch.*;

/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 * ths class handles all of the GameObjects such as players or obstacles
 */
public class Handler {
	// creatig an array of all GameObjects
	ArrayList <GameObjects> chars=new ArrayList();
	private GameObjects temp;

	// this method will call update in all of the GameObjects created
	public void update() {
		
		for(int i=0;i<chars.size();i++)
			
		{	temp=chars.get(i);
			temp.update(chars);
		}}
	// this method will call render in all of the GameObjects created
		public void render(Graphics g) {
			for(int i=0;i<chars.size();i++)
			{	temp=chars.get(i);
				
				temp.render(g);
			}
	}
	//if we want to add a GameObject
	
	public void addObject (GameObjects tem)
	{
		chars.add(tem);
	}
	public void removeObject (GameObjects tem)
	{
		chars.remove(tem);
	}
 /**public void createLevel() {
	 for (int xx=0; xx<Game.WIDTH*2 ;xx+=32) {
		addObject(new PlatForm(xx,Game.HEIGHT-64,Tag.Block1));
		
	 }
	 for (int xx=200; xx<Game.WIDTH-200 ;xx+=32) {
			addObject(new PlatForm(xx,Game.HEIGHT-200,Tag.Block1));
			
		 }
	 for (int yy=0; yy<Game.HEIGHT ;yy+=32) {
			addObject(new PlatForm(0,yy,Tag.Block1));
			
		 }
 }*/
}
