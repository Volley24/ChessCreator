package chesscreator.graphics;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;

public class Textures {
    public static ArrayList<Texture> chessPieceTextures = new ArrayList<>();

    public static void init(){
        chessPieceTextures.addAll(Arrays.asList(
                new Texture("white-pawn.png"),
                new Texture("white-knight.png"),
                new Texture("white-bishop.png"),
                new Texture("white-rook.png"),
                new Texture("white-queen.png"),
                new Texture("white-king.png"),

                new Texture("black-pawn.png"),
                new Texture("black-knight.png"),
                new Texture("black-bishop.png"),
                new Texture("black-rook.png"),
                new Texture("black-queen.png"),
                new Texture("black-king.png")));
    }

    public static void dispose(){
        for(Texture texture : chessPieceTextures){
            texture.dispose();
        }
    }
}
