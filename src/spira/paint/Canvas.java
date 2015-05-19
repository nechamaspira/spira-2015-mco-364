package spira.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private Color pencilColor;
	private BufferedImage image;
	private String option;
	private Point pointPressed;
	private Point pointDragged;
	private int width;
	private int height;
	private int size;

	public Canvas(int width, int height) {

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		graphics.setStroke(new BasicStroke(size));
		
		pencilColor = Color.black;
		option = "pencil";
		size = 1;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	public void clear() {
		//image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		repaint();
	}

	public BufferedImage getImage() {
		return image;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setStroke(new BasicStroke(size));

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		g.setColor(pencilColor);
		//listener.draw(g);
		if (pointPressed != null && pointDragged != null) {
			int x = Math.min(pointPressed.x, pointDragged.x);
			int y = Math.min(pointPressed.y, pointDragged.y);
			switch (option) {
			case "Rectangle":
				g.drawRect(x, y, Math.abs(pointPressed.x - pointDragged.x),
						Math.abs(pointPressed.y - pointDragged.y));
				break;
			case "Circle":
				g.drawOval(x, y, Math.abs(pointPressed.x - pointDragged.x),
						Math.abs(pointPressed.y - pointDragged.y));
				break;
			case "Rounded Rectangle":
				g.drawRoundRect(x, y,
						Math.abs(pointPressed.x - pointDragged.x),
						Math.abs(pointPressed.y - pointDragged.y), 50, 25);
				break;
			}
		}

	}

	public Point getPointPressed() {
		return pointPressed;
	}

	public void setPointPressed(Point pointPressed) {
		this.pointPressed = pointPressed;
	}

	public Point getPointDragged() {
		return pointDragged;
	}

	public void setPointDragged(Point pointDragged) {
		this.pointDragged = pointDragged;
	}

	public Color getPencilColor() {
		return pencilColor;
	}

	public void setPencilColor(Color pencilColor) {
		this.pencilColor = pencilColor;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void setSize(int size) {
		this.size = size;
				
	}
	public int getTheSize() {
		return this.size;
		
	}
}
