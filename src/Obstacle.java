import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 * 
 * this class extends the abstract class GameObjects i.e we can use all the methods in it
 */
public class Obstacle extends GameObjects {
	
	
public Obstacle(int x, int y, Tag tag) {
		super(x, y, tag);
		// TODO Auto-generated constructor stub
	}

// just to update the x coordinates of obstacles
	@Override
	void update() {
		x+=velx;
		
	}
// just to update graphic of Obstacle

@Override
void render(Graphics g) {
	// TODO Auto-generated method stub
	if(tag==Tag.Obstacle1) {
		g.setColor(Color.black);
		g.fillRect(x, y, 20, 60);}
}
	

}
