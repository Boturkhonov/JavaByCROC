package chesspiece;

import board.Position;

/**
 * General abstract class for all chess pieces
 */
public abstract class Piece {

    private Position position;

    public final void tryMoveTo(Position position) {
        if (canMoveTo(position)) {
            setPosition(position);
        } else {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " can't move like this");
        }
    }

    public abstract boolean canMoveTo (Position position);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
