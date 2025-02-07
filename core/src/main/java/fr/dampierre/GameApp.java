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
import com.badlogic.gdx.math.MathUtils;

public class GameApp extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture marioImage;
    private Texture luigiImage;
    private Texture warioImage;
    private Texture yoshiImage;
    private Rectangle marioBounds;
    private Rectangle luigiBounds;
    private Rectangle warioBounds;
    private Rectangle yoshiBounds;
    private boolean marioClicked;
    private boolean luigiClicked;
    private boolean warioClicked;
    private boolean yoshiClicked;
    private boolean gagne;
    private boolean perdu;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        marioImage = new Texture("mario.png");
        luigiImage = new Texture("luigi.png");
        warioImage = new Texture("wario.png");
        yoshiImage = new Texture("yoshi.png");
        marioBounds = new Rectangle(MathUtils.random(0, Gdx.graphics.getWidth() - 83),
                MathUtils.random(0, Gdx.graphics.getHeight() - 95), 83, 95);
        luigiBounds = new Rectangle(MathUtils.random(0, Gdx.graphics.getWidth() - 83),
                MathUtils.random(0, Gdx.graphics.getHeight() - 95), 83, 95);
        warioBounds = new Rectangle(MathUtils.random(0, Gdx.graphics.getWidth() - 83),
                MathUtils.random(0, Gdx.graphics.getHeight() - 95), 83, 95);
        yoshiBounds = new Rectangle(MathUtils.random(0, Gdx.graphics.getWidth() - 83),
                MathUtils.random(0, Gdx.graphics.getHeight() - 95), 83, 95);
        marioClicked = false;
        luigiClicked = false;
        warioClicked = false;
        yoshiClicked = false;
        gagne = false;
        perdu = false;
        font = new BitmapFont();
    }

    @Override
    public void render() {
        Vector2 clic = null;
        if (Gdx.input.isTouched()) {
            clic = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            clic.y = Gdx.graphics.getHeight() - clic.y; // Ajustement Y

            if (marioBounds.contains(clic)) {
                marioClicked = true;
            } else if (luigiBounds.contains(clic)) {
                luigiClicked = true;
            } else if (warioBounds.contains(clic)) {
                warioClicked = true;
            } else if (yoshiBounds.contains(clic)) {
                yoshiClicked = true;
            }
        }

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        if (marioClicked) {
            font.draw(batch, "Gagné!", Gdx.graphics.getWidth() / 2f - 30, Gdx.graphics.getHeight() / 2f);
            gagne = true;
        }
        if (luigiClicked) {
            font.draw(batch, "Perdu!", Gdx.graphics.getWidth() / 2f - 30, Gdx.graphics.getHeight() / 2f);
            perdu = true;
        }
        if (warioClicked) {
            font.draw(batch, "Perdu!", Gdx.graphics.getWidth() / 2f - 30, Gdx.graphics.getHeight() / 2f);
            perdu = true;
        }
        if (yoshiClicked) {
            font.draw(batch, "Perdu!", Gdx.graphics.getWidth() / 2f - 30, Gdx.graphics.getHeight() / 2f);
            perdu = true;
        }

        if (gagne == false || perdu == false) {
            batch.draw(marioImage, marioBounds.x, marioBounds.y, marioBounds.getWidth(), marioBounds.getHeight());
            batch.draw(luigiImage, luigiBounds.x, luigiBounds.y, luigiBounds.getWidth(), luigiBounds.getHeight());
            batch.draw(warioImage, warioBounds.x, warioBounds.y, warioBounds.getWidth(), warioBounds.getHeight());
            batch.draw(yoshiImage, yoshiBounds.x, yoshiBounds.y, yoshiBounds.getWidth(), yoshiBounds.getHeight());
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        marioImage.dispose();
        font.dispose();
        batch.dispose();
        luigiImage.dispose();
        font.dispose();
        batch.dispose();
        warioImage.dispose();
        font.dispose();
        batch.dispose();
        yoshiImage.dispose();
        font.dispose();
    }
}