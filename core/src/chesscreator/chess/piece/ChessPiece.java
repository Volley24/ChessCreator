package chesscreator.chess.piece;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.CoordinateConverter;
import chesscreator.chess.coordinates.Position;
import chesscreator.graphics.Textures;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class ChessPiece{
    private final PieceType type;
    private final PieceColor color;

    private final Position position;

    public int moves = 0;

    public ChessPiece(PieceType type, PieceColor color){
        this.color = color;
        this.type = type;

        this.position = new Position();
    }

    public ArrayList<Position> getValidMoves(ChessBoard chessBoard){
        return type.pieceMovement.getValidMoves(chessBoard, this);
    }

    public boolean isValidMove(ChessBoard chessBoard, Position targetLocation){
        return type.pieceMovement.isValidMove(chessBoard, this, targetLocation);
    }


    public String getName(){
        return color.toString().toLowerCase() + " " + type.toString().toLowerCase();
    }

    public String getExtendedName(){
        return CoordinateConverter.toDisplay(position.x, position.y) + ": " + color.toString().toLowerCase() + " " + type.toString().toLowerCase();
    }


    public Texture getTexture(){
        return Textures.chessPieceTextures.get(type.ordinal() - 1 + (color == PieceColor.BLACK ? 6 : 0));
    }

    public PieceType getType(){
        return type;
    }

    public PieceColor getColor(){
        return color;
    }


    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        setPosition(position.x, position.y);
    }

    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }


    public void incrementMoves(){
        moves++;
    }

    public static char asLetter(ChessPiece chessPiece) {
        if(chessPiece == null){
            return ' ';
        }
        char baseLetter = chessPiece.type.pieceLetter;

        return chessPiece.color == PieceColor.WHITE ? Character.toUpperCase(baseLetter) : Character.toLowerCase(baseLetter);
    }
}
