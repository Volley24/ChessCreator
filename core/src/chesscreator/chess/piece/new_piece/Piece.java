package chesscreator.chess.piece.new_piece;

import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.PieceColor;

import java.util.ArrayList;

public abstract class Piece {
    protected PieceColor color;
    protected char letter;

    protected int moves;

    public Piece(PieceColor color, char letter){
        this.color = color;
        this.letter = letter;
    }


    public boolean sameColorAs(Piece piece){
        return color == piece.color;
    }

    public boolean sameTypeAs(Piece piece){
        return letter == piece.letter;
    }



    public abstract ArrayList<Position> getValidMoves(ChessGame chessGame, Position currentPiecePosition);

    public boolean isValidMove(ChessGame chessGame, Position currentPiecePosition, Position targetPiecePosition){
        for(Position validMove : getValidMoves(chessGame, currentPiecePosition)){
            if(validMove.equals(targetPiecePosition)){
                return true;
            }
        }
        return false;
    }
}
