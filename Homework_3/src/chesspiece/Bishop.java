package chesspiece;

import board.Position;

public class Bishop extends Piece {

    @Override
    public boolean canMoveTo(Position position) {
        int thisX = this.getPosition().getX();
        int thisY = this.getPosition().getY();

        return Math.abs(thisX - position.getX()) == Math.abs(thisY - position.getY());
    }
}
