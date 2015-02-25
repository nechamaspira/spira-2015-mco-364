package spira.snake;

public class Segmant {

	private int x;
	private int y;
	private int d;

	public Segmant(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.d = r;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public boolean equals(Segmant seg) {
		if (x == seg.getX() && y == seg.getY()) {
			return true;
		} else {
			return false;
		}
	}
}
