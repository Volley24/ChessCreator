package chesscreator.chess.movement;

import chesscreator.chess.coordinates.Coordinates;

import java.util.ArrayList;

public class MovementSet {
    private ArrayList<MovementDirection> directions;
    private ArrayList<MovementOffset> offsets;

    private ArrayList<Coordinates> getAllMoves(){
        ArrayList<Coordinates> allMoves = new ArrayList<>();
        //TODO: Return all possible moves, doesn't have to be a legal move (i.e: going through check,
        // capturing own piece, ect...)

        return allMoves;
    }

    public ArrayList<Coordinates> getLegalMoves(){
        ArrayList<Coordinates> allMoves = getAllMoves();
        ArrayList<Coordinates> legalMoves = new ArrayList<>();

        for(Coordinates coordinates : allMoves){
            //...
        }

        return legalMoves;
    }
}
