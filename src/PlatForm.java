import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class PlatForm  extends GameObjects{

	public PlatForm(int x, int y, Tag tag) {
		super(x, y, tag);
	}

	@Override
	public void update(ArrayList<GameObjects> Objects) {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect((int)x, (int)y, 32, 32);
		g.setColor(Color.red);
		Graphics2D g2d =(Graphics2D) g;
		g2d.draw(getBounds());
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}

}
