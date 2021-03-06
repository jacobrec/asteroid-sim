package com.chair49.astroids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.chair49.astroids.MyGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 3840;
        config.height = 2160;
        config.fullscreen = true;

        new LwjglApplication(new MyGame(), config);
    }
}
