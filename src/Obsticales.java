import java.awt.Color;
import java.awt.Graphics;

public class Obsticales extends GameObjects {
	public Obsticales(int x, int y, Tag tag) {
		super(x, y, tag);
		velx=-2;
	}

	@Override
	void update() {
		x+=velx;
		
		
	}

	@Override
	void render(Graphics g) {
		if(tag==Tag.Obstical) {
		g.setColor(Color.black);
		g.fillRect(x, y, 20, 60);}
	}

}
