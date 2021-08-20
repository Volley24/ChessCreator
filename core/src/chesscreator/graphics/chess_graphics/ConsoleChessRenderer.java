package chesscreator.graphics.chess_graphics;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Coordinate;
import chesscreator.chess.piece.*;

public class ConsoleChessRenderer extends ChessRenderer{
    public ConsoleChessRenderer(ChessBoard chessBoard){
        super(chessBoard);
    }

    public void printBoard(boolean whitePerspective){
        StringBuilder stringBuilder = new StringBuilder((whitePerspective ? "White" : "Black")+"'s Perspective:\n");

        for(int y = 0; y < chessBoard.getBoardSize(); y++){
            stringBuilder.append(getNumberString(y, whitePerspective)).append(" |");

            for(int x = 0; x < chessBoard.getBoardSize(); x++){
                int realX = whitePerspective ? x : Coordinate.flipRawCoordinate(x);
                int realY = whitePerspective ? y : Coordinate.flipRawCoordinate(y);

                ChessPiece chessPiece = chessBoard.getPieceByRawLocation(realX, realY);

                stringBuilder.append(ChessPiece.asLetter(chessPiece)).append("|");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(getLetterString(whitePerspective));

        System.out.println(stringBuilder.toString());
    }

    private String getNumberString(int y, boolean whitePerspective){
        return ""+(whitePerspective ? Coordinate.flipRawCoordinate(y-1) : y + 1);
    }

    private String getLetterString(boolean whitePerspective){
        String rawLetters = "A B C D E F G H";
        return "   "+(whitePerspective ? rawLetters : invertString(rawLetters));
    }

    private String invertString(String string){
        char[] charArray = string.toCharArray();

        StringBuilder invertedString = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){
            invertedString.append(charArray[charArray.length - i - 1]);
        }

        return invertedString.toString();
    }

}
