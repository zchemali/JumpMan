import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.net.ssl.SSLEngineResult.Status;

public class Actions implements KeyListener{
private Handler handler;

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
		for(int j=0;j<handler.chars.size();j++)
		{
			GameObjects temp =handler.chars.get(j);
			if(temp.tag==Tag.Player)
			{
				if(i==KeyEvent.VK_D) temp.setVelx(2);
				if(i==KeyEvent.VK_A) temp.setVelx(-2);
				if(i==KeyEvent.VK_W) temp.setVely(-2);
				if(i==KeyEvent.VK_S) temp.setVely(2);
				if(i==KeyEvent.VK_SPACE);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int i=e.getKeyCode();
		for(int j=0;j<handler.chars.size();j++)
		{
			GameObjects temp =handler.chars.get(j);
			if(temp.tag==Tag.Player)
			{
				if(i==KeyEvent.VK_D) temp.setVelx(0);
				if(i==KeyEvent.VK_A) temp.setVelx(0);
				if(i==KeyEvent.VK_W) temp.setVely(0);
				if(i==KeyEvent.VK_S) temp.setVely(0);
				if(i==KeyEvent.VK_SPACE);
			}
		}
	}

}
