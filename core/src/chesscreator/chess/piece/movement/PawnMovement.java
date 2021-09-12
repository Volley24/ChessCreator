package chesscreator.chess.piece.movement;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import chesscreator.chess.piece.PieceColor;

import java.util.ArrayList;

public class PawnMovement implements CustomPieceMovement{
    @Override
    public ArrayList<Position> getAllPositions(ChessBoard chessBoard, ChessPiece chessPiece) {
        ArrayList<Position> positions = new ArrayList<>();


        if(chessPiece.moves == 0){
            Position position = new Position(chessPiece.getPosition().x, chessPiece.getPosition().y + invertIfWhite(2, chessPiece.getColor()));
            if(canMoveToTargetLocation(chessBoard, chessPiece, position))
                positions.add(position);
        }

        Position position = new Position(chessPiece.getPosition().x, chessPiece.getPosition().y + invertIfWhite(1, chessPiece.getColor()));
        if(canMoveToTargetLocation(chessBoard, chessPiece, position))
            positions.add(position);

        return positions;
    }
    private boolean canMoveToTargetLocation(ChessBoard chessBoard, ChessPiece chessPiece, Position targetPosition){
        ChessPiece chessPieceOnOffsetSquare = chessBoard.getPiece(targetPosition.x, targetPosition.y);
        if(chessPieceOnOffsetSquare != null){
            return chessPiece.getColor() != chessPieceOnOffsetSquare.getColor();
        }
        return true;
    }
    private int invertIfWhite(int integer, PieceColor pieceColor){
        if(pieceColor == PieceColor.WHITE){
            return -integer;
        }
        return integer;
    }
}
