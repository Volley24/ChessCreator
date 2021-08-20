package chesscreator.chess.coordinates;

public class Coordinate {
    private int rawCoordinate;

    public Coordinate(int rawCoordinate){
        this.rawCoordinate = rawCoordinate;
    }


    public static int flipRawCoordinate(int rawCoordinate){
        return 7 - rawCoordinate;
    }

    public int getValue(){
        return rawCoordinate;
    }
    public void setValue(int rawCoordinate){
        this.rawCoordinate = rawCoordinate;
    }

    public String formatToDisplay(boolean isLetter){
        int baseDisplayCoordinate = rawCoordinate + 1;
        return isLetter ? String.valueOf(getChar(baseDisplayCoordinate)) : String.valueOf(8 - rawCoordinate);
    }

    private char getChar(int displayCoordinate){
        return Character.toChars('A' + displayCoordinate - 1)[0];
    }
}
