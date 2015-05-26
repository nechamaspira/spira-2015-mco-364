package spira.paint;

import java.awt.Graphics;

public class LineListener extends BrushListener {

	public LineListener(Canvas canvas) {
		super(canvas);

	}

	@Override
	public void draw(Graphics g) {
		if (pointDragged != null) {
			g.drawLine(pointPressed.x, pointPressed.y, pointDragged.x,
					pointDragged.y);
		}
	}

}
