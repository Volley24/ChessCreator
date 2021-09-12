package chesscreator.chess.coordinates;


public final class CoordinateConverter {
    private CoordinateConverter() {
        throw new RuntimeException("Class cannot be instantiated");
    }

    public static Position toRaw(String displayCoordinate){
        char[] characterArray = displayCoordinate.toCharArray();

        if(characterArray.length != 2 || !Character.isLetter(characterArray[0]) || !Character.isDigit(characterArray[1]))
            throw new IllegalArgumentException("Invalid display coordinate provided.");

        char letter = Character.toUpperCase(characterArray[0]);
        int number = Integer.parseInt(String.valueOf(characterArray[1]));


        return new Position(getNumber(letter), flipCoordinate(number));
    }

    public static String toDisplay(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7)
            throw new IllegalArgumentException("Invalid raw coordinates provided; X and Y must be between 0 and 7.");

        return getLetter(x) + String.valueOf(flipCoordinate(y));
    }

    public static int flipCoordinate(int coordinate){
        return 8 - coordinate;
    }

    private static char getLetter(int coordinate){
        return Character.toChars('A' + coordinate)[0];
    }
    private static int getNumber(char letter){
        return letter - 'A';
    }
}
