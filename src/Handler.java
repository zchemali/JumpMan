import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {
	ArrayList <GameObjects> chars=new ArrayList();
	

	public void update() {
		for(int i=0;i<chars.size();i++)
		{
			chars.get(i).update();
		}}
		public void render(Graphics g) {
			for(int i=0;i<chars.size();i++)
			{
				chars.get(i).render(g);
			}
	}
	
	
	public void addObject (GameObjects tem)
	{
		chars.add(tem);
	}
	public void removeObject (GameObjects tem)
	{
		chars.remove(tem);
	}

}
