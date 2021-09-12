package chesscreator.chess.piece.new_piece;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.PieceType;
import chesscreator.chess.piece.movement.Axis;

import java.util.ArrayList;

public abstract class AxisPiece extends Piece{
    /*A chess piece that moves along one or more axes */

    public AxisPiece(PieceColor color, char letter) {
        super(color, letter);
    }

    protected abstract Axis[] getAxes();
    protected int getLimit(ChessBoard chessBoard){
        return chessBoard.getBoardSize() - 1;
    }

    @Override
    public ArrayList<Position> getValidMoves(ChessGame chessGame, Position currentPiecePosition) {
        ArrayList<Position> validMoves = new ArrayList<>();

        int limit = getLimit(chessGame);
        for(Axis axis : getAxes()){
            validMoves.addAll(axis.getValidMoves(chessGame, currentPiecePosition, color, limit));

        }
        return validMoves;
    }
}
