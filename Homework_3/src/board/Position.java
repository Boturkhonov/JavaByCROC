package board;

/**
 * Class that describes the coordinates of a piece in chess board
 */
public class Position {
    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) throws IllegalArgumentException {
        if (x < 0 || x > 7) {
            throw new IllegalArgumentException("Coordinate is out of the board");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws IllegalArgumentException {
        if (y < 0 || y > 7) {
            throw new IllegalArgumentException("Coordinate is out of the board");
        }
        this.y = y;
    }

    public Position(int x, int y) throws IllegalArgumentException {
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return (char) ('a' + x) + Integer.toString(y + 1);
    }
}
