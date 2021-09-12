package chesscreator.chess.piece.new_piece;

import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.movement.Axis;

public class Bishop extends AxisPiece{
    public Bishop(PieceColor color) {
        super(color, 'b');
    }

    @Override
    protected Axis[] getAxes() {
        return new Axis[]{Axis.DIAGONAL_LEFT, Axis.DIAGONAL_RIGHT};
    }
}
