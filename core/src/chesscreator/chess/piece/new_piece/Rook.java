package chesscreator.chess.piece.new_piece;

import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.movement.Axis;


public class Rook extends AxisPiece {
    public Rook(PieceColor color) {
        super(color, 'r');
    }

    @Override
    public Axis[] getAxes() {
        return new Axis[]{Axis.VERTICAL, Axis.HORIZONTAL};
    }
}
