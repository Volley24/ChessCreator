package chesscreator.chess;

import chesscreator.chess.coordinates.Coordinates;
import chesscreator.chess.piece.*;

public class ChessBoard {
    public static String STARTING_POSITION_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private static final PieceType[] PIECE_ORDER_BLACK =
            {PieceType.ROOK,
            PieceType.BISHOP,
            PieceType.BISHOP,
            PieceType.KING,
            PieceType.QUEEN,
            PieceType.BISHOP,
            PieceType.KNIGHT,
            PieceType.PAWN};

    private final ChessPiece[] tiles;
    private final int boardSize;

    public ChessBoard(){
        this.boardSize = 8;
        this.tiles = new ChessPiece[boardSize * boardSize];

        initPieces();
    }

    public ChessBoard(int boardSize){
        this.tiles = new ChessPiece[boardSize * boardSize];
        this.boardSize = boardSize;

        initPieces();
    }

    public void initPieces(){
        initPieces(STARTING_POSITION_FEN);
//        for(int x = 0; x < boardSize; x++){
//            setTile(new ChessPiece(PieceColor.BLACK, PIECE_ORDER_BLACK[x]), x, 0);
//            setTile(new ChessPiece(PieceColor.BLACK, PieceType.PAWN), x, 1);
//
//            setTile(new ChessPiece(PieceColor.WHITE, PieceType.PAWN), x, 6);
//            setTile(new ChessPiece(PieceColor.WHITE, PIECE_ORDER_BLACK[x]), x, 7);
//        }
    }

    public void initPieces(String fenString){
        String piecesLocation = fenString.split(" ")[0];

        int x = 0, y = 0;
        for(char fenChar : piecesLocation.toCharArray()){
            if (Character.isLetter(fenChar)){
                PieceColor color = Character.isUpperCase(fenChar) ? PieceColor.WHITE : PieceColor.BLACK;
                PieceType type = PieceType.getPieceTypeByLetter(fenChar);

                setTile(new ChessPiece(color, type), x, y);
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

    public ChessPiece getPieceByIndex(int i){
        return this.tiles[i];
    }
    public ChessPiece getPieceByRawLocation(int x, int y){
        return getPieceByIndex(x + y * boardSize);
    }
    public ChessPiece getPieceByCoordinates(Coordinates coordinates){
        return getPieceByIndex(coordinates.x.getValue() + coordinates.y.getValue() * boardSize);
    }
    public void setTile(ChessPiece chessPiece, int x, int y){
        this.tiles[x + y * boardSize] = chessPiece;
    }

    public int getBoardSize(){
        return boardSize;
    }
}
