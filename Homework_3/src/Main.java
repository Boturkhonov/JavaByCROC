import board.*;
import chesspiece.*;

/**
 * In this program you can create a chess board using ChessBoard class and create chess pieces using various classes from
 * chesspiece package. Then you can add, move and remove that pieces from the board using methods, implemented in ChessBoard.
 * All methods throw IllegalArgumentException
 * @author Kamron Boturkhonov
 */
public class Main {
    public static void main(String[] args) {

        // The chess board to play in
        ChessBoard chessBoard = new ChessBoard();

        // Creating some pieces to play with
        Piece king = new King();
        Piece knight = new Knight();
        Piece pawn = new Pawn();
        Piece queen = new Queen();

        // Try to add pieces to the board
        try {
            chessBoard.addPieceInPosition(king, new Position(3, 0)); // OK. The king is added to d1
            chessBoard.addPieceInPosition(knight, new Position(4, 3)); // OK. The knight is added to e4
            chessBoard.addPieceInPosition(queen, new Position(2, 6)); // OK. The queen is added to c7
            chessBoard.addPieceInPosition(pawn, new Position(-1, 5)); // Error! Coordinate is out of board
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        System.out.println("--------------------------------------------------");

        // Try to move pieces in the board
        try {
            chessBoard.movePieceTo(king, new Position(2, 1)); // OK. The king is moved from d1 to c2
            chessBoard.movePieceTo(knight, new Position(2, 6));
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        System.out.println("--------------------------------------------------");
        try {
            chessBoard.movePieceTo(queen, new Position(7, 1)); // OK. The queen is moved from c7 to h2
            chessBoard.addPieceInPosition(pawn, new Position(0, 0)); // OK. The pawn is added to a1
            chessBoard.movePieceTo(knight, new Position(2, 3)); // Error! Knight can't move like this
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        System.out.println("--------------------------------------------------");

        // Try to remove pieces
        try {
            chessBoard.removePiece(knight);
            chessBoard.removePiece(pawn);
            chessBoard.removePiece(new Rook()); // Error! Can't remove the piece. The board doesn't contain it
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }

    }
}

/*
  Output of the program:

    The king is added to d1
    The knight is added to e4
    The queen is added to c7
    Error! Coordinate is out of the board
    --------------------------------------------------
    The king is moved from d1 to c2
    Error! Can't move the piece. The position c7 is already used
    --------------------------------------------------
    The queen is moved from c7 to h2
    The pawn is added to a1
    Error! Knight can't move like this
    --------------------------------------------------
    The knight is removed from the board
    The pawn is removed from the board
    Error! Can't remove the piece. The board doesn't contain it

  **/