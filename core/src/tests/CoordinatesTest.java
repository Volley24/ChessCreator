package tests;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Coordinates;
import chesscreator.chess.piece.ChessPiece;
import org.junit.Assert;
import org.junit.Test;

public class CoordinatesTest {
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
          (0,1,2,3,4,5,6,7) */
    @Test
    public void testRawCoordsToDisplayCoords(){
        Coordinates coordinates = new Coordinates(0,0);
        Assert.assertEquals("A8", coordinates.toDisplay());

        coordinates = new Coordinates(6, 6);
        Assert.assertEquals("G2", coordinates.toDisplay());

        coordinates = new Coordinates(3, 5);
        Assert.assertEquals("D3", coordinates.toDisplay());

        coordinates = new Coordinates(0, 1);
        Assert.assertEquals("A7", coordinates.toDisplay());
    }
    @Test
    public void testPieces(){
        ChessBoard chessBoard = new ChessBoard();

        Coordinates coordinates = new Coordinates("E4");
        Assert.assertEquals("no piece", getDescription(coordinates, chessBoard));

        coordinates = new Coordinates("E2");
        Assert.assertEquals("white pawn", getDescription(coordinates, chessBoard));

        coordinates = new Coordinates("H1");
        Assert.assertEquals("white rook", getDescription(coordinates, chessBoard));

        coordinates = new Coordinates("E1");
        Assert.assertEquals("white king", getDescription(coordinates, chessBoard));

        coordinates = new Coordinates("E8");
        Assert.assertEquals("black king", getDescription(coordinates, chessBoard));
    }

    private String getDescription(Coordinates coordinates, ChessBoard chessBoard){
        return ChessPiece.getDescriptionOf("", chessBoard.getPieceByCoordinates(coordinates));
    }
}
