package chesscreator.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameView {
    public SpriteBatch spriteBatch;
    public OrthographicCamera gameCamera;

    public GameView(float zoom){
        this.spriteBatch = new SpriteBatch();
        this.gameCamera = new OrthographicCamera();

        gameCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        gameCamera.zoom = zoom;
        gameCamera.update();
    }

    public void setBatchRelativeToCamera(){
        spriteBatch.setProjectionMatrix(gameCamera.combined);
    }

    public void dispose(){
        spriteBatch.dispose();
    }
}
