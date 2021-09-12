package chesscreator.chess.piece.movement;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;

import java.util.ArrayList;

public interface CustomPieceMovement {
    ArrayList<Position> getAllPositions(ChessBoard chessBoard, ChessPiece chessPiece);
}
