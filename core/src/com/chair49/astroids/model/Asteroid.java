package com.chair49.astroids.model;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by jacob on 29/10/17.
 */
public class Asteroid extends Collidable {
    float density = MathUtils.random(0.1f, 5f);

    public boolean killMe;

    public Asteroid(World world, Vector2 position, float area, Vector2 momentum) {
        reset(world, position, area, momentum);
    }

    public void reset(World world, Vector2 position, float area, Vector2 momentum) {
        // Create the body for our asteroid
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        killMe = false;

        float radius = (float) Math.sqrt(area / Math.PI);
        createAsteroidShape(body, radius);

        // Using the momentum, density, and area, calculate the new velocity.
        Vector2 velocity = new Vector2(momentum.x / (density * area), momentum.y / (density * area));
        setVelocity(velocity);
    }

    // Create a polygon to represent the asteroid
    private void createAsteroidShape(Body body, float radius) {
        final int pointCount = 8;
        Vector2[] points = new Vector2[pointCount];
        for (int i = 0; i < pointCount; i++) {
            points[i] = randomPoint(radius, (float) (i * Math.PI / 4));
        }
        PolygonShape polygon = new PolygonShape();
        polygon.set(points);

        // Create the next fixture
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygon;
        fixtureDef.density = density;
        fixtureDef.friction = MathUtils.random(0.1f, 5f);
        fixtureDef.restitution = MathUtils.random(0.1f, 0.9f); // Make it bounce a little bit
        body.createFixture(fixtureDef);
    }

    // Returns a random point
    public Vector2 randomPoint(float radius, float angle) {
        radius = radius + MathUtils.random(-1f, 1f);
        return new Vector2(radius * MathUtils.cos(angle), radius * MathUtils.sin(angle));
    }

    // Set the velocity of the asteroid
    public void setVelocity(Vector2 velocity) {
        this.body.setLinearVelocity(velocity);
    }
}
