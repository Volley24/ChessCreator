package chesscreator.chess.piece;



public enum PieceType {
    PAWN('p'),
    KNIGHT('n'),
    BISHOP('b'),
    ROOK('r'),
    QUEEN('q'),
    KING('k');

    public final char pieceLetter;
    PieceType(char pieceLetter) {
        this.pieceLetter = pieceLetter;
    }

    public static PieceType getPieceTypeByLetter(char letter){
        for(PieceType pieceType : PieceType.values()){
            if(Character.toLowerCase(letter) == pieceType.pieceLetter){
                return pieceType;
            }
        }
        throw new IllegalArgumentException("Letter '"+letter+"' does not correspond to any chess piece type.");
    }
}
