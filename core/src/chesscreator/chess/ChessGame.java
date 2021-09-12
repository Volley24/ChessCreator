package chesscreator.chess;

import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import chesscreator.chess.piece.PieceColor;


public class ChessGame extends ChessBoard{
    private PieceColor colorToMoveNext;

    public ChessGame(){
        super();
        this.colorToMoveNext = PieceColor.WHITE;
    }

    public void setupGame(){
        setupGame(ChessBoard.STARTING_POSITION_FEN);
    }

    public void setupGame(String fenString){
        String[] fenFields = fenString.split(" ");
        setupBoard(fenFields[0]);

        colorToMoveNext = fenFields[1].equals("w") ? PieceColor.WHITE : PieceColor.BLACK;
    }

    public PieceColor getColorToMoveNext(){
        return colorToMoveNext;
    }


    public boolean movePieceToTile(ChessPiece chessPiece, Position targetLocation){
        if(chessPiece.getColor() != colorToMoveNext){
            return false;
        }

        if(chessPiece.isValidMove(this, targetLocation)){
            int previousPieceX = chessPiece.getPosition().x;
            int previousPieceY = chessPiece.getPosition().y;

            setTile(targetLocation.x, targetLocation.y, chessPiece);
            setTile(previousPieceX, previousPieceY, null);
            chessPiece.incrementMoves();

            System.out.println("Valid Move");

            colorToMoveNext = colorToMoveNext.next();
            return true;
        }
        System.out.println("Illegal Move!");
        return false;
    }

    public boolean onTileTargeted(Position previousTargetedPosition, Position currentTargetedPosition){
        ChessPiece chessPiece = getPiece(previousTargetedPosition);

        if(chessPiece == null){
            return false;
        }

       return movePieceToTile(chessPiece, currentTargetedPosition);
    }
}
