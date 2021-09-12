package chesscreator.graphics;

import chesscreator.chess.ChessBoard;
import chesscreator.chess.ChessGame;
import chesscreator.graphics.chess_graphics.GraphicalChessRenderer;
import chesscreator.version.DevStage;
import chesscreator.version.Version;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	private final String name = "ChessCreator";
	private final Version version = new Version(DevStage.ALPHA, "3.0");

	private SpriteBatch spriteBatch;
	private OrthographicCamera gameCamera, uiCamera;

	private ChessGame chessGame;
	private GraphicalChessRenderer chessRenderer;
	
	@Override
	public void create() {
		Textures.init();

		spriteBatch = new SpriteBatch();

		gameCamera = new OrthographicCamera();
		gameCamera.setToOrtho(false);
		gameCamera.zoom = 0.5f;

		chessGame = new ChessGame();
		chessRenderer = new GraphicalChessRenderer(chessGame);
	}

	@Override
	public void render() {
		clearScreen(true);
		if(Gdx.input.isKeyPressed(Input.Keys.EQUALS)){
			gameCamera.zoom -= 0.01f;
		}else if(Gdx.input.isKeyPressed(Input.Keys.MINUS)){
			gameCamera.zoom += 0.01f;
		}

		gameCamera.update();

		chessRenderer.update(gameCamera);
		chessRenderer.render(gameCamera, spriteBatch);
	}
	
	@Override
	public void dispose() {
		Textures.dispose();

		chessRenderer.dispose();
		spriteBatch.dispose();
	}

	public String getWindowTitle(){
		return name + " - " + version.toString();
	}

	private void clearScreen(boolean antiAliasing){
		if(antiAliasing){
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT
					| GL20.GL_DEPTH_BUFFER_BIT
					| (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
		}else{
			ScreenUtils.clear(Color.BLACK);
		}
	}


}
