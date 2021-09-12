package chesscreator.chess.piece.new_piece;

import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import chesscreator.chess.piece.PieceColor;

import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(PieceColor color) {
        super(color, 'p');
    }

    @Override
    public ArrayList<Position> getValidMoves(ChessGame chessGame, Position currentPiecePosition) {
        ArrayList<Position> validMoves = new ArrayList<>();

        Position[] captureOffsets = {new Position(1, 0), new Position(0, 1)};


        Position oneSquarePosition = currentPiecePosition.plusOffset(0, 1);

        ChessPiece chessPiece = chessGame.getPiece(oneSquarePosition);
        if(chessPiece == null){
            validMoves.add(new Position(oneSquarePosition));
        }


        Position twoSquaresPosition = currentPiecePosition.plusOffset(0, 2);

        ChessPiece chessPiece2 = chessGame.getPiece(twoSquaresPosition);
        if(chessPiece2 == null && moves == 0){
            validMoves.add(twoSquaresPosition);
        }


        for(Position offset : captureOffsets){
            Position boardPosition = currentPiecePosition.plusOffset(offset);
            ChessPiece chessPieceThatCanGetCaptured = chessGame.getPiece(boardPosition);

            if(chessPieceThatCanGetCaptured != null){
                validMoves.add(boardPosition);
            }
        }
        return validMoves;
    }

}