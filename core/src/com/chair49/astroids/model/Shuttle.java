package com.chair49.astroids.model;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by jacob on 29/10/17.
 */
public class Shuttle extends Collidable {
    public Shuttle(World world) {
        // Create the body for our shuttle
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        Vector2 position = new Vector2(8, 4.5f);
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        createShuttle(body);
    }

    // Create a polygon to represent the asteroid
    private void createShuttle(Body body) {
        Vector2[] points = new Vector2[3];
        points[0] = new Vector2(0, 0);
        points[1] = new Vector2(-0.25f, -0.5f);
        points[2] = new Vector2(0.25f, -0.5f);

        PolygonShape polygon = new PolygonShape();
        polygon.set(points);

        // Create the next fixture
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygon;
        fixtureDef.density = 5f;
        fixtureDef.friction = MathUtils.random(0.1f, 5f);
        fixtureDef.restitution = MathUtils.random(0.1f, 0.9f); // Make it bounce a little bit
        body.createFixture(fixtureDef);
    }

    // Set the velocity of the asteroid
    public void setVelocity(Vector2 velocity) {
        this.body.setLinearVelocity(velocity);
    }
}
