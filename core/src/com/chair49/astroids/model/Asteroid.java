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

    public Asteroid(World world, Vector2 position, float area) {
        segments = new LinkedList<Fixture>();
        reset(world, position, area);
    }

    public void reset(World world, Vector2 position, float area) {
        segments.clear();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        createFixtures(body, 5);
    }

    private void createFixtures(Body body, int numberOfFixtures) {
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape triangle = new PolygonShape();

        Vector2[] vertices = new Vector2[3];
        List<Vector2> points = new LinkedList<Vector2>();
        points.add(randomPoint());
        points.add(randomPoint());

        for (int i = 0; i < numberOfFixtures; i++) {
            points.add(randomPoint());

            // Last 2 points added
            vertices = points.subList(points.size() - 3, points.size()).toArray(vertices);
            triangle.set(vertices);

            fixtureDef.shape = triangle;
            fixtureDef.density = MathUtils.random(0.1f, 5f);
            fixtureDef.friction = MathUtils.random(0.1f, 5f);
            fixtureDef.restitution = MathUtils.random(0.1f, 0.9f); // Make it bounce a little bit

            segments.add(body.createFixture(fixtureDef));
        }
    }

    public Vector2 randomPoint() {
        return new Vector2(MathUtils.random(), MathUtils.random());
    }

    public void setVelocity(Vector2 velocity) {
        this.body.setLinearVelocity(velocity);
    }
}
