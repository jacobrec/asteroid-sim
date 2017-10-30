package com.chair49.asteroids.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by jacob on 30/10/17.
 */
public class GUI {
    Batch batch;
    BitmapFont font;

    public GUI() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("cmunbl.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        font = generator.generateFont(parameter);
        generator.dispose();
        batch = new SpriteBatch();
    }

    public void render(int count) {
        // Render asteroid count
        batch.setColor(1f, 0f, 0f, 1f);
        batch.begin();
        font.draw(batch, String.valueOf(count), 25, 100);
        batch.end();
    }
}
