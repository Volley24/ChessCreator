package chesscreator.chess.piece.new_piece;

import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.PieceColor;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Piece{
    public Knight(PieceColor color) {
        super(color, 'n');
    }

    @Override
    public ArrayList<Position> getValidMoves(ChessGame chessGame, Position currentPiecePosition) {
        return new ArrayList<>(Arrays.asList(new Position(1, 2), new Position(-1, 2),
                new Position(1, -2), new Position(-1, -2),
                new Position(2, -1), new Position(2, 1),
                new Position(-2, 1), new Position(-2, -1)));
    }
}
