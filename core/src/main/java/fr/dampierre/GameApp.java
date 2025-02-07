package fr.dampierre;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameApp extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Rectangle marioBounds;
    private boolean marioClicked;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("mario.png");
        marioBounds = new Rectangle(100, 100, 83, 95); // Position initiale de Mario
        marioClicked = false;
        font = new BitmapFont(); // Police pour afficher "GAGNÉ !"
    }

    @Override
    public void render() {
        Vector2 clic = null;
        if (Gdx.input.isTouched()) {
            clic = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            clic.y = Gdx.graphics.getHeight() - clic.y; // Ajustement Y

            if (marioBounds.contains(clic)) {
                marioClicked = true;
            }
        }

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        if (marioClicked) {
            font.draw(batch, "Gagné", Gdx.graphics.getWidth() / 2f - 30, Gdx.graphics.getHeight() / 2f);
        } else {
            batch.draw(image, marioBounds.x, marioBounds.y, marioBounds.getWidth(), marioBounds.getHeight());
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}