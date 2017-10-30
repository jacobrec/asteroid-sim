package com.chair49.astroids;

import com.badlogic.gdx.Game;
import com.chair49.astroids.screens.AsteroidScreen;

public class MyGame extends Game {

    @Override
    public void create() {
        this.setScreen(new AsteroidScreen());
    }
}
