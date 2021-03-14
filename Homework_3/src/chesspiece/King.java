package chesspiece;

import board.Position;

public class King extends Piece {

    @Override
    public boolean canMoveTo(Position position) {
        int thisX = this.getPosition().getX();
        int thisY = this.getPosition().getY();

        return Math.abs(thisX - position.getX()) < 2 && Math.abs(thisY - position.getY()) < 2;
    }
}
