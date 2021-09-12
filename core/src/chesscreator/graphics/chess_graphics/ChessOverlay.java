package chesscreator.graphics.chess_graphics;

import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import chesscreator.chess.piece.ChessPiece;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class ChessOverlay {
    private static final Color SELECTED_SQUARE = Color.valueOf("0bd400");
    private static final Color TARGETED_SQUARE = Color.valueOf("e6db19");

    private final OnSquareTargetedListener onSquareTargetedListener;

    private final ArrayList<Position> selectedSquares;
    private Position previousTargetedSquare, targetedSquare;

    private final Vector3 screenCoordinates;
    private final Rectangle bounds;

    private final int squareSize;

    public ChessOverlay(OnSquareTargetedListener onSquareTargetedListener, int boardSize){
        this.onSquareTargetedListener = onSquareTargetedListener;
        selectedSquares = new ArrayList<>();

        squareSize = 32;
        float x = (Gdx.graphics.getWidth()/2f) - (squareSize * boardSize / 2f);
        float y = (Gdx.graphics.getHeight()/2f) - (squareSize * boardSize / 2f);

        screenCoordinates = new Vector3();
        bounds = new Rectangle(x, y, squareSize * boardSize, squareSize * boardSize);

    }


    public void update(ChessGame chessGame, OrthographicCamera gameCamera, boolean isFlipped){
        screenCoordinates.x = Gdx.input.getX();
        screenCoordinates.y = Gdx.input.getY();
        Vector3 worldCoordinates = gameCamera.unproject(screenCoordinates);

        if(bounds.contains(worldCoordinates.x, worldCoordinates.y)){
            int renderX = (int) (worldCoordinates.x - bounds.x) / squareSize;
            int renderY = (int) (worldCoordinates.y - bounds.y) / squareSize;

            if(isFlipped){
                renderX = chessGame.flipCoordinate(renderX);
                renderY = chessGame.flipCoordinate(renderY);
            }


            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                targetSquare(chessGame, new Position(renderX, renderY));
                resetSelectedSquares();

            }else if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
                selectSquare(new Position(renderX, renderY));
                resetTargetedSquare();
            }
        }else{
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                resetSelectedSquares();
                resetTargetedSquare();
            }
        }

    }

    public void render(ChessGame chessGame, ShapeRenderer shapeRenderer, boolean isFlipped){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.setColor(SELECTED_SQUARE);
        for(Position selectedSquare : selectedSquares){
            drawCircle(chessGame, shapeRenderer, selectedSquare.x, selectedSquare.y, isFlipped);
        }

        if(targetedSquare != null) {
            shapeRenderer.setColor(TARGETED_SQUARE);
            drawCircle(chessGame, shapeRenderer, chessGame.flipCoordinate(targetedSquare.x), targetedSquare.y, isFlipped);
        }
        shapeRenderer.end();
    }


    private void drawCircle(ChessGame chessGame, ShapeRenderer shapeRenderer, int x, int y, boolean flipped){
        if(flipped){
            x = chessGame.flipCoordinate(x);
            y = chessGame.flipCoordinate(y);
        }
        shapeRenderer.circle((bounds.x + x * squareSize) + squareSize/2f, (bounds.y + y * squareSize) + squareSize/2f, squareSize/2f, 32);
    }



    public void reset(){
        resetSelectedSquares();
        resetTargetedSquare();
    }

    public void resetSelectedSquares(){
        selectedSquares.clear();
    }

    public void resetTargetedSquare(){
        previousTargetedSquare = null;
        targetedSquare = null;
    }


    public void selectSquare(Position squareToBeSelected){
        boolean isSquareAlreadySelected = false;
        int selectedSquareIndex = -1;

        for(Position selectedSquare : selectedSquares){
            if(squareToBeSelected.equals(selectedSquare)){
                isSquareAlreadySelected = true;
                selectedSquareIndex = selectedSquares.indexOf(selectedSquare);
            }
        }

        if(isSquareAlreadySelected){
            selectedSquares.remove(selectedSquareIndex);
        }else{
            selectedSquares.add(squareToBeSelected);
        }
    }

    public void targetSquare(ChessGame chessGame, Position squareToBeTargeted){
        squareToBeTargeted.x = chessGame.flipCoordinate(squareToBeTargeted.x);

        ChessPiece chessPiece = chessGame.getPiece(squareToBeTargeted);
        if(chessPiece != null && chessPiece.getColor() != chessGame.getColorToMoveNext()){
            return;
        }

        if(targetedSquare != null)
            previousTargetedSquare = new Position(targetedSquare.x, targetedSquare.y);

        if(chessPiece != null){
            targetedSquare = new Position(squareToBeTargeted);
        }else{
            targetedSquare = null;
        }

        if(onSquareTargetedListener != null)
            onSquareTargetedListener.onSquareTargeted(this, previousTargetedSquare, squareToBeTargeted);
    }

}
interface OnSquareTargetedListener{
    void onSquareTargeted(ChessOverlay chessOverlay, Position previousTargetedSquarePosition, Position targetedSquarePosition);
}