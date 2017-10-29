package com.chair49.astroids.model;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class Asteroid extends Collidable {

    public Asteroid(World world, Vector2 position, float area, Vector2 momentum) {
        reset(world, position, area, momentum);
    }

    public void reset(World world, Vector2 position, float area, Vector2 momentum) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        createFixtures(body);
    }

    private void createFixtures(Body body) {
        final int pointCount = 8;
        Vector2[] points = new Vector2[pointCount];
        for (int i = 0; i < pointCount; i++) {
            points[i] = randomPoint();
        }
        PolygonShape polygon = new PolygonShape();
        polygon.set(points);

        // Create the next fixture
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygon;
        fixtureDef.density = MathUtils.random(0.1f, 5f);
        fixtureDef.friction = MathUtils.random(0.1f, 5f);
        fixtureDef.restitution = MathUtils.random(0.1f, 0.9f); // Make it bounce a little bit
        body.createFixture(fixtureDef);
    }

    public Vector2 randomPoint() {
        return new Vector2(MathUtils.random(), MathUtils.random());
    }

    public void setVelocity(Vector2 velocity) {
        this.body.setLinearVelocity(velocity);
    }
}
