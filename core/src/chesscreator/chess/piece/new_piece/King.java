package chesscreator.chess.piece.new_piece;


import chesscreator.chess.ChessBoard;
import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.movement.Axis;

public class King extends AxisPiece {
    public King(PieceColor color) {
        super(color, 'k');
    }

    @Override
    protected Axis[] getAxes() {
        return Axis.allAxes();
    }

    @Override
    protected int getLimit(ChessBoard chessBoard) {
        return 1;
    }
}
