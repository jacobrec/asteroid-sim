package com.chair49.asteroids.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by jacob on 30/10/17.
 */
public class DesktopInput extends Input {
    @Override
    public boolean isResetPressed() {
        return Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER);
    }

    @Override
    public boolean isIncreaseAsteroidsPressed() {
        return Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.PERIOD);
    }

    @Override
    public boolean isDecreaseAsteroidsPressed() {
        return Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.COMMA);
    }

    @Override
    public boolean isUpPressed() {
        return Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.UP);
    }

    @Override
    public boolean isDownPressed() {
        return Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.DOWN);
    }

    @Override
    public boolean isRightPressed() {
        return Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT);
    }

    @Override
    public boolean isLeftPressed() {
        return Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT);
    }

    @Override
    public boolean isFirePressed() {
        return Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE);
    }
}
