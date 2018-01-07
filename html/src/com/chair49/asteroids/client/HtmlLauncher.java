package com.chair49.asteroids.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.math.MathUtils;
import com.chair49.asteroids.MyGame;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;

public class HtmlLauncher extends GwtApplication {

    @Override
    public void onModuleLoad() {
        super.onModuleLoad();
        com.google.gwt.user.client.Window.addResizeHandler(new ResizeHandler() {
            public void onResize(ResizeEvent event) {
                int min = Math.min(event.getWidth(), event.getHeight());
                Gdx.graphics.setWindowedMode(min * 16 / 9, min);
            }
        });
    }

    @Override
    public GwtApplicationConfiguration getConfig() {
        int height = com.google.gwt.user.client.Window.getClientHeight();
        int width = com.google.gwt.user.client.Window.getClientWidth();
        int min = Math.min(width, height);
        return new GwtApplicationConfiguration(min * 16 / 9, min);
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new MyGame();
    }
}