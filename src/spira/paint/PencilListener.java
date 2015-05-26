package spira.paint;

import java.awt.Graphics;

public class PencilListener extends BrushListener {

	Canvas canvas;

	public PencilListener(Canvas canvas) {
		super(canvas);

		this.canvas = canvas;

	}

	@Override
	public void draw(Graphics g) {

		if (pointDragged != null) {
			graphics.drawLine(lastPoint.x, lastPoint.y, pointDragged.x,
					pointDragged.y);
		}
		lastPoint.x = pointDragged.x;
		lastPoint.y = pointDragged.y;
	}

}
