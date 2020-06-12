import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Game_ch.*;
import javax.net.ssl.SSLEngineResult.Status;
/**
 * This class controls all key pressed
 * @author zchem
 *
 */
public class Actions implements KeyListener{
private Handler handler;
int count =0;
	public Actions(Handler handler2) {
		this.handler=handler2;
		
}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		int i=e.getKeyCode();
		if(i==KeyEvent.VK_ESCAPE)
			System.exit(1);
		for(int j=0;j<handler.gameObjects.size();j++)
		{
			GameObjects temp =handler.gameObjects.get(j);
			if(temp.tag==Tag.Player)
			{
				if(i==KeyEvent.VK_D) temp.setVelx(5);
				if(i==KeyEvent.VK_A) temp.setVelx(-5);
				if(i==KeyEvent.VK_L) temp.setAttacking(true);
				
					
					if((i==KeyEvent.VK_SPACE) && temp.isJumping())
					{
						if(count<=3) {
						temp.setVely(-5) ;
						count+=1;
						//System.out.println("first"+count);
						//temp.setJumping(false);
					if(count==3)
					{
						{temp.setJumping(false);
						count-=3;
						}
					}
					
				}
					
						
			}
					//you can add actions for keys to attack and throw kunai note create the new kunai object here and get the tem x values
					//Also you need like a facing flag if facing right or facing left 
		}}}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int i=e.getKeyCode();
		for(int j=0;j<handler.gameObjects.size();j++)
		{
			GameObjects temp =handler.gameObjects.get(j);
			if(temp.tag==Tag.Player)
			{
				if(i==KeyEvent.VK_D) temp.setVelx(0);
				if(i==KeyEvent.VK_A) temp.setVelx(0);
				if(i==KeyEvent.VK_W) temp.setVely(0);
				if(i==KeyEvent.VK_L) temp.setAttacking(false);
				if(i==KeyEvent.VK_SPACE) {
					
					temp.setFalling(true);
				//System.out.println("2"+temp.jumping);
				}
			}
		}
	}

}
