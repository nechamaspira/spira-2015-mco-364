package spira.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	public boolean wink = false;
	public int height = 0;
	public int y = 220;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		height += 2;
		y -= 1;
		g.setColor(Color.YELLOW);
		g.fillOval(200, 100, 400, 400);
		g.setColor(Color.GREEN);

		// g.drawArc(x, y, width, height, startAngle, arcAngle);
		g.fillOval(450, 200, 50, 50);
		g.drawArc(300, 300, 200, 100, 0, -180);
		// g.fillOval(300, 200, 50, 50);
		if (wink == false) {
			g.fillOval(300, 200, 50, 50);
			height = 0;
			y = 220;
			wink = true;
		} else {
			if (height == 50) {
				g.drawArc(300, y, 50, height, 0, -180);
				g.drawArc(300, 200, 50, 50, 0, -180);
				g.fillOval(300, 200, 50, 50);
				wink = false;
			} else {
				g.drawArc(300, y, 50, height, 0, -180);
				g.drawArc(300, 200, 50, 50, 0, -180);
			}
		}

	}

}
