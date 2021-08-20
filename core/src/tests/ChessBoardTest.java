package tests;

import chesscreator.chess.ChessBoard;
import chesscreator.graphics.chess_graphics.ConsoleChessRenderer;
import chesscreator.chess.coordinates.Coordinates;
import chesscreator.chess.piece.ChessPiece;
import org.junit.Test;

import java.util.Scanner;

public class ChessBoardTest {
    /*
    (0) 8 |r|n|b|q|k|b|n|r|
    (1) 7 |p|p|p|p|p|p|p|p|
    (2) 6 | | | | | | | | |
    (3) 5 | | | | | | | | |
    (4) 4 | | | | | | | | |
    (5) 3 | | | | | | | | |
    (6) 2 |P|P|P|P|P|P|P|P|
    (7) 1 |R|N|B|Q|K|B|N|R|
           A B C D E F G H
          (0,1,2,3,4,5,6,7)
     */
    @Test
    public void printTest(){
        ChessBoard chessBoard = new ChessBoard();

        ConsoleChessRenderer consoleChessRenderer = new ConsoleChessRenderer(chessBoard);

        consoleChessRenderer.printBoard(true);
        consoleChessRenderer.printBoard(false);
    }

    public static void main(String[] args){
        ChessBoard chessBoard = new ChessBoard();
        ConsoleChessRenderer consoleChessRenderer = new ConsoleChessRenderer(chessBoard);

        consoleChessRenderer.printBoard(true);


        Scanner scanner = new Scanner(System.in);
        String response;

        System.out.println("Enter a move: ");

        while(true){
            response = scanner.next();

            if(response.equalsIgnoreCase("exit")){
                break;
            }else if(Coordinates.isDisplayCoordinateValid(response)){

                ChessPiece chessPiece = chessBoard.getPieceByCoordinates(new Coordinates(response));
                String pieceDescription = ChessPiece.getDescriptionOf("a ", chessPiece);

                System.out.println("There is " + pieceDescription + " on "+response+".");
            }else{
                System.out.println("Invalid response!");
            }

            System.out.println("Enter another move, or 'exit': ");

        }
    }
}
