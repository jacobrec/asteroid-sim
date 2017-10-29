package com.chair49.astroids.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldRenderer {
    ShapeRenderer sr;
    OrthographicCamera cam;

    public FieldRenderer(){
        // Creates new camera object, needed for the shape renderer
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 10, 10);

        // Shape renderer is used for drawing polygons and other geometric shapes
        sr = new ShapeRenderer();
        // This sets it to use the camera coordinates instead of the native screen coordinates
        sr.setProjectionMatrix(cam.combined);

    }

    public void render(AsteroidField model, float delta) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        for(Asteroid asteroid : model.asteroids){
            drawAsteroid(asteroid);
        }
        sr.end();
    }

    private void drawAsteroid(Asteroid asteroid) {
        sr.polygon(asteroid.getCollisionPolygon().getTransformedVertices());
    }
}
