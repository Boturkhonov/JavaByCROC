package board;

import chesspiece.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for chess board
 */
public class ChessBoard {

    // Chess pieces in the board
    private List<Piece> pieces = new ArrayList();

    // Board position states. The state is true if there is piece in that position, false otherwise
    private boolean[][] board = new boolean[8][8];

    public void addPieceInPosition(Piece piece, Position position) throws IllegalArgumentException {
        if (pieces.contains(piece)) {
            throw new IllegalArgumentException("Can't add " + piece.getClass().getSimpleName() + " to the board. " +
                    "It is already there");
        }
        if (!isPositionEmpty(position)) {
            throw new IllegalArgumentException("Can't add " + piece.getClass().getSimpleName() + " to the board. " +
                    "The position " + position + " is already used");
        }
        piece.setPosition(position);
        pieces.add(piece);
        setPositionState(position, true);
        System.out.println("The " + piece.getClass().getSimpleName().toLowerCase() + " is added to " + position);
    }

    public void removePiece(Piece piece) throws IllegalArgumentException {
        if (pieces.remove(piece)) {
            setPositionState(piece.getPosition(), false);
        } else {
            throw new IllegalArgumentException("Can't remove the piece. The board doesn't contain it");
        }
        System.out.println("The " + piece.getClass().getSimpleName().toLowerCase() + " is removed from the board");
    }

    public void movePieceTo(Piece piece, Position position) throws IllegalArgumentException {
        if (!pieces.contains(piece)) {
            throw new IllegalArgumentException("Can't move the piece. The board doesn't contain it");
        }
        if (!isPositionEmpty(position)) {
            throw new IllegalArgumentException("Can't move the piece. The position " + position + " is already used");
        }
        Position prev = piece.getPosition();
        piece.tryMoveTo(position);
        setPositionState(prev, false);
        setPositionState(position, true);
        System.out.println("The " + piece.getClass().getSimpleName().toLowerCase() + " is moved from " + prev + " to " + position);
    }

    private boolean isPositionEmpty(Position position) {
        return !board[position.getX()][position.getY()];
    }

    private void setPositionState(Position position, boolean state) {
        board[position.getX()][position.getY()] = state;
    }

}
