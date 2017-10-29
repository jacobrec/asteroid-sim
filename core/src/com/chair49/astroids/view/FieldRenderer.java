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

    }

    public void render(AsteroidField model, float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);



        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (Asteroid ast : model.asteroids) {
            drawAsteroid(ast);
        }
        sr.end();
        //debug.render(model.getWorld(), cam.combined);
    }

    private void drawAsteroid(Asteroid ast) {
        for (int i = 0; i < ast.getBody().getFixtureList().size; i++) {

            PolygonShape shape = (PolygonShape) ast.getBody().getFixtureList().get(i).getShape();
            float[] verts = new float[6];
            Vector2 point = new Vector2();
            for (int j = 0; j < 3; j++) {
                shape.getVertex(j, point);
                verts[2*j] = point.x;
                verts[2*j + 1] = point.y;

            }
            Vector2 pos = ast.getBody().getPosition();
            float angle = ast.getBody().getAngle();

            sr.identity();

            sr.translate(pos.x, pos.y, 0);
            sr.rotate(0,0,1, angle * MathUtils.radiansToDegrees);
            sr.triangle(verts[0],verts[1],verts[2],verts[3],verts[4],verts[5]);
        }
    }
}
