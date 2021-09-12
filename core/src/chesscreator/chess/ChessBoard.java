package chesscreator.chess;

import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.*;

public class ChessBoard {
    public final static String STARTING_POSITION_FEN =
            "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";


    private ChessPiece[] tiles;
    private final int boardSize;

    public ChessBoard(){
        this.boardSize = 8;

        setupBoard(STARTING_POSITION_FEN);
    }

    public ChessBoard(String pieceLocationField){
        this.boardSize = 8;

        setupBoard(pieceLocationField);
    }



    public void setupBoard(String fenString){
        String piecesFenField = fenString.split(" ")[0];

        tiles = new ChessPiece[boardSize * boardSize];
        int x = 0, y = 0;
        for(char fenChar : piecesFenField.toCharArray()){

            if (Character.isLetter(fenChar)){
                PieceType type = PieceType.getPieceTypeByLetter(fenChar);
                PieceColor color = Character.isUpperCase(fenChar) ? PieceColor.WHITE : PieceColor.BLACK;

                setTile(x, y, new ChessPiece(type, color));
                x++;

            }else if (Character.isDigit(fenChar)){
                x += Integer.parseInt(String.valueOf(fenChar));

            }else if(fenChar == '/'){
                x = 0;
                y++;

            }else{
                throw new IllegalArgumentException("Invalid character found in fen string: '"+fenChar+"'");
            }
        }
    }
    public int flipCoordinate(int coordinate){
        return boardSize - 1 - coordinate;
    }

    public boolean isTileOutOfBounds(int x, int y){
        return x < 0 || x > (boardSize-1) || y < 0 || y > (boardSize-1);
    }


    public ChessPiece getPiece(int index){
        return this.tiles[index];
    }
    public ChessPiece getPiece(int x, int y){
        return getPiece(x + y * boardSize);
    }

    public ChessPiece getPiece(Position position){
        return getPiece(position.x, position.y);
    }


    public void setTile(int x, int y, ChessPiece chessPiece){
        if(chessPiece != null) {
            chessPiece.setPosition(x, y);
        }

        this.tiles[x + y * boardSize] = chessPiece;
    }

    public int getBoardSize(){
        return boardSize;
    }
}
