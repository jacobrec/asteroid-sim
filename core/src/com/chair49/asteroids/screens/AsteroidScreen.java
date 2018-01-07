package com.chair49.asteroids.screens;

import com.badlogic.gdx.Screen;
import com.chair49.asteroids.controller.FieldController;
import com.chair49.asteroids.input.DesktopInput;
import com.chair49.asteroids.input.Input;
import com.chair49.asteroids.model.AsteroidField;
import com.chair49.asteroids.view.FieldRenderer;
//import com.chair49.asteroids.view.GUI;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidScreen implements Screen {
    FieldController controller;
    AsteroidField model;
    FieldRenderer view;
//    GUI gui;

    Input input;


    @Override
    public void show() {
        model = new AsteroidField();

        controller = new FieldController();
        controller.setupWorld(model);

//        gui = new GUI();
        view = new FieldRenderer();

        input = new DesktopInput();
    }

    @Override
    public void render(float delta) {
        controller.update(model, delta);
        view.render(model, delta);
//        gui.render(controller.asteroidCount);
        input.handleInput(controller, model);
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
