package chesscreator.chess.piece;

public class ChessPiece{
    public final PieceType type;
    public final PieceColor color;

    public ChessPiece(PieceColor color, PieceType type){
        this.color = color;
        this.type = type;
    }
    public static String getDescriptionOf(String prefixIfExists, ChessPiece chessPiece) {
        if(chessPiece == null){
            return "no piece";
        }
        String properName = chessPiece.type.toString().toLowerCase();
        String properColor = chessPiece.color.toString().toLowerCase();

        return prefixIfExists + properColor + " " + properName;
    }

    public static char asLetter(ChessPiece chessPiece) {
        if(chessPiece == null){
            return ' ';
        }
        char baseLetter = chessPiece.type.pieceLetter;

        return chessPiece.color == PieceColor.WHITE ?
                Character.toUpperCase(baseLetter) :
                Character.toLowerCase(baseLetter);
    }
}
