package chesscreator.graphics.chess_graphics;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.ChessGame;
import chesscreator.chess.piece.ChessPiece;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GraphicalChessRenderer extends ChessRenderer{
    private final CheckeredBoard checkeredBoard;

    private final float x, y;
    private final int size = 32;

    private boolean whitePerspective = true;

    public GraphicalChessRenderer(ChessGame chessGame) {
        super(chessGame);

        x = (Gdx.graphics.getWidth()/2f) - (size * chessBoard.getBoardSize() / 2f);
        y = (Gdx.graphics.getHeight()/2f) - (size * chessBoard.getBoardSize() / 2f);

        checkeredBoard = new CheckeredBoard(chessGame, x, y, size);
    }

    public void update(OrthographicCamera gameCamera){
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            chessBoard.setupBoard(ChessBoard.STARTING_POSITION_FEN);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.F)){
            whitePerspective = !whitePerspective;
        }
        checkeredBoard.update(gameCamera, whitePerspective);
    }

    public void render(OrthographicCamera gameCamera, Batch batch){
        checkeredBoard.render(gameCamera, whitePerspective);

        batch.setProjectionMatrix(gameCamera.combined);
        batch.begin();
        for(int y = 0; y < chessBoard.getBoardSize(); y++){
            for(int x = 0; x < chessBoard.getBoardSize(); x++){
                int realX = (whitePerspective ? x : chessBoard.flipCoordinate(x));
                int realY = (whitePerspective ? chessBoard.flipCoordinate(y) : y);


                ChessPiece chessPiece = chessBoard.getPiece(realX, realY);
                if(chessPiece != null){
                    batch.draw(chessPiece.getTexture(), this.x + x * size, this.y + y * size);
                }

            }
        }
        batch.end();

    }

    public void dispose(){
        checkeredBoard.dispose();
    }
}
