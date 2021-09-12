package chesscreator.chess.piece;


import chesscreator.chess.piece.movement.PieceMovement;

public enum PieceType {
    NONE('\0', null),
    PAWN('p', PieceMovement.PAWN),
    KNIGHT('n', PieceMovement.KNIGHT),
    BISHOP('b', PieceMovement.BISHOP),
    ROOK('r', PieceMovement.ROOK),
    QUEEN('q', PieceMovement.QUEEN),
    KING('k', PieceMovement.KING);

    public final PieceMovement pieceMovement;
    public final char pieceLetter;

    PieceType(char pieceLetter, PieceMovement pieceMovement) {
        this.pieceLetter = pieceLetter;
        this.pieceMovement = pieceMovement;
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
