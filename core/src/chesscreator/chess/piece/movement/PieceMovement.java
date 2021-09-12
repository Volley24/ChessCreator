package chesscreator.chess.piece.movement;


import chesscreator.chess.ChessBoard;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;

import java.util.ArrayList;
import java.util.Arrays;

public enum PieceMovement {
    PAWN(new PawnMovement()),

    KNIGHT(new Position(1, 2), new Position(-1, 2),
            new Position(1, -2), new Position(-1, -2),
            new Position(2, -1), new Position(2, 1),
            new Position(-2, 1), new Position(-2, -1)),

    BISHOP(Axis.DIAGONAL_LEFT, Axis.DIAGONAL_RIGHT),

    ROOK(Axis.VERTICAL, Axis.HORIZONTAL),

    QUEEN(Axis.allAxes()),

    KING(1, Axis.allAxes());

    private CustomPieceMovement customPieceMovement;

    private ArrayList<Position> offsets = new ArrayList<>();
    private ArrayList<Axis> axes = new ArrayList<>();

    private int searchLimit = -1;

    PieceMovement(CustomPieceMovement customPieceMovement){
        this.customPieceMovement = customPieceMovement;
    }

    PieceMovement(int searchLimit, Axis... axes){
        this.axes = new ArrayList<>(Arrays.asList(axes));
        this.searchLimit = searchLimit;
    }

    PieceMovement(Axis... axes){
        this.axes = new ArrayList<>(Arrays.asList(axes));
        this.searchLimit = 7;

    }

    PieceMovement(Position... offsets){
        this.offsets = new ArrayList<>(Arrays.asList(offsets));
    }

    public boolean isValidMove(ChessBoard chessBoard, ChessPiece chessPiece, Position targetLocation){
        ArrayList<Position> validPositions = getValidMoves(chessBoard, chessPiece);

        for(Position position : validPositions){
            if(position.equals(targetLocation)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Position> getValidMoves(ChessBoard chessBoard, ChessPiece chessPiece){

        int searchLimit = this.searchLimit;
        if(searchLimit == -1)
            searchLimit = chessBoard.getBoardSize() - 1;

        ArrayList<Position> positions = new ArrayList<>();

        if(customPieceMovement != null)
            positions.addAll(customPieceMovement.getAllPositions(chessBoard, chessPiece));

        for(Axis axis : axes){
            positions.addAll(axis.getValidMoves(chessBoard, chessPiece, searchLimit));
        }

        for(Position offset : offsets){
            int realX = offset.x + chessPiece.getPosition().x;
            int realY = offset.y + chessPiece.getPosition().y;

            if(chessBoard.isTileOutOfBounds(realX, realY)){
                continue;
            }

            ChessPiece chessPieceOnOffsetSquare = chessBoard.getPiece(realX, realY);
            if(chessPieceOnOffsetSquare != null){
                if(chessPiece.getColor() == chessPieceOnOffsetSquare.getColor()){
                    continue;
                }
            }
            positions.add(new Position(realX, realY));
        }

        return positions;
    }
}