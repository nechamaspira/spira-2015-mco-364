package spira.paint;

import java.awt.Graphics;

public class CircleListener extends BrushListener {

	public CircleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		if (pointDragged != null) {
			x = Math.min(pointPressed.x, pointDragged.x);
			y = Math.min(pointPressed.y, pointDragged.y);
			width = Math.abs(pointPressed.x - pointDragged.x);
			height = Math.abs(pointPressed.y - pointDragged.y);
			g.drawOval(x, y, width, height);
		}
	}
}
