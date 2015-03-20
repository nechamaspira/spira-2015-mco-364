package spira.snake;

import java.awt.Color;
import java.awt.Graphics;

public class World {

	private final int boxSize = 15;
	private final int gridWidth = 40;
	private final int gridHeight = 40;

	private Snake snake;
	private Food fruit;
	private Direction direction;

	private boolean gameOver;
	private boolean wonGame;

	public World() {
		direction = Direction.NO_DIRECTION;
		snake = new Snake(boxSize);
		fruit = new Food(gridWidth, gridHeight, boxSize, snake.getSnake());
		gameOver = false;
		wonGame = false;
	}

	public void createSnake() {
		snake.clear();
		snake = new Snake(boxSize);
		direction = Direction.NO_DIRECTION;
	}

	public void createFood() {
		fruit = new Food(gridWidth, gridHeight, boxSize, snake.getSnake());
	}

	public void draw(Graphics g) {

		if (gameOver) {
			g.drawString("Game Over!", 50, 50);
			g.drawString("Press enter to start over", 50, 70);
			g.drawString("Otherwise feel free to exit", 50, 90);
		} else if (wonGame) {
			g.drawString("You Won the game!!", 50, 50);
			g.drawString("Press enter to start over", 50, 70);

		} else {
			g.setColor(Color.YELLOW);
			g.fillRect(boxSize, boxSize, gridWidth * boxSize, gridHeight
					* boxSize);

			g.setColor(Color.BLUE);
			for (Segmant p : snake.getSnake()) {
				g.fillOval(p.getX(), p.getY(), p.getD(), p.getD());
			}
			g.setColor(Color.RED);

			g.fillOval(fruit.getFruit().getX(), fruit.getFruit().getY(),
					boxSize, boxSize);
		}

	}

	public void move() {
		/*
		 * if (direction == Direction.NO_DIRECTION) { return; }
		 */
		Segmant head = snake.getHead();
		Segmant newPoint = head;
		switch (direction) {
		case NO_DIRECTION:
			return;
		case NORTH:
			newPoint = new Segmant(head.getX(), head.getY() - boxSize, boxSize);
			break;
		case SOUTH:
			newPoint = new Segmant(head.getX(), head.getY() + boxSize, boxSize);
			break;
		case WEST:
			newPoint = new Segmant(head.getX() - boxSize, head.getY(), boxSize);
			break;
		case EAST:
			newPoint = new Segmant(head.getX() + boxSize, head.getY(), boxSize);
			break;

		}
		snake.removeLast();
		if (newPoint.equals(fruit.getFruit())) {
			Segmant addPoint = new Segmant(newPoint.getX(), newPoint.getY(),
					newPoint.getD());// newPoint;
			snake.addHead(addPoint);
			createFood();

		} else if (newPoint.getX() < boxSize
				|| newPoint.getX() > gridWidth * boxSize) {
			gameOver = true;
			createSnake();
			return;
		} else if (newPoint.getY() < boxSize
				|| newPoint.getY() > gridHeight * boxSize) {
			gameOver = true;
			createSnake();
			return;

		} else if (snake.contains(newPoint)) {
			gameOver = true;
			createSnake();
			return;
		} else if (snake.getSize() == gridHeight * gridWidth) {
			wonGame = true;
			return;
		}

		snake.addHead(newPoint);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean boo) {
		gameOver = boo;
	}

	public boolean isWonGame() {
		return wonGame;
	}

	public void setWonGame(boolean b) {
		wonGame = b;
	}

}
