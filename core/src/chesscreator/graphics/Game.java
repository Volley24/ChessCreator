package chesscreator.graphics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	private GameView gameView;

	private Texture checkerWhite, checkerBlack;
	
	@Override
	public void create() {
		gameView = new GameView(1.0f);

		checkerWhite = new Texture("checker-white.png");
		checkerBlack = new Texture("checker-black.png");
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.BLACK);

		SpriteBatch spriteBatch = gameView.spriteBatch;

		spriteBatch.begin();
		spriteBatch.draw(checkerWhite, 0, 0);
		spriteBatch.draw(checkerBlack, 64, 0);
		spriteBatch.end();
	}
	
	@Override
	public void dispose() {
		gameView.dispose();
		checkerWhite.dispose();
	}

	private void init(){

	}
}
