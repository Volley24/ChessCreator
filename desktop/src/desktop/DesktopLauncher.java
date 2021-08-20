package desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import chesscreator.graphics.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Game game = new Game();

		config.title = "Chess Creator - v.0.0-alpha";
		config.width = 1080;
		config.height = 1080 / 16 * 9;
		config.resizable = false;

		new LwjglApplication(game, config);
	}
}
