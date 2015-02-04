package spira.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawOval(200, 100, 400, 400);
		g.setColor(Color.GREEN);

		g.fillOval(300,200,50,50);
		g.fillOval(450,200,50,50);
		g.drawArc(300, 300, 200, 100, 0, -180);
	
	}

}
