package spira.snake;

import java.util.LinkedList;

public class Snake {

	private LinkedList<Segmant> snake;

	public Snake(int boxSize) {
		snake = new LinkedList<Segmant>();

		snake.add(new Segmant(45, 15, boxSize));
		snake.add(new Segmant(30, 15, boxSize));
		snake.add(new Segmant(15, 15, boxSize));
	}

	public LinkedList<Segmant> getSnake() {
		return snake;
	}

	public boolean contains(Segmant seg) {
		boolean contain = false;
		for (Segmant p : snake) {
			if (p.equals(seg)) {
				contain = true;
				break;
			}
		}
		return contain;
	}

	public void clear() {
		snake.clear();
	}

	public Segmant getHead() {
		return snake.peekFirst();
	}

	public void removeLast() {
		snake.removeLast();
	}

	public void addHead(Segmant seg) {
		snake.push(seg);
	}

	public int getSize() {
		return snake.size();
	}

}