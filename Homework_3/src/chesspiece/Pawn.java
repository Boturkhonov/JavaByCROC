package chesspiece;

import board.Position;

public class Pawn extends Piece {

    @Override
    public boolean canMoveTo(Position position) {
        int thisX = this.getPosition().getX();
        int thisY = this.getPosition().getY();

        return thisX - position.getX() == 0 && position.getY() - thisY == 1;

    }
}

