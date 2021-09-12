package chesscreator.graphics.chess_graphics;

import chesscreator.chess.ChessGame;
import chesscreator.chess.coordinates.Position;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;



public class CheckeredBoard {
    private static final Color LIGHT_SQUARE = Color.valueOf("d6b596");
    private static final Color DARK_SQUARE = Color.valueOf("c4874f");

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();

    private final ChessGame chessGame;
    private final ChessOverlay chessOverlay;

    private final Rectangle bounds;

    public CheckeredBoard(ChessGame chessGame, float x, float y, float tileSize){
        this.chessGame = chessGame;
        this.bounds = new Rectangle(x, y, tileSize * chessGame.getBoardSize(), tileSize * chessGame.getBoardSize());

        chessOverlay = new ChessOverlay((chessOverlay, previousTargetedSquarePosition, targetedSquarePosition) -> {
            if(previousTargetedSquarePosition == null || targetedSquarePosition == null){
                return;
            }

            if(previousTargetedSquarePosition.equals(targetedSquarePosition)){
                return;
            }

            chessGame.onTileTargeted(previousTargetedSquarePosition, new Position(targetedSquarePosition));

            chessOverlay.resetSelectedSquares();
            chessOverlay.resetTargetedSquare();
        }, chessGame.getBoardSize());
    }

    public void update(OrthographicCamera gameCamera, boolean isFlipped){
        chessOverlay.update(chessGame, gameCamera, isFlipped);
    }

    public void render(OrthographicCamera gameCamera, boolean isFlipped){
        shapeRenderer.setProjectionMatrix(gameCamera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int y = 0; y < chessGame.getBoardSize(); y++){
            for(int x = 0; x < chessGame.getBoardSize(); x++){

                if((x % 2 == 0) == (y % 2 == 0)){
                    shapeRenderer.setColor(DARK_SQUARE);
                }else{
                    shapeRenderer.setColor(LIGHT_SQUARE);
                }

                drawSquare(x, y);
            }
        }
        shapeRenderer.end();

        chessOverlay.render(chessGame, shapeRenderer, isFlipped);
    }

    private void drawSquare(int x, int y){
        shapeRenderer.rect(bounds.x + x * 32, bounds.y + y * 32, 32, 32);
    }

    public void dispose(){
        shapeRenderer.dispose();
    }
}
