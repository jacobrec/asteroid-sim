package com.chair49.astroids.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;
import com.chair49.astroids.model.Shuttle;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldRenderer {
    OrthographicCamera cam;
    ShapeRenderer sr;
    Box2DDebugRenderer debug;


    public FieldRenderer() {
        // Creates new camera object, needed for the shape renderer
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 16, 9);

        sr = new ShapeRenderer();
        sr.setProjectionMatrix(cam.combined);

        debug = new Box2DDebugRenderer();
        sr.setColor(0.2f, 1f, 0.2f, 1);

    }

    public void render(AsteroidField model, float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        sr.begin(ShapeRenderer.ShapeType.Line);
        for (Asteroid asteroid : model.asteroids) {
            drawAsteroid(asteroid);
        }
        sr.end();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        drawShuttle(model.shuttle);
        sr.end();


        //debug.render(model.getWorld(), cam.combined);
    }

    private void drawShuttle(Shuttle asteroid) {
        for (int i = 0; i < asteroid.getBody().getFixtureList().size; i++) {
            PolygonShape shape = (PolygonShape) asteroid.getBody().getFixtureList().get(i).getShape();
            float[] vertices = new float[shape.getVertexCount() * 2];

            Vector2 point = new Vector2();
            for (int j = 0; j < shape.getVertexCount(); j++) {
                shape.getVertex(j, point);
                vertices[2 * j] = point.x;
                vertices[2 * j + 1] = point.y;
            }
            Vector2 position = asteroid.getBody().getPosition();
            float angle = asteroid.getBody().getAngle();

            sr.identity();
            sr.translate(position.x, position.y, 0);
            sr.rotate(0, 0, 1, angle * MathUtils.radiansToDegrees);
            sr.triangle(vertices[0], vertices[1], vertices[2], vertices[3], vertices[4], vertices[5]);
        }
    }

    private void drawAsteroid(Asteroid asteroid) {
        for (int i = 0; i < asteroid.getBody().getFixtureList().size; i++) {
            PolygonShape shape = (PolygonShape) asteroid.getBody().getFixtureList().get(i).getShape();
            float[] vertices = new float[shape.getVertexCount() * 2];

            Vector2 point = new Vector2();
            for (int j = 0; j < shape.getVertexCount(); j++) {
                shape.getVertex(j, point);
                vertices[2 * j] = point.x;
                vertices[2 * j + 1] = point.y;
            }
            Vector2 position = asteroid.getBody().getPosition();
            float angle = asteroid.getBody().getAngle();

            sr.identity();
            sr.translate(position.x, position.y, 0);
            sr.rotate(0, 0, 1, angle * MathUtils.radiansToDegrees);
            sr.polygon(vertices);
        }
    }
}
