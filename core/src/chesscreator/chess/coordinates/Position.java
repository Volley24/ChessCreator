package chesscreator.chess.coordinates;

public class Position {
    public int x, y;

    public Position(){}

    public Position(Position position){
        this.x = position.x;
        this.y = position.y;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position plusOffset(Position position){
        return plusOffset(position.x, position.y);
    }

    public Position plusOffset(int x, int y){
        return new Position(this.x + x, this.y + y);
    }

    public boolean equals(Position position){
        return this.x == position.x && this.y == position.y;
    }

    @Override
    public String toString() {
        return "X: "+x + " Y: "+y;
    }
}
