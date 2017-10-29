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
        segments = new LinkedList<Fixture>();
        reset(world, position, area, momentum);
    }

    public void reset(World world, Vector2 position, float area, Vector2 momentum) {
        segments.clear();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        createFixtures(body, 5);
    }

    private void createFixtures(Body body, int numberOfFixtures) {
        List<Vector2> points = new LinkedList<Vector2>();
        points.add(randomPoint());
        points.add(randomPoint());

        // Create subsequent fixtures using two of the previous points
        for (int i = 0; i < numberOfFixtures; i++) {
            Vector2 randomPoint = randomPoint();
            while (!pointIsValid(randomPoint, points)) {
                randomPoint = randomPoint();
            }
            points.add(randomPoint);

            // Last 2 points added
            Vector2[] vertices = new Vector2[3];
            vertices = points.subList(points.size() - 3, points.size()).toArray(vertices);
            PolygonShape triangle = new PolygonShape();
            triangle.set(vertices);

            // Create the next fixture
            FixtureDef fixtureDef = new FixtureDef();
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

    // Check if the point is outside of the asteroid's shape
    private boolean pointIsValid(Vector2 point, List<Vector2> points) {
        for (int i = 0; i < points.size() - 2; i++) {
            if (pointInTriangle(point, points.get(i), points.get(i + 1), points.get(i + 2))) {
                return false;
            }
        }
        return true;
    }

    // Check if a point is in a triangle
    private boolean pointInTriangle(Vector2 point, Vector2 a, Vector2 b, Vector2 c) {
        boolean bool = (b.x - a.x) * point.y - (b.y - a.y) * point.x > 0;
        if ((c.x - a.x) * point.y - (c.y - a.y) * point.x > 0 == bool) {
            return false;
        }
        if ((c.x - b.x) * (point.y - b.y) - (c.y - b.y) * (point.x - b.x) > 0 != bool) {
            return false;
        }
        return true;
    }
}
