package spira.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private boolean wink = false;
	private int height = 0;
	private int y = (int)((getHeight()*.30)+((getHeight()/10)/2));

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w =getWidth();
		int h = getHeight();
		height += 2;
		y -= 1;
		g.setColor(Color.YELLOW);
		//g.fillOval(1, 1, (int)(w*.55), (int)(h*.75));
		g.fillOval(1, 1, w-1, h-1);
		// g.drawArc(x, y, width, height, startAngle, arcAngle);
				// g.fillOval(x, h, width, h);
		g.setColor(Color.GREEN);
		g.fillOval((int)(w*.65), (int)(h*.30), w/10, h/10);
		g.drawArc((int)(w*.30), (int)(h*.65), (int)(w*.45), (int)(h*.20), 0, -180);

		if (wink == false) {
			g.fillOval((int)(w*.25), (int)(h*.30), w/10, h/10);
			height = 0;
			y =(int)((h*.30)+((h/10)/2))-1;
			wink = true;
		} else {
			if (height >= h/10 || y<(int)(h*.30)) {
				
				g.drawArc((int)(w*.25),y, w/10, height, 0, -180);
				g.drawArc((int)(w*.25), (int)(h*.30), w/10, h/10, 0, -180);

				//g.drawArc(300, 200, 50, 50, 0, -180);
				//g.fillOval(300, 200, 50, 50);
				g.fillOval((int)(w*.25), (int)(h*.30), w/10, h/10);

				wink = false;
			} else {
				g.drawArc((int)(w*.25),y, w/10, height, 0, -180);
				g.drawArc((int)(w*.25), (int)(h*.30), w/10, h/10, 0, -180);
			}
		}

		/*super.paintComponent(g);
		int w =getWidth();
		int h = getHeight();
		height += 2;
		y -= 1;
		g.setColor(Color.YELLOW);
		g.fillOval(200, 100, 400, 400);
		g.setColor(Color.GREEN);

		// g.drawArc(x, y, width, height, startAngle, arcAngle);
		// g.fillOval(x, h, width, h);
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

	}*/

}}
