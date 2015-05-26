package spira.paint;

import java.awt.Graphics;

public class FillCircleListener extends BrushListener {

	public FillCircleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		if (pointDragged != null) {
			x = Math.min(pointPressed.x, pointDragged.x);
			y = Math.min(pointPressed.y, pointDragged.y);
			width = Math.abs(pointPressed.x - pointDragged.x);
			height = Math.abs(pointPressed.y - pointDragged.y);
			g.fillOval(x, y, width, height);
		}
	}
}
