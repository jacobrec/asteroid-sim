package com.chair49.astroids.screens;

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

    @Override
    public void show() {
        model = new AsteroidField();
        controller = new FieldController(model);
        view = new FieldRenderer();
    }

    @Override
    public void render(float delta) {
        controller.update(model, delta);
        view.render(model, delta);
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
