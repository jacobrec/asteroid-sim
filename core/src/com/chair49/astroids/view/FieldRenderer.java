package com.chair49.astroids.view;

import com.badlogic.gdx.Gdx;
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
    ShapeRenderer sr;
    OrthographicCamera cam;
    Box2DDebugRenderer debugRenderer;

    float box_to_world;
    Matrix4 debugMatrix;

    public FieldRenderer() {
        // Creates new camera object, needed for the shape renderer
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 16, 9);

        // Shape renderer is used for drawing polygons and other geometric shapes
        sr = new ShapeRenderer();
        // This sets it to use the camera coordinates instead of the native screen coordinates
        sr.setProjectionMatrix(cam.combined);

        box_to_world = Gdx.graphics.getWidth() / cam.viewportWidth;

        debugMatrix = new Matrix4(cam.combined);
        debugMatrix.scale(box_to_world, box_to_world, 1f);

        debugRenderer = new Box2DDebugRenderer();

    }

    public void render(AsteroidField model, float delta) {

        debugRenderer.render(model.getWorld(), debugMatrix);

// Use this if we want more control over rendering
//        sr.begin(ShapeRenderer.ShapeType.Line);
//        for (Asteroid asteroid : model.asteroids) {
//            drawAsteroid(asteroid);
//        }
//        sr.end();
    }

    private void drawAsteroid(Asteroid asteroid) {
        sr.polygon(asteroid.getCollisionPolygon().getTransformedVertices());
    }
}
