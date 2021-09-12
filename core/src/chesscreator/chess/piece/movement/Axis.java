package chesscreator.chess.piece.movement;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import chesscreator.chess.piece.PieceColor;

import java.util.ArrayList;

public enum Axis {
    VERTICAL,
    HORIZONTAL,

    DIAGONAL_LEFT,
    DIAGONAL_RIGHT;

    public static Axis[] allAxes(){
        return values();
    }

    public boolean isHorizontal(){
        return this == HORIZONTAL || isDiagonal();
    }

    public boolean isVertical(){
        return this == VERTICAL || isDiagonal();
    }

    private boolean isDiagonal(){
        return this == DIAGONAL_LEFT || this == DIAGONAL_RIGHT;
    }

    public boolean shouldInvertXAxis(){
        return this == DIAGONAL_LEFT;
    }


    public ArrayList<Position> getValidMoves(ChessBoard chessBoard, ChessPiece chessPiece, int limit){
        return getValidMoves(chessBoard, chessPiece.getPosition(), chessPiece.getColor(), limit);
    }

    public ArrayList<Position> getValidMoves(ChessBoard chessBoard, Position position, PieceColor pieceColor, int limit){
        ArrayList<Position> positions = new ArrayList<>();

        boolean invertAxes = false;
        for(int times = 0; times < 2; times++){

            boolean shouldInvertXAxis = shouldInvertXAxis() ^ invertAxes;
            for(int i = 1; i < limit+1; i++){
                int xOffset = isHorizontal() ? (shouldInvertXAxis ? -i : i) : 0;
                int yOffset = isVertical() ? (invertAxes ? -i : i) : 0;

                int fullX = position.x + xOffset;
                int fullY = position.y + yOffset;

                if(chessBoard.isTileOutOfBounds(fullX, fullY))
                    break;

                ChessPiece chessPieceInSight = chessBoard.getPiece(fullX, fullY);

                if(chessPieceInSight != null){
                    if(pieceColor != chessPieceInSight.getColor()){
                        positions.add(new Position(fullX, fullY));
                    }
                    break;
                }

                positions.add(new Position(fullX, fullY));
            }
            invertAxes = true;
        }

        return positions;
    }


}
