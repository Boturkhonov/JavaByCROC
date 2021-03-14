package chesspiece;

import board.Position;

public class Queen extends Piece {

    @Override
    public boolean canMoveTo(Position position) {
        int thisX = this.getPosition().getX();
        int thisY = this.getPosition().getY();

        return thisX - position.getX() != 0 && thisY - position.getY() == 0 ||
                thisX - position.getX() == 0 && thisY - position.getY() != 0 ||
                Math.abs(thisX - position.getX()) == Math.abs(thisY - position.getY());
    }
}
