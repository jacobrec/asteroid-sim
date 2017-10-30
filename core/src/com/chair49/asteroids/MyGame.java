package com.chair49.asteroids;

import com.badlogic.gdx.Game;
import com.chair49.asteroids.screens.AsteroidScreen;

public class MyGame extends Game {

    @Override
    public void create() {
        this.setScreen(new AsteroidScreen());
    }
}
