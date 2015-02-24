package spira.snake;

public enum Direction {

	EAST(4), WEST(3), SOUTH(2), NORTH(1), NO_DIRECTION(0);
	private int value;

	private Direction(int value) {
		this.value = value;
	}

	public int getDirection() {
		return value;
	}
}
