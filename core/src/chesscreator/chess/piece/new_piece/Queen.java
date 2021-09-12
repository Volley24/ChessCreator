package chesscreator.chess.piece.new_piece;

import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.movement.Axis;

public class Queen extends AxisPiece{
    public Queen(PieceColor color) {
        super(color, 'q');
    }

    @Override
    protected Axis[] getAxes() {
        return Axis.allAxes();
    }
}
