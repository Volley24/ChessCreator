package chesscreator.graphics.chess_graphics;

import chesscreator.chess.ChessBoard;

public abstract class ChessRenderer {
    protected final ChessBoard chessBoard;

    public ChessRenderer(ChessBoard chessBoard){
        this.chessBoard = chessBoard;
    }
}
