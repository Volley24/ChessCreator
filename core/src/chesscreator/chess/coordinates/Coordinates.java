package chesscreator.chess.coordinates;

public class Coordinates {
    public Coordinate x, y;

    public Coordinates(int rawX, int rawY){
        this.x = new Coordinate(rawX);
        this.y = new Coordinate(rawY);
    }

    public Coordinates(String displayCoordinate){
        char letter = Character.toUpperCase(displayCoordinate.toCharArray()[0]);
        int number = Integer.parseInt(displayCoordinate.substring(1));

        this.x = new Coordinate(letter - 'A');
        this.y = new Coordinate(8 - number);
    }

    public static boolean isDisplayCoordinateValid(String displayCoordinate){
        char[] charArray = displayCoordinate.toCharArray();
        if(displayCoordinate.length() != 2 || !Character.isLetter(charArray[0]) || !Character.isDigit(charArray[1])){
            return false;
        }

        char letter = Character.toUpperCase(displayCoordinate.toCharArray()[0]);
        int number = Integer.parseInt(displayCoordinate.substring(1));

        return (letter >= 'A' && letter <= 'H') && (number >= 1 && number <= 8);
    }

    public String toDisplay(){
        return x.formatToDisplay(true) + y.formatToDisplay(false);
    }
}
