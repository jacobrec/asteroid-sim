package com.chair49.astroids.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldRenderer {
    OrthographicCamera cam;
    Box2DDebugRenderer debugRenderer;

    public FieldRenderer() {
        // Creates new camera object, needed for the shape renderer
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 16, 9);
        debugRenderer = new Box2DDebugRenderer();

    }

    public void render(AsteroidField model, float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        debugRenderer.render(model.getWorld(), cam.combined);
    }
}
