package chesscreator.chess.piece;

public enum PieceColor {
    NONE, WHITE, BLACK;

    public PieceColor next(){
        PieceColor[] pieceColors = values();
        return ordinal() == pieceColors.length - 1 ? PieceColor.WHITE: pieceColors[ordinal() + 1];
    }
}
