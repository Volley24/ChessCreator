package tests;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.CoordinateConverter;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import chesscreator.chess.piece.PieceColor;
import chesscreator.chess.piece.PieceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ChessPieceMovementTest {
    public ChessBoard chessBoard;

    @Before
    public void init(){
        chessBoard = new ChessBoard();
    }

    @Test
    public void testPawnMoves(){
        String[] pawnMovesWhite = {
                "E5", "E6"
        };
        String[] pawnMovesBlack = {
                "E3", "E2",
        };
        testPieceMoves(PieceType.PAWN, PieceColor.WHITE, pawnMovesWhite);
        testPieceMoves(PieceType.PAWN, PieceColor.BLACK, pawnMovesBlack);
    }

    @Test
    public void testKnightMoves(){
        String[] knightMovesWhite = {
                "F6", "G5",
                "G3", "C3",
                "C5", "D6"
        };
        String[] knightMovesBlack = {
                "F6", "G5",
                "G3", "C3",
                "C5", "D6",
                "D2", "F2"
        };
        testPieceMoves(PieceType.KNIGHT, PieceColor.WHITE, knightMovesWhite);
        testPieceMoves(PieceType.KNIGHT, PieceColor.BLACK, knightMovesBlack);
    }

    @Test
    public void testBishopMoves(){
        String[] bishopMovesWhite = {
                "F3",
                "D3",
                "F5", "G6", "H7",
                "D5", "C6", "B7"
        };
        String[] bishopMovesBlack = {
                "F3", "G2",
                "D3", "C2",
                "F5", "G6",
                "D5", "C6",
        };
        testPieceMoves(PieceType.BISHOP, PieceColor.WHITE, bishopMovesWhite);
        testPieceMoves(PieceType.BISHOP, PieceColor.BLACK, bishopMovesBlack);
    }

    @Test
    public void testRookMoves(){
        String[] rookMovesWhite = {
                "E3",
                "E5", "E6", "E7",
                "F4", "G4", "H4",
                "D4", "C4", "B4", "A4"
        };
        String[] rookMovesBlack = {
                "E3", "E2",
                "E5", "E6",
                "F4", "G4", "H4",
                "D4", "C4", "B4", "A4"
        };
        testPieceMoves(PieceType.ROOK, PieceColor.WHITE, rookMovesWhite);
        testPieceMoves(PieceType.ROOK, PieceColor.BLACK, rookMovesBlack);
    }

    @Test
    public void testQueenMoves(){
        String[] queenMovesWhite = {
                "E3",
                "E5", "E6", "E7",
                "F4", "G4", "H4",
                "D4", "C4", "B4", "A4",
                "F3",
                "D3",
                "F5", "G6", "H7",
                "D5", "C6", "B7"
        };
        String[] queenMovesBlack = {
                "E3", "E2",
                "E5", "E6",
                "F4", "G4", "H4",
                "D4", "C4", "B4", "A4",
                "F3", "G2",
                "D3", "C2",
                "F5", "G6",
                "D5", "C6"
        };
        testPieceMoves(PieceType.QUEEN, PieceColor.WHITE, queenMovesWhite);
        testPieceMoves(PieceType.QUEEN, PieceColor.BLACK, queenMovesBlack);
    }

    @Test
    public void textKingMoves(){

        String[] kingMovesWhite = {
                "D3", "D4", "D5",
                "F3", "F4", "F5",
                "E3", "E5"
        };
        String[] kingMovesBlack = {
                "D3", "D4", "D5",
                "F3", "F4", "F5",
                "E3", "E5"
        };
        testPieceMoves(PieceType.KING, PieceColor.WHITE, kingMovesWhite);
        testPieceMoves(PieceType.KING, PieceColor.BLACK, kingMovesBlack);
    }


    public void testPieceMoves(PieceType pieceType, PieceColor pieceColor, String[] expectedMoves){
        ChessPiece chessPiece = new ChessPiece(pieceType, pieceColor);
        chessPiece.setPosition(CoordinateConverter.toRaw("E4"));

        ArrayList<String> actualMoves = new ArrayList<>();
        for(Position position : chessPiece.getValidMoves(chessBoard)){
            actualMoves.add(CoordinateConverter.toDisplay(position.x, position.y));
        }


        System.out.printf("Showing moves for the %s: ", chessPiece.getName());
        for(String actualMove : actualMoves){
            System.out.print(actualMove + (!actualMove.equals(actualMoves.get(actualMoves.size()-1)) ? ", " : ""));
        }
        System.out.println();

        assertListContainsAllMoves(actualMoves, expectedMoves);
    }

    private void assertListContainsAllMoves(ArrayList<String> actualMoves, String[] expectedMoves){
        if(actualMoves.size() > expectedMoves.length){
            Assert.fail("Found extra moves in the actual moves.");
        }
        for(int i = 0; i < expectedMoves.length; i++){
            if(i >= actualMoves.size()){
                Assert.fail("Could not find move '"+expectedMoves[i]+"' in moves.");
            }

            boolean found = false;
            for(String actualMove : actualMoves){
                if(expectedMoves[i].equals(actualMove)){
                    found = true;
                    break;
                }
            }
            if(!found){
                Assert.fail("Could not find move '"+expectedMoves[i]+"' in moves.");
            }
        }
    }
}
