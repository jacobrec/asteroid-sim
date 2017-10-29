package com.chair49.astroids.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.chair49.astroids.controller.FieldController;
import com.chair49.astroids.model.AsteroidField;
import com.chair49.astroids.view.FieldRenderer;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidScreen implements Screen {
    FieldController controller;
    AsteroidField model;
    FieldRenderer view;
    int asteroidCount = 10;

    @Override
    public void show() {
        model = new AsteroidField(asteroidCount);
        controller = new FieldController(model);
        view = new FieldRenderer();
    }

    @Override
    public void render(float delta) {
        controller.update(model, delta);
        view.render(model, delta);
        // Reset if space is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            model = new AsteroidField(asteroidCount);
            controller = new FieldController(model);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            // Add an asteroid
            asteroidCount++;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            // Subtract an asteroid
            asteroidCount--;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
